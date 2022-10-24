package com.firstapp.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener { appendOnExpreesstion("1", true) }
        tvTwo.setOnClickListener { appendOnExpreesstion("2", true) }
        tvThree.setOnClickListener { appendOnExpreesstion("3", true) }
        tvFour.setOnClickListener { appendOnExpreesstion("4", true) }
        tvFive.setOnClickListener { appendOnExpreesstion("5", true) }
        tvSix.setOnClickListener { appendOnExpreesstion("6", true) }
        tvSeven.setOnClickListener { appendOnExpreesstion("7", true) }
        tvEight.setOnClickListener { appendOnExpreesstion("8", true) }
        tvNine.setOnClickListener { appendOnExpreesstion("9", true) }
        tvZero.setOnClickListener { appendOnExpreesstion("0", true) }
        tvDot.setOnClickListener { appendOnExpreesstion(".", true) }

        //Operators
        tvPlus.setOnClickListener { appendOnExpreesstion("+", false) }
        tvMinus.setOnClickListener { appendOnExpreesstion("-", false) }
        tvMul.setOnClickListener { appendOnExpreesstion("*", false) }
        tvDivide.setOnClickListener { appendOnExpreesstion("/", false) }
        tvOpen.setOnClickListener { appendOnExpreesstion("(", false) }
        tvClose.setOnClickListener { appendOnExpreesstion(")", false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length-1)
            }
            tvResult.text = ""
        }

        tvEqual.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvResult.text = longResult.toString()
                } else
                    tvResult.text = result.toString()

            } catch (e: Exception) {

            }
        }
    }

    fun appendOnExpreesstion (string: String, canClear: Boolean) {

        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}