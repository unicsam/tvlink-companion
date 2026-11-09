package com.tvlink.companion

import android.app.Activity
import android.os.Bundle
import android.widget.Button

/**
 * TV Link Companion Status Activity.
 * Shown when launched directly from the TV launcher or app drawer.
 */
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnReturnHome = findViewById<Button>(R.id.btn_return_home)
        btnReturnHome.requestFocus()
        btnReturnHome.setOnClickListener {
            finish()
        }
    }
}
