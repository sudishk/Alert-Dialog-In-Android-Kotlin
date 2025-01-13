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

        val logOutButton = findViewById<Button>(R.id.logoutButton)
        logOutButton.setOnClickListener {


            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Log Out!")
            alertDialog.setMessage("Are you sure you want to logOut?")
            alertDialog.setPositiveButton("Yes"){_,_ ->
                Toast.makeText(this, "Logout successfully", Toast.LENGTH_SHORT).show()
            }

            alertDialog.setNegativeButton("No"){_,_ ->
                Toast.makeText(this, "Logout cancel", Toast.LENGTH_SHORT).show()

            }
            alertDialog.show()
        }
    }
}