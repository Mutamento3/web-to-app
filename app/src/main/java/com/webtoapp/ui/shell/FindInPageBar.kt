package com.webtoapp.ui.shell

import android.webkit.WebView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.webtoapp.core.i18n.Strings
import com.webtoapp.core.logging.AppLogger

/**
 * Native find-in-page bottom bar (issue #614). Drives the WebView engine directly
 * (findAllAsync / findNext / clearMatches) instead of going through the JS module
 * panel, so match counting and highlighting are handled by the engine itself.
 *
 * Android-WebView only: findAllAsync has no GeckoView equivalent here — callers
 * hide the toolbar entry for non-system kernels.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindInPageBar(
    webView: WebView?,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }
    var activeMatchOrdinal by remember { mutableIntStateOf(-1) }
    var numberOfMatches by remember { mutableIntStateOf(0) }
    var doneCounting by remember { mutableStateOf(true) }

    // Listen for engine-side counting results while the bar is up; detach (and drop
    // the highlights) when it goes away.
    DisposableEffect(webView) {
        webView?.setFindListener { active, total, done ->
            activeMatchOrdinal = if (total > 0) active else -1
            numberOfMatches = total
            doneCounting = done
        }
        onDispose {
            try {
                webView?.clearMatches()
                webView?.setFindListener(null)
            } catch (e: Exception) {
                AppLogger.w("FindInPageBar", "cleanup failed", e)
            }
        }
    }

    // Live search as the query changes (debounced), like Chrome's find bar.
    LaunchedEffect(query, webView) {
        val wv = webView ?: return@LaunchedEffect
        if (query.isBlank()) {
            wv.clearMatches()
            activeMatchOrdinal = -1
            numberOfMatches = 0
            doneCounting = true
            return@LaunchedEffect
        }
        kotlinx.coroutines.delay(300)
        try {
            wv.findAllAsync(query)
        } catch (e: Exception) {
            AppLogger.w("FindInPageBar", "findAllAsync failed", e)
        }
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )

            OutlinedTextField(
                value = query,
                onValueChange = { query = it.take(200) },
                placeholder = {
                    Text(
                        Strings.nativeBridgeCapsFindInPage,
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                modifier = Modifier.weight(1f),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (query.isNotBlank()) {
                            try { webView?.findNext(true) } catch (e: Exception) {
                                AppLogger.w("FindInPageBar", "findNext failed", e)
                            }
                        }
                    }
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary
                )
            )

            Text(
                text = if (query.isBlank() || numberOfMatches <= 0) {
                    "0/0"
                } else {
                    "${(activeMatchOrdinal + 1).coerceIn(1, numberOfMatches)}/$numberOfMatches" +
                        if (!doneCounting) "…" else ""
                },
                style = MaterialTheme.typography.labelMedium.copy(fontFamily = FontFamily.Monospace),
                color = if (numberOfMatches > 0) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                modifier = Modifier.padding(horizontal = 2.dp)
            )

            IconButton(
                onClick = {
                    if (query.isNotBlank()) {
                        try { webView?.findNext(false) } catch (e: Exception) {
                            AppLogger.w("FindInPageBar", "findNext failed", e)
                        }
                    }
                },
                enabled = numberOfMatches > 0,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(Icons.Filled.KeyboardArrowUp, Strings.codeEditorFindPrev, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }

            IconButton(
                onClick = {
                    if (query.isNotBlank()) {
                        try { webView?.findNext(true) } catch (e: Exception) {
                            AppLogger.w("FindInPageBar", "findNext failed", e)
                        }
                    }
                },
                enabled = numberOfMatches > 0,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(Icons.Filled.KeyboardArrowDown, Strings.codeEditorFindNext, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }

            IconButton(
                onClick = {
                    query = ""
                    onClose()
                },
                modifier = Modifier.size(36.dp)
            ) {
                Icon(Icons.Filled.Close, Strings.close, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
