package com.example.kvizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val btnStart : Button = findViewById(R.id.btn_Start)
        val etName : EditText = findViewById(R.id.et_name)
        btn_Start.setOnClickListener {
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(this ,"Molimo unesite ime ",Toast.LENGTH_SHORT).show()
            }else{

                val intent = Intent(this,KvizPitanjaActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }


        }
    }
}