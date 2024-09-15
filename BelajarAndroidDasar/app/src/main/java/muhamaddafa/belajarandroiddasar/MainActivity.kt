package muhamaddafa.belajarandroiddasar

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameTextForm : EditText
    private lateinit var submitNameButton : Button
    private lateinit var helloText : TextView

    private fun initComponents() {
        nameTextForm = findViewById(R.id.inputNamaForm)
        submitNameButton = findViewById(R.id.submitNamaButton)
        helloText = findViewById(R.id.textHelloName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()

        helloText.text = resources.getText(R.string.app_name)

        submitNameButton.setOnClickListener {
            // logging in kotlin
            Log.i(resources.getString(R.string.tagLog), "Button Clicked")

            Log.i(resources.getString(R.string.tagLog), resources.getInteger(R.integer.maxPaging).toString())
            Log.i(resources.getString(R.string.tagLog), resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i(resources.getString(R.string.tagLog), resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i(resources.getString(R.string.tagLog), resources.getColor(R.color.bg_color, theme).toString())

            submitNameButton.setBackgroundColor(resources.getColor(R.color.bg_color, theme))

            val name = nameTextForm.text.toString()
            helloText.text = resources.getString(R.string.helloText, name)
        }
    }
}