package com.Coursework.w1830958_part1_assignment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class userInputActivity : AppCompatActivity() {
    //global initialisation
    lateinit var continueBtn: Button
    lateinit var userTarget: EditText
lateinit var backBt2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_input)
        //Declaring the global variables
        continueBtn = findViewById(R.id.continue_btn)
        userTarget = findViewById(R.id.editTextTextPersonName)

        backBt2=findViewById(R.id.backBtn2)
        //on click listener
        backBt2.setOnClickListener{
            //intent creation and value passing along with executing the intent to go to the next page
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)

        }
        val intent2 = Intent(this, GameActivity::class.java)
//button on click listener
        continueBtn.setOnClickListener {
            try {

                intent2.putExtra("targetScore", userTarget.text.toString().toInt())


                startActivity(intent2)
            }catch (e:NumberFormatException){


                startActivity(intent2)
            }
        }
    }
}