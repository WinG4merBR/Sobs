package com.wing4merbr.sobs

import android.support.v7.app.AppCompatActivity
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

     fun playOi(view: View) {
        val mp = MediaPlayer.create(this, R.raw.pui_noreverb)
        mp.start();
    }

    fun bigbob(view: View) {
        val mp = MediaPlayer.create(this, R.raw.molhobigbob)
        mp.start();
    }

    fun mofo(view: View) {
        val mp = MediaPlayer.create(this, R.raw.boobs);
        mp.start();
    }

    fun recarga(view: View) {
        val mp = MediaPlayer.create(this, R.raw.oirecarga);
        mp.start();
    }
}