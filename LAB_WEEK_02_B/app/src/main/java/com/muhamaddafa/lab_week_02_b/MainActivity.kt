package com.muhamaddafa.lab_week_02_b

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
        private const val ERROR_KEY = "ERROR_KEY"
        private const val TAG = "dafa_main"
    }

    private val submitButton: Button
        get() = findViewById(R.id.submit_button)

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                activityResult ->
            val data = activityResult.data
            val error = data?.getBooleanExtra(ERROR_KEY, false)
            if(error == true){
                Toast
                    .makeText(this, getString(R.string.color_code_input_invalid),
                        Toast.LENGTH_LONG)
                    .show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        submitButton.setOnClickListener() {
            val color_code =  findViewById<TextInputEditText>(R.id.color_code_input_field).text.toString()
            if(color_code.isNotEmpty()) {
                if(color_code.length < 6) {
                    Toast.makeText(this, getString(R.string.color_code_input_invalid), Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, Result_Activity::class.java)
                    intent.putExtra(COLOR_KEY, color_code)
//                    startActivity(intent)
                    startForResult.launch(intent)
                }
            } else {
                Toast.makeText(this, getString(R.string.color_code_input_empty), Toast.LENGTH_SHORT).show()
            }
        }
    }
}