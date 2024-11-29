package com.example.marininasr_01_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.PI

class SecondActivity : AppCompatActivity() {
    var numberA: EditText? = null
    var numberB: EditText? = null
    var itemvibor: Int = 0
    var result : Double = 0.0;
    private lateinit var rootview: View
    val ar= arrayOf("Треугольник", "Окружность")
    val images = arrayOf(R.drawable.triangle, R.drawable.circle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_second)
        numberA = findViewById<EditText>(R.id.entry1)
        numberB = findViewById<EditText>(R.id.entry2)
        rootview = findViewById(R.id.rootview)
        val editText: EditText = findViewById(R.id.entry1)
        editText.visibility = View.GONE

        val pik= findViewById<Spinner>(R.id.picker)
        val imageView = findViewById<ImageView>(R.id.image)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ar)
        pik.adapter = adapter

        pik.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val edt1 = findViewById<EditText>(R.id.entry1)
                val edt2 = findViewById<EditText>(R.id.entry2)
                when (position) {
                    0 -> {
                        edt1.hint = "a"
                        edt1.visibility = View.VISIBLE
                        edt2.visibility = View.VISIBLE
                        edt2.hint = "b"
                        itemvibor = 0
                    }

                    1 -> {
                        edt1.hint = "P"
                        edt2.visibility = View.GONE
                        itemvibor = 1

                    }
                }
                imageView.setImageResource(images[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    fun DisplayAlert(view: View) {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        if ( itemvibor== 0) {
            if (!numberA?.text.toString().isNullOrEmpty() && !numberB?.text.toString()
                    .isNullOrEmpty()
            ) {
                val a = numberA?.text.toString().toDouble()
                val b = numberB?.text.toString().toDouble()
                result = 2 * a + b
               // editor.putString("figure", "Треугольник")
                editor.putString("result", "$result")
                editor.apply()
                startActivity(Intent(this, ThirdActivity::class.java))
            } else {
                Snackbar.make(rootview,"Вы не ввели данные ",Snackbar.LENGTH_SHORT).show()
            }
        } else {
            if (!numberA?.text.isNullOrEmpty()) {
                if (!numberA?.text.toString().isNullOrEmpty()) {
                    val a = numberA?.text.toString().toDouble()
                    result = (a / (2 * PI))
                    val roundRes = BigDecimal(result!!).setScale(2, RoundingMode.HALF_UP).toDouble()
                   // editor.putString("figure", "Окружность")
                    editor.putString("result", "$roundRes")
                    editor.apply()
                    startActivity(Intent(this, ThirdActivity::class.java))
                }
            } else {
                Snackbar.make(rootview,"Вы не ввели данные ",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}