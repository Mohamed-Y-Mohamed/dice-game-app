package com.Coursework.w1830958_part1_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class outcomeActivity : AppCompatActivity() {
    lateinit var image:ImageView
    lateinit var textView: TextView
    lateinit var exit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outcome)
        image=findViewById(R.id.resultImg)
        textView=findViewById(R.id.resultText)
        exit=findViewById(R.id.exitButton)
exit.setOnClickListener{
    var back= Intent(this,MainActivity::class.java)
    startActivity(back)
}
        result()
    }
    private fun result(){
        var result=intent.getIntExtra("outcomeResult",0)
        var resultImage=intent.getIntExtra("image",0)
        var humanWin = intent.getIntExtra("humanWin", 0)
        var computerWin = intent.getIntExtra("compWin", 0)
        var status=findViewById<TextView>(R.id.result)
        status.text="H:$humanWin/C:$computerWin"
        if(result==1){
       image.setImageResource(resultImage)
            textView.text="Congratulation"
        }
        else if (result==0){
            image.setImageResource(resultImage)
            textView.text="You  Lost"

        }
    }
}