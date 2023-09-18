package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvOperation: EditText
    private lateinit var tvResult: TextView

    private var canAddOperation = false
    private var canAddDecimal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOperation = findViewById(R.id.tvOperation)
        tvResult = findViewById(R.id.tvResult)
    }

    fun numberAction(view: View) {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal) {
                    tvOperation.append(view.text)
                }
                canAddDecimal = false
            } else {
                tvOperation.append(view.text)
            }
            canAddOperation = true
        }
    }

    fun operationAction(view: View) {
        if (view is Button && canAddOperation) {
            tvOperation.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

//    fun allClearAction() {
//
//    }
}