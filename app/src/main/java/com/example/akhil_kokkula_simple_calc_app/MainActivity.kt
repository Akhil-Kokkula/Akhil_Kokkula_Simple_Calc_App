package com.example.akhil_kokkula_simple_calc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                println(adapterView?.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }

    fun ButtonClick(view: View) {
        val ansDisplay : TextView = findViewById(R.id.ansText)
        ansDisplay.setText("")

        val num1UI : EditText = findViewById(R.id.num1)
        val num2UI : EditText = findViewById(R.id.num2)

        if (num1UI.text.toString() == "") {
            Toast.makeText(this@MainActivity,
                "Please enter number 1",
                Toast.LENGTH_LONG).show()
            return
        }

        if (num2UI.text.toString() == "") {
            Toast.makeText(this@MainActivity,
                "Please enter number 2",
                Toast.LENGTH_LONG).show()
            return
        }

        val num1 = Integer.parseInt(num1UI.text.toString())
        val num2 = Integer.parseInt(num2UI.text.toString())

        val spinner: Spinner = findViewById(R.id.spinner)
        val op = spinner.selectedItem.toString()


        var ans = 0

        if (op == "Addition") {
            ans = num1 + num2
        }
        else if (op == "Subtraction") {
            ans = num1 - num2
        }
        else if (op == "Multiplication") {
            ans = num1 * num2
        }
        else if (op == "Division") {
            if (num2 == 0) {
                Toast.makeText(this@MainActivity,
                    "Division by 0 error",
                    Toast.LENGTH_LONG).show()
                return
            }
            ans = num1 / num2
        }
        else {
            if (num2 == 0) {
                Toast.makeText(this@MainActivity,
                    "Division by 0 error",
                    Toast.LENGTH_LONG).show()
                return
            }
            ans = num1 % num2
        }


        ansDisplay.setText(ans.toString())
    }


}