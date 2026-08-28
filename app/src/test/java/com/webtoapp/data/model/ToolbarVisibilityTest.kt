package com.webtoapp.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ToolbarVisibilityTest {

    @Test
    fun `normal mode always shows the full button set even when toolbar flags are all false`() {
        // A fresh app in normal mode never has the toolbar flags hit; but a config that
        // was polluted by toggling "hide toolbar" on then off leaves every flag false.
        // The renderer must still show the full toolbar in normal (non-hide) mode.
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = false,
            browserToolbarCustomized = true,
            toolbarShowTitle = false,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = false,
            toolbarShowRefresh = false,
            toolbarShowConsole = true,
            toolbarShowFind = true
        )

        assertThat(visibility.showTitle).isTrue()
        assertThat(visibility.showUrl).isTrue()
        assertThat(visibility.showBack).isTrue()
        assertThat(visibility.showForward).isTrue()
        assertThat(visibility.showRefresh).isTrue()
        assertThat(visibility.showConsoleButton).isTrue()
    }

    @Test
    fun `customized slim mode applies the toolbar flags`() {
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = true,
            browserToolbarCustomized = true,
            toolbarShowTitle = true,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = true,
            toolbarShowRefresh = false,
            toolbarShowConsole = true,
            toolbarShowFind = true
        )

        assertThat(visibility.showTitle).isTrue()
        assertThat(visibility.showUrl).isFalse()
        assertThat(visibility.showBack).isFalse()
        assertThat(visibility.showForward).isTrue()
        assertThat(visibility.showRefresh).isFalse()
        assertThat(visibility.showConsoleButton).isTrue()
    }

    @Test
    fun `slim mode keeps console on its own toggle`() {
        // The five navigation toggles off no longer force console off — it has
        // its own switch now.
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = true,
            browserToolbarCustomized = true,
            toolbarShowTitle = false,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = false,
            toolbarShowRefresh = false,
            toolbarShowConsole = true,
            toolbarShowFind = true
        )

        assertThat(visibility.showTitle).isFalse()
        assertThat(visibility.showUrl).isFalse()
        assertThat(visibility.showBack).isFalse()
        assertThat(visibility.showForward).isFalse()
        assertThat(visibility.showRefresh).isFalse()
        assertThat(visibility.showConsoleButton).isTrue()
    }

    @Test
    fun `slim mode hides console when its toggle is off`() {
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = true,
            browserToolbarCustomized = true,
            toolbarShowTitle = true,
            toolbarShowUrl = true,
            toolbarShowBack = true,
            toolbarShowForward = true,
            toolbarShowRefresh = true,
            toolbarShowConsole = false,
            toolbarShowFind = true
        )

        assertThat(visibility.showConsoleButton).isFalse()
        assertThat(visibility.showTitle).isTrue()
    }

    @Test
    fun `slim mode hides find when its toggle is off`() {
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = true,
            browserToolbarCustomized = true,
            toolbarShowTitle = true,
            toolbarShowUrl = true,
            toolbarShowBack = true,
            toolbarShowForward = true,
            toolbarShowRefresh = true,
            toolbarShowConsole = true,
            toolbarShowFind = false
        )

        assertThat(visibility.showFind).isFalse()
    }

    @Test
    fun `normal mode ignores the find toggle`() {
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = false,
            browserToolbarCustomized = false,
            toolbarShowTitle = false,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = false,
            toolbarShowRefresh = false,
            toolbarShowConsole = true,
            toolbarShowFind = false
        )

        assertThat(visibility.showFind).isTrue()
    }

    @Test
    fun `normal mode ignores the console toggle`() {
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = false,
            browserToolbarCustomized = false,
            toolbarShowTitle = false,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = false,
            toolbarShowRefresh = false,
            toolbarShowConsole = false,
            toolbarShowFind = true
        )

        assertThat(visibility.showConsoleButton).isTrue()
    }

    @Test
    fun `hide toolbar on but not customized behaves as normal full toolbar`() {
        // hideBrowserToolbar = true but browserToolbarCustomized = false: the slim
        // toolbar is not shown (showSlimToolbar is false), so the full button set wins.
        val visibility = resolveToolbarButtons(
            hideBrowserToolbar = true,
            browserToolbarCustomized = false,
            toolbarShowTitle = false,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = false,
            toolbarShowRefresh = false,
            toolbarShowConsole = true,
            toolbarShowFind = true
        )

        assertThat(visibility.showTitle).isTrue()
        assertThat(visibility.showBack).isTrue()
        assertThat(visibility.showRefresh).isTrue()
        assertThat(visibility.showConsoleButton).isTrue()
    }

    @Test
    fun `slim toolbar with only console enabled still has content`() {
        // Regression: the slim-toolbar gate in both the preview and the exported shell
        // used to count only the five navigation items, so a toolbar customized down
        // to just the console button rendered as a completely hidden top bar.
        val hasContent = hasAnySlimToolbarItem(
            toolbarShowTitle = false,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = false,
            toolbarShowRefresh = false,
            toolbarShowConsole = true,
            toolbarShowFind = false
        )

        assertThat(hasContent).isTrue()
    }

    @Test
    fun `slim toolbar with every item off is empty`() {
        val hasContent = hasAnySlimToolbarItem(
            toolbarShowTitle = false,
            toolbarShowUrl = false,
            toolbarShowBack = false,
            toolbarShowForward = false,
            toolbarShowRefresh = false,
            toolbarShowConsole = false,
            toolbarShowFind = false
        )

        assertThat(hasContent).isFalse()
    }
}
