package com.example.tictactoeapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.tictactoeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    enum class Turn {
        O,
        X
    }

    private var firstPlayer = Turn.X
    private var secondPlayer= Turn.X

    private var scoreX = 0
    private var scoreO = 0

    private var boardList = mutableListOf<Button>()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }

    private fun initBoard()
    {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun btnClick(view: View)
    {
        if(view !is Button)
            return
        addToBoard(view)

        if(victoryCheck(O))
        {
            scoreO++
            result("Noughts Win!")
        }
        else if(victoryCheck(X))
        {
            scoreX++
            result("Crosses Win!")
        }

        if(fullBoard())
        {
            result("It's a DRAW!!!")
        }

    }

    private fun victoryCheck(s: String): Boolean
    {
        //horizontal
        if(match(binding.a1,s) && match(binding.a2,s) && match(binding.a3,s))
            return true
        if(match(binding.b1,s) && match(binding.b2,s) && match(binding.b3,s))
            return true
        if(match(binding.c1,s) && match(binding.c2,s) && match(binding.c3,s))
            return true

        //vertical
        if(match(binding.a1,s) && match(binding.b1,s) && match(binding.c1,s))
            return true
        if(match(binding.a2,s) && match(binding.b2,s) && match(binding.c2,s))
            return true
        if(match(binding.a3,s) && match(binding.b3,s) && match(binding.c3,s))
            return true

        //diagonal
        if(match(binding.a1,s) && match(binding.b2,s) && match(binding.c3,s))
            return true
        if(match(binding.a3,s) && match(binding.b2,s) && match(binding.c1,s))
            return true

        return false
    }

    private fun match(button: Button, symbol : String): Boolean = button.text == symbol

    private fun result(title: String)
    {
        val message = "\nPlayer_1:  $scoreX\n\nPlayer_2:  $scoreO"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("restart")
            { _,_ ->
                restart()
            }
            .setCancelable(false)
            .show()
    }

    private fun restart()
    {
        for(button in boardList)
        {
            button.text = ""
            button.setBackgroundColor(Color.parseColor("#6201f0"))

        }

        if(firstPlayer == Turn.O)
            firstPlayer = Turn.X
        else if(firstPlayer == Turn.X)
            firstPlayer = Turn.O

        secondPlayer= firstPlayer

        setTurnLabel()
    }

    private fun fullBoard(): Boolean
    {
        for(button in boardList)
        {
            if(button.text == "")
                return false
        }
        return true
    }

    private fun addToBoard(button: Button)
    {
        if(button.text != "")
            return

        if(secondPlayer== Turn.O)
        {
            button.text = O
            secondPlayer= Turn.X
        }
        else if(secondPlayer== Turn.X)
        {
            button.text = X
            secondPlayer= Turn.O
        }
        button.setBackgroundColor(Color.parseColor("#873cf1"))
        setTurnLabel()
    }

    private fun setTurnLabel()
    {
        var turnText = ""
        var turnSymbol = ""
        if(secondPlayer== Turn.X){
            turnText = "Player 1"
            turnSymbol = "X"}
        else if(secondPlayer== Turn.O) {
            turnText = "Player 2"
            turnSymbol = "O"
        }

        binding.turnView.text = turnText
        binding.turnSymbolView.text = turnSymbol
    }

    companion object
    {
        const val O = "O"
        const val X = "X"
    }

}