package com.example.kotlinhw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val data: String? = intent.getStringExtra(MainActivity.KEY_RES).toString()
        data?.let { ed_title2.setText(data) }

        btn_sent2.setOnClickListener {

            if (!ed_title2.text.isNullOrBlank()) {

                setResult(
                    Activity.RESULT_OK,
                    Intent().putExtra(MainActivity.KEY_RES, ed_title2.text?.toString())
                )
                finish()

            } else {
                Toast.makeText(this, "is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}