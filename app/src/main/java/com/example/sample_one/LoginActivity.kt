package com.example.sample_one

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.fullName)
        val password = findViewById<EditText>(R.id.passwordEditText)
        val loginBtn = findViewById<MaterialButton>(R.id.login)
        val signUpLink = findViewById<TextView>(R.id.signin)

        loginBtn.setOnClickListener {
            if (username.text.isEmpty()) {
                Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show()
            } else if (password.text.isEmpty()) {
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        signUpLink.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
