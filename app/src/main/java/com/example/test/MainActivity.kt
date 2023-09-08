package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    var x = 0
    var y = 0
    var resultado = 0

    val setxActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            x = it.data!!.getIntExtra("numero", 0)
            val textViewX = findViewById<TextView>(R.id.textViewX)
            textViewX.text = x.toString()
        }
    }
    val setyActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
           y = it.data!!.getIntExtra("numero", 0)
           val textViewY = findViewById<TextView>(R.id.textViewY)
           textViewY.text = y.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        val textViewX = findViewById<TextView>(R.id.textViewX)
        val textViewY = findViewById<TextView>(R.id.textViewY)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        textViewX.text = x.toString()
        textViewY.text = y.toString()
        textViewResultado.text = resultado.toString()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonSetX = findViewById<Button>(R.id.buttonSetX)

        buttonSetX.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("label", "X")
            setxActivity.launch(intent)
        }

        val buttonSetY = findViewById<Button>(R.id.buttonSetY)

        buttonSetY.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("label","Y")
            setyActivity.launch(intent)
        }

        val buttonResultado = findViewById<Button>(R.id.buttonResultado)

        buttonResultado.setOnClickListener {
            val textViewResultado = findViewById<TextView>(R.id.textViewResultado)
            textViewResultado.text = (x + y).toString()
        }
    }
}