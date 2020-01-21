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
        val density = resources.displayMetrics.density
        val config: Configuration = resources.configuration
        val densityDPI = config.smallestScreenWidthDp
        test_view.text = getString(R.string.format, densityDPI.toString(), getDensity(density))
    }

    private fun getDensity(density: Float): String {
        if(density <= 0.75) {
            return "ldpi"
        } else if(density > 0.75 && density <= 1.0) {
            return "mdpi"
        } else if(density > 1.0 && density <= 1.5) {
            return "hdpi"
        } else if(density > 1.5 && density <= 2.0) {
            return "xhdpi"
        } else if(density > 2.0 && density <= 3.0) {
            return "xxhdpi"
        } else if(density > 3.0 && density <= 4.0) {
            return "xxxhdpi"
        } else {
            return density.toString()
        }
    }
}
