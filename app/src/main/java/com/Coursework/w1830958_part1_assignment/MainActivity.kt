package com.Coursework.w1830958_part1_assignment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow

class MainActivity : AppCompatActivity() {
    //Global initialisation
    lateinit var dialog:Dialog
    private lateinit var aboutBtn: Button
    lateinit var startGameButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //dialog declaration
        dialog = Dialog(this)
            //button diclaration
        startGameButton = findViewById<Button>(R.id.btn1)
        startGameButton.setOnClickListener {


//intent to go to the next window
            val intent1 = Intent(this,userInputActivity::class.java)



            startActivity(intent1)
        }
//about button with on listener linked with xml about for pop up window on top of the current window
        aboutBtn = findViewById<Button>(R.id.btn3)
        aboutBtn.setOnClickListener {
            popupContent(aboutBtn)
        }
        //rules button with on click listener to display the pop up window on top of the current window
        var rules=findViewById<Button>(R.id.btn2)
        rules.setOnClickListener {
            rulesPopup(rules)
        }
    }


//pop up window function using dialog for about
    private fun popupContent(view: View?) {
        dialog.setContentView(R.layout.popup)
        dialog.setCancelable(true)

        dialog.show()

    }
//rules pop up function
    private fun rulesPopup(view: View?) {
        dialog.setContentView(R.layout.game_rule_popup)
        dialog.setCancelable(true)

        dialog.show()

    }


}