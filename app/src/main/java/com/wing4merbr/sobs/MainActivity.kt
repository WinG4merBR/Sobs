package com.wing4merbr.sobs

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun call(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        val player = MediaPlayer.create(this, R.raw.sobs);
        player.start();
        startActivity(intent)
    }
}