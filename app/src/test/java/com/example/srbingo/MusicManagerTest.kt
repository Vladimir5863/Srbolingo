package com.example.srbingo

import android.content.Context
import android.media.MediaPlayer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.srbingo.utils.MusicManager
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.After

@RunWith(AndroidJUnit4::class)
class MusicManagerTest {
    private lateinit var context: Context
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var musicManager: MusicManager

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        mediaPlayer = mockk(relaxed = true)
        
        // Mock MediaPlayer.create() using mockk
        mockkStatic(MediaPlayer::class)
        every { MediaPlayer.create(any<Context>(), any<Int>()) } returns mediaPlayer
        every { mediaPlayer.isLooping } returns true
    }

    @After
    fun tearDown() {
        if (::musicManager.isInitialized) {
            musicManager.release()
        }
        // Reset the singleton instance for other tests
         MusicManager::class.java.getDeclaredField("instance").apply {
            isAccessible = true
            set(null, null)
        }
    }

    @Test
    fun `test music initialization`() {
        musicManager = MusicManager.getInstance(context)
        assertNotNull(musicManager)
        verify { MediaPlayer.create(any<Context>(), any<Int>()) }
    }

    @Test
    fun `test music start and pause`() {
        musicManager = MusicManager.getInstance(context)
        
        // Test start
        musicManager.startMusic()
        verify { mediaPlayer.start() }
        
        // Test pause
        musicManager.pauseMusic()
        verify { mediaPlayer.pause() }
    }

    @Test
    fun `test music release`() {
        musicManager = MusicManager.getInstance(context)
        musicManager.release()
        
        verify { mediaPlayer.release() }
    }

    @Test
    fun `test singleton instance`() {
        // Clear any existing instance
        MusicManager::class.java.getDeclaredField("instance").apply {
            isAccessible = true
            set(null, null)
        }
        
        val instance1 = MusicManager.getInstance(context)
        val instance2 = MusicManager.getInstance(context)
        
        assertSame("Should return the same instance", instance1, instance2)
    }
} 