package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expView = findViewById<TextView>(R.id.expView)
        val resView = findViewById<TextView>(R.id.resultView)
        resView.text = "0"
        zeroButton.setOnClickListener {appendToStream("0", expView, resView)}
        oneButton.setOnClickListener { appendToStream("1", expView, resView)}
        twoButton.setOnClickListener {appendToStream("2", expView, resView)}
        threeButton.setOnClickListener {appendToStream("3", expView, resView)}
        fourButton.setOnClickListener {appendToStream("4", expView, resView)}
        fiveButton.setOnClickListener {appendToStream("5", expView, resView)}
        sixButton.setOnClickListener {appendToStream("6", expView, resView)}
        sevenButton.setOnClickListener {appendToStream("7", expView, resView)}
        eightButton.setOnClickListener {appendToStream("8", expView, resView)}
        nineButton.setOnClickListener {appendToStream("9", expView, resView)}
        dotButton.setOnClickListener {appendToStream(".", expView, resView)}
        plusButton.setOnClickListener {appendToStream("+", expView, resView)}
        minusButton.setOnClickListener {appendToStream("-", expView, resView)}
        multiButton.setOnClickListener {appendToStream("*", expView, resView)}
        divButton.setOnClickListener {appendToStream("/", expView, resView)}
        rightParButton.setOnClickListener {appendToStream(")", expView, resView)}
        leftParButton.setOnClickListener {appendToStream("(", expView, resView)}
        backButton.setOnClickListener {appendToStream("back", expView, resView)}
        equalButton.setOnClickListener {appendToStream("equal", expView, resView)}
        clearEverythingButton.setOnClickListener {appendToStream("clear", expView, resView)}
    }

    fun appendToStream (string : String, expView : TextView, resView : TextView)
    {
        when (string) {
            "clear" -> {
                expView.text = ""
                resView.text = "0"
            }
            "back" -> {
                val newString = expView.text.toString()
                if (newString.isNotEmpty()) expView.text = newString.substring(0, newString.length-1)
            }
            "equal" -> {
                if (expView.text.toString().isNotEmpty())
                {
                    val exp = ExpressionBuilder(expView.text.toString()).build()
                    val res = exp.evaluate()
                    resView.text = res.toString()
                    expView.text = ""
                }
            }
            else -> expView.append(string)
        }
    }


}