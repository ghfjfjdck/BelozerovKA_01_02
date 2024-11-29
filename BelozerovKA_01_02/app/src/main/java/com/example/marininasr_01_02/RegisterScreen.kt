package com.example.marininasr_01_02

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class RegisterScreen : AppCompatActivity() {


    private lateinit var textemail: EditText
    private lateinit var textpassword: EditText
    private lateinit var rootview: View
    private lateinit var signbut: Button
    private lateinit var sharedpref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)


        textemail=findViewById(R.id.email)
        textpassword=findViewById(R.id.pas)
        rootview=findViewById(R.id.fragmview)
        signbut=findViewById(R.id.buttonn)
        sharedpref = getSharedPreferences("mydata", MODE_PRIVATE)

        val savedlogin = sharedpref.getString("login",null)
        val savedpassword = sharedpref.getString("password",null)

        if(savedlogin!=null && savedpassword!=null)
        {

            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Вход выполнен", Toast.LENGTH_SHORT).show()


        }

        signbut.setOnClickListener{



            if(textemail.text.toString()!="" && textpassword.text.toString()!="")
            {
                if(textemail.text.toString()=="ects"&&textpassword.text.toString()=="ects2024") {
                    val login = textemail.text.toString()
                    val password = textpassword.text.toString()
                    with(sharedpref.edit())
                    {
                        putString("login", login)
                        putString("password", password)
                        apply()


                    }
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }else
                {
                    val snackbar = Snackbar.make(rootview,"Неверный логин и пароль", Snackbar.LENGTH_SHORT)
                    snackbar.setActionTextColor(Color.BLUE)
                    snackbar.setAction("Закрыть"){
                    }
                    snackbar.show()


                }


            }else
            {
                val snackbar = Snackbar.make(rootview,"Есть пустые поля", Snackbar.LENGTH_SHORT)
                snackbar.setActionTextColor(Color.BLUE)
                snackbar.setAction("Закрыть"){
                }
                snackbar.show()

            }

        }


    }
}