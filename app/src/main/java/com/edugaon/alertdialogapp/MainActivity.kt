package com.edugaon.alertdialogapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logOutButton = findViewById<Button>(R.id.addUserButton)
        logOutButton.setOnClickListener {

            val layout = LayoutInflater.from(this).inflate(R.layout.custom_dialog_design, null)

            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setView(layout)
            alertDialog.show()

            val cancel= layout.findViewById<Button>(R.id.cancelBtn)
            val save= layout.findViewById<Button>(R.id.saveBtn)
            val nameEditText= layout.findViewById<EditText>(R.id.nameEditText)
            val emailEditText= layout.findViewById<EditText>(R.id.emailEditText)

            cancel.setOnClickListener {
                alertDialog.dismiss()
            }

            save.setOnClickListener {
                val description = nameEditText.text.toString()+" " + emailEditText.text.toString()
                val description1 = "Name is ${nameEditText.text} and email is ${emailEditText.text}"
                Toast.makeText(this, description1, Toast.LENGTH_SHORT).show()
                alertDialog.dismiss()
            }
        }
    }
}