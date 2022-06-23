package com.wing4merbr.sobs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer

class MainActivity2() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    public fun oi() {
        val mp = MediaPlayer.create(this, R.raw.pui_noreverb)
        mp.start()
    }
}