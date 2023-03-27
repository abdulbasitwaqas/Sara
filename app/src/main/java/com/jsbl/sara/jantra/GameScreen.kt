package com.jsbl.sara.jantra


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jsbl.sara.R
import com.jsbl.sara.jantra.fragments.CrossingNumberFragment
import com.jsbl.sara.jantra.fragments.JantriFragment
import com.jsbl.sara.jantra.fragments.NoToNoFragment


class GameScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, JantriFragment::class.java, null)
                .commit()
        }

        findViewById<ImageView>(R.id.back).setOnClickListener {
            onBackPressed()
        }

        val tv = findViewById<TextView>(R.id.header_text)
        tv.isSelected = true

        findViewById<Button>(R.id.jantari).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, JantriFragment::class.java, null)
                .commit()
        }

        findViewById<Button>(R.id.crossing).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, CrossingNumberFragment::class.java, null)
                .commit()
        }

        findViewById<Button>(R.id.no_to_no).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, NoToNoFragment::class.java, null)
                .commit()
        }

    }

}