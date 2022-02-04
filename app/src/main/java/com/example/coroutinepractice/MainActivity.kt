package com.example.coroutinepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener {

            // First coroutine is set with 4000ms delay to print
            lifecycle.coroutineScope.launch {
                delay(4000L)
                val textOne = findViewById<TextView>(R.id.text_one)
                textOne.text = "First coroutine with 4s delay"
            }

            // Second coroutine is set with 2000ms delay to print
            lifecycle.coroutineScope.launch {
                delay(2000L)
                val textTwo = findViewById<TextView>(R.id.text_two)
                textTwo.setText("Second coroutine with 2s delay")
            }

            // Third coroutine is set without delay
            lifecycle.coroutineScope.launch {
                val textThree = findViewById<TextView>(R.id.text_three)
                textThree.setText("Third coroutine without any delay")
            }
        }
    }
}