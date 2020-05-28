package com.example.birdscounter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count: Int? = null
    var colour: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
    }

    private fun setupUI() {
        btnRed.setOnClickListener { applyRed() }
        btnGray.setOnClickListener { applyGray() }
        btnBlue.setOnClickListener { applyBlue() }
        btnYellow.setOnClickListener { applyYellow() }
        btnReset.setOnClickListener { reset() }
    }

    override fun onResume() {
        super.onResume()
        val pref = getPreferences(Context.MODE_PRIVATE)
        this.count = pref.getInt("COUNT", 0)
        counter.text = count.toString()
        when (pref.getString("COLOUR", "")) {
            "RED" -> counter.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            "GRAY" -> counter.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            "BLUE" -> counter.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            "YELLOW" -> counter.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
        }
    }

    override fun onPause() {
        super.onPause()
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        this.count?.let { editor.putInt("COUNT", count!!) }
        editor.putString("COLOUR", colour)
        editor.apply()
    }

    private fun applyRed(){
        count = count?.plus(1)
        colour = "RED"
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        counter.text = count.toString()
        counter.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        editor.putString ("COLOUR", colour)
    }
    private fun applyGray(){
        count = count?.plus(1)
        colour = "GRAY"
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        counter.text = count.toString()
        counter.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        editor.putString ("COLOUR", colour)
    }

    private fun applyBlue(){
        count = count?.plus(1)
        colour = "BLUE"
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        counter.text = count.toString()
        counter.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
        editor.putString ("COLOUR", colour)
    }

    private fun applyYellow(){
        count = count?.plus(1)
        colour = "YELLOW"
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        counter.text = count.toString()
        counter.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
        editor.putString ("COLOUR", colour)
    }


    private fun reset(){
        print("reset")
        count = 0
        counter.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        counter.text = "0"
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        this.count?.let { editor.putInt("COUNT", count!!) }
        editor.clear()
        editor.apply()
    }

}
