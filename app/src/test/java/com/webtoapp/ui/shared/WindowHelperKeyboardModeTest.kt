package com.webtoapp.ui.shared

import android.app.Activity
import android.view.WindowManager
import com.google.common.truth.Truth.assertThat
import com.webtoapp.data.model.KeyboardAdjustMode
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Regression coverage for issue #613: the RESIZE keyboard mode used to set
 * SOFT_INPUT_ADJUST_NOTHING on every device and rely on manual IME padding, but
 * androidx only reports IME insets on API < 30 when the window runs with
 * SOFT_INPUT_ADJUST_RESIZE — so on Android 10 and lower the padding stayed 0 and
 * the keyboard covered the focused input.
 */
class WindowHelperKeyboardModeTest {

    @RunWith(RobolectricTestRunner::class)
    @Config(sdk = [29])
    class PreApi30Test {

        @Test
        fun `resize mode falls back to system adjust resize below API 30`() {
            val activity = Robolectric.setupActivity(Activity::class.java)

            WindowHelper.applyImmersiveFullscreen(
                activity,
                enabled = false,
                keyboardAdjustMode = KeyboardAdjustMode.RESIZE
            )

            val mode = activity.window.attributes.softInputMode
            assertThat(mode and WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE).isNotEqualTo(0)
        }

        @Test
        fun `nothing mode keeps adjust nothing below API 30`() {
            val activity = Robolectric.setupActivity(Activity::class.java)

            WindowHelper.applyImmersiveFullscreen(
                activity,
                enabled = false,
                keyboardAdjustMode = KeyboardAdjustMode.NOTHING
            )

            val mode = activity.window.attributes.softInputMode
            assertThat(mode and WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING).isNotEqualTo(0)
        }
    }

    @RunWith(RobolectricTestRunner::class)
    @Config(sdk = [30])
    class Api30Test {

        @Test
        fun `resize mode keeps manual ime padding path on API 30+`() {
            val activity = Robolectric.setupActivity(Activity::class.java)

            WindowHelper.applyImmersiveFullscreen(
                activity,
                enabled = false,
                keyboardAdjustMode = KeyboardAdjustMode.RESIZE
            )

            val mode = activity.window.attributes.softInputMode
            assertThat(mode and WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING).isNotEqualTo(0)
        }
    }
}
