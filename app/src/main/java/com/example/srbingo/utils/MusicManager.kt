package com.example.srbingo.utils

// Potrebni importi za upravljanje muzikom
import android.content.Context
import android.media.MediaPlayer
import com.example.srbingo.R

// Klasa za upravljanje pozadinskom muzikom u aplikaciji
class MusicManager private constructor(context: Context) {
    private var mediaPlayer: MediaPlayer? = null // MediaPlayer za reprodukciju muzike
    private var isPlaying = false // Status reprodukcije

    init {
        // Inicijalizacija MediaPlayer-a sa pozadinskom muzikom
        mediaPlayer = MediaPlayer.create(context, R.raw.background_music)
        mediaPlayer?.isLooping = true // Postavljanje beskonačne petlje
    }

    // Pokretanje muzike
    fun startMusic() {
        if (!isPlaying) {
            mediaPlayer?.start()
            isPlaying = true
        }
    }

    // Pauziranje muzike
    fun pauseMusic() {
        if (isPlaying) {
            mediaPlayer?.pause()
            isPlaying = false
        }
    }

    // Oslobađanje resursa
    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying = false
    }

    // Singleton pattern za jedinstvenu instancu MusicManager-a
    companion object {
        @Volatile
        private var instance: MusicManager? = null

        // Dobijanje instance MusicManager-a
        fun getInstance(context: Context): MusicManager {
            return instance ?: synchronized(this) {
                instance ?: MusicManager(context).also { instance = it }
            }
        }
    }
} 