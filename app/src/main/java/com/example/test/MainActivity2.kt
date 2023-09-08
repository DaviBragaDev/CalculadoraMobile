package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    var settado : String? = ""
    var numero : Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        settado = intent.getStringExtra("label")

        val textViewSettado = findViewById<TextView>(R.id.textViewSettado)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)

        textViewSettado.text = settado

        editTextNumber.setText(numero.toString())

        val buttonOk = findViewById<Button>(R.id.buttonOk)

        buttonOk.setOnClickListener {
            val intent = Intent()
            intent.putExtra("numero", Integer.parseInt(editTextNumber.text.toString()))
            setResult(RESULT_OK, intent)
            finish()

        }



    }
}