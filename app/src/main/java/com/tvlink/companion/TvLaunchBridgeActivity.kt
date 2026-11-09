package com.tvlink.companion

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle

/**
 * TV Link Universal Headless Launch Bridge.
 *
 * Catches `tvlink://`, `lightup://`, `lightweb://`, and `portl://` intents sent from the remote
 * and executes the requested action on Android TV with 0 UI flickering and 0ms exit.
 */
class TvLaunchBridgeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val data: Uri? = intent?.data
            if (data != null && (data.scheme == "tvlink" || data.scheme == "lightup" || data.scheme == "lightweb" || data.scheme == "portl")) {
                when (data.host) {
                    // 1. LAUNCH APP ACTION: tvlink://launch?package=com.example.app
                    "launch" -> {
                        val packageName = data.getQueryParameter("package")
                        if (!packageName.isNullOrEmpty()) {
                            // 1. Check TV-native Leanback Launcher first
                            // 2. If null, fall back to standard Launcher (for sideloaded / phone apps)
                            val launchIntent = packageManager.getLeanbackLaunchIntentForPackage(packageName)
                                ?: packageManager.getLaunchIntentForPackage(packageName)
                            if (launchIntent != null) {
                                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                startActivity(launchIntent)
                            }
                        }
                    }

                    // 2. PLAY MEDIA STREAM: tvlink://play?url=http://...&package=org.videolan.vlc
                    "play" -> {
                        val videoUrl = data.getQueryParameter("url")
                        val playerPackage = data.getQueryParameter("package")
                        if (!videoUrl.isNullOrEmpty()) {
                            val playIntent = Intent(Intent.ACTION_VIEW).apply {
                                setDataAndType(Uri.parse(videoUrl), "video/*")
                                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                if (!playerPackage.isNullOrEmpty()) {
                                    setPackage(playerPackage)
                                }
                            }
                            startActivity(playIntent)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            // Immediate exit to keep bridge 100% headless
            finish()
        }
    }
}
