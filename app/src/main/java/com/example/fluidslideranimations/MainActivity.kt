package com.example.fluidslideranimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.ramotion.fluidslider.FluidSlider

val max = 100
val min = 0
val total:Int = max-min


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slider = findViewById<FluidSlider>(R.id.slider)
        val textView = findViewById<TextView>(R.id.textview)
        val button = findViewById<Button>(R.id.button)

        slider.positionListener = {pos -> slider.bubbleText = "${min + (total*pos).toInt()}"}
        slider.position = 0.3f
        slider.startText="$min"
        slider.endText="$max"

        button.setOnClickListener {
            val s = slider.bubbleText.toString()
            button.setText(s)
        }

        slider.beginTrackingListener = {textView.visibility = View.INVISIBLE}
        slider.endTrackingListener = {
            textView.visibility = View.VISIBLE
            val value = slider.bubbleText.toString()
            textView.setText("You Set the value :$value")

        }





    }
}