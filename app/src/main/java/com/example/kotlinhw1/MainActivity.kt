package com.example.kotlinhw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->

                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    ed_title.setText(intent?.getStringExtra(KEY_RES))
                }
            }
        btn_sent.setOnClickListener {
            if (!ed_title.text.isNullOrBlank()) {
                startForResult.launch(
                    Intent(this@MainActivity, SecondActivity::class.java)
                        .putExtra(KEY_RES, ed_title.text?.toString())
                )
            } else {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val KEY_RES = "res"
    }
}