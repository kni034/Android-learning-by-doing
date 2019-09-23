package com.example.songgenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seekBarElement = findViewById<SeekBar>(R.id.seekBar)
        var verses = findViewById<TextView>(R.id.number_view)
        seekBarElement.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                verses.text = i.toString()
            }
        })

        var drinkStr = findViewById<EditText>(R.id.drink_text)
        val generateBtn = findViewById<Button>(R.id.generate_button)
        generateBtn.setOnClickListener {
            if(seekBarElement.progress != 0 && drink_text != null) {
                createSong(drinkStr.text.toString(), seekBarElement.progress)
            }
        }

    }

    private fun createSong(drink : String, verses : Int){
        var song = ""
        for (i in verses downTo 1){
            song += "$i bottles of $drink on the wall, $i bottles of $drink. \nTake one down and pass it around, ${i-1} bottles of $drink on the wall. \n \n"
        }
        song += "No more bottles of $drink on the wall, no more bottles of $drink.\nGo to the store and buy some more, $verses bottles of $drink on the wall."

        song_View.text = song
    }
}
