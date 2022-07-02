package com.wing4merbr.sobs

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.media.MediaPlayer
import android.os.*
import android.view.View
import android.media.AudioManager
import android.view.KeyEvent
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

     fun overload(view: View) {
        val macaxera = MediaPlayer.create(this, R.raw.macaxera);
        macaxera.start();

         val manager = applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        manager.setStreamVolume(AudioManager.STREAM_MUSIC, manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0)
         vibrate(longArrayOf(5000, 5000000000000000))
     }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Toast.makeText(applicationContext, "Seu dispositivo foi asutiado", Toast.LENGTH_LONG).show()
                val manager = applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0)
            }
        }

        return true;
    }

    fun requestRoot(view: View) {
        val process = Runtime.getRuntime().exec("su")
        if (process === null) {
            Toast.makeText(applicationContext, "Não foi possível asutiar o telefone", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "Telefone asutiado com sucesso", Toast.LENGTH_LONG).show()
            val intent = Intent(this, RootActivity::class.java)
            startActivity(intent)
        }
    }
    fun Context.vibrate(pattern: LongArray) {
        val vibrator =
            applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator? ?: return

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                VibrationEffect.createWaveform(pattern, VibrationEffect.DEFAULT_AMPLITUDE)
            )

        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(pattern, 5006600 * pattern.size)
        }
    }
}