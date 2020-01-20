package com.example.testresolution

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val density = resources.displayMetrics.density.toString()
        val config: Configuration = resources.configuration
        val densityDPI = config.smallestScreenWidthDp
        test_view.text = getString(R.string.format, densityDPI.toString(), getDensity(density))
    }

    fun getDensity(density: String): String {
        when (density) {
            "0.75" -> {
                return "ldpi"
            }
            "1.0" -> {
                return "mdpi"
            }
            "1.5" -> {
                return "hdpi"
            }
            "2.0" -> {
                return "xhdpi"
            }
            "3.0" -> {
                return "xxhdpi"
            }
            "4.0" -> {
                return "xxxhdpi"
            }
            else -> {
                return "undefined"
            }
        }
    }
}
