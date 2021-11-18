package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnClick(view:View){
        val btnSelected: Button = view as Button
        var cellID = 0

        when (btnSelected.id){
            R.id.a1 -> cellID = 1
            R.id.a2 -> cellID = 2
            R.id.a3 -> cellID = 3
            R.id.b1 -> cellID = 4
            R.id.b2 -> cellID = 5
            R.id.b3 -> cellID = 6
            R.id.c1 -> cellID = 7
            R.id.c2 -> cellID = 8
            R.id.c3 -> cellID = 9
        }
        Log.d("btnClick: ", btnSelected.id.toString())
        Log.d("cellID: ", cellID.toString())
    }
}