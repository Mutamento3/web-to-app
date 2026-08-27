package com.webtoapp.core.webview

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PageZoomTest {

    @Test
    fun `normalize clamps into the supported percent window`() {
        assertEquals(25, PageZoom.normalize(1))
        assertEquals(150, PageZoom.normalize(150))
        assertEquals(300, PageZoom.normalize(9999))
    }

    @Test
    fun `runtime override wins over build-time default`() {
        assertEquals(
            125,
            PageZoom.resolvePercent(configuredPercent = 75, runtimeOverridePercent = 125)
        )
    }

    @Test
    fun `build-time default applies when no runtime override exists`() {
        assertEquals(
            75,
            PageZoom.resolvePercent(configuredPercent = 75, runtimeOverridePercent = 0)
        )
        assertEquals(
            100,
            PageZoom.resolvePercent(configuredPercent = 100, runtimeOverridePercent = 0)
        )
        // Legacy configs may carry a stored "reset" (0): treat as no zoom.
        assertEquals(
            100,
            PageZoom.resolvePercent(configuredPercent = 0, runtimeOverridePercent = 0)
        )
    }

    @Test
    fun `apply script sets important root zoom`() {
        val script = PageZoom.jsApplyScript(75)
        assertTrue(script.contains("75%"))
        assertTrue(script.contains("'important'"))
        assertFalse(script.contains("removeProperty"))
    }

    @Test
    fun `default percent clears applied root zoom`() {
        val script = PageZoom.jsApplyScript(PageZoom.DEFAULT_PERCENT)
        assertTrue(script.contains("removeProperty('zoom')"))
        assertFalse(script.contains("setProperty"))
    }
}
