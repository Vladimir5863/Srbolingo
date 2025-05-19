package com.example.srbingo

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import android.content.Intent
import com.example.srbingo.utils.MusicManager

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.srbingo", appContext.packageName)
    }

    @Test
    fun testMusicManager() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val musicManager = MusicManager.getInstance(appContext)
        
        // Test music controls
        musicManager.startMusic()
        musicManager.pauseMusic()
        musicManager.release()
    }

    @Test
    fun testLoginActivity() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = Intent(appContext, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        appContext.startActivity(intent)
    }
}