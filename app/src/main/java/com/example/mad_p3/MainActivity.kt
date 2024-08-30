package com.example.mad_p3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
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
        val btn1 = findViewById<Button>(R.id.btn1)
        val edittext=findViewById<EditText>(R.id.main_edit_text)
        btn1.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            intent.putExtra("username",edittext.text.toString())
            startActivity(intent)
        }
        val webpagebtn=findViewById<Button>(R.id.webpagebtn)
        val callbtn=findViewById<Button>(R.id.callbtn)
        val camerabtn=findViewById<Button>(R.id.camerabtn)

        webpagebtn.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/GunjanPatel359"))
            startActivity(intent)
        }

        callbtn.setOnClickListener {
            val intent=Intent(Intent.ACTION_DIAL)
            intent.data=Uri.parse("tel:+9106209714")
            startActivity(intent)
        }

        camerabtn.setOnClickListener {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}
