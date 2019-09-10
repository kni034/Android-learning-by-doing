package com.example.helloword

import android.content.Intent
import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var button = findViewById<Button>(R.id.playButton)
        var worldTextVar = findViewById<TextView>(R.id.worldText)
        val switch = findViewById<Switch>(R.id.worldSwitch)
        var countButton = findViewById<Button>(R.id.bButton)

        var count = 10

        switch.setOnCheckedChangeListener { _, isChecked ->

            countButton.setOnClickListener {
                count--
                countButton.text = count.toString()

                if (count <= 0) {
                    button.visibility = View.VISIBLE
                    countButton.visibility = View.GONE
                }
            }
            if(isChecked) {
                worldText.visibility = View.VISIBLE
                countButton.visibility = View.VISIBLE


            }
            else{
                worldTextVar.visibility = View.GONE
                countButton.visibility = View.GONE
            }
        }

        button.setOnClickListener{

            val intent = Intent(this, Main2Activity :: class.java)
            startActivity(intent)
        }
    }


}
