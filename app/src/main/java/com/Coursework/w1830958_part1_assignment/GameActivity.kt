package com.Coursework.w1830958_part1_assignment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class GameActivity : AppCompatActivity() {
    //variable global initialization

    var target: Int = 0
    var humanWin = 0
    var computerWin = 0
    var pScore = 0
    var cScore = 0
    var comptrScoreList = mutableListOf<Int>()
    var plrRollScoreList = mutableListOf<Int>()
    var rollCount = 0
    var roll = 0
    var plrReRollCount = 0
    //images list global initialization

    private var diceFacesList = listOf(
        R.drawable.die_face_1,
        R.drawable.die_face_2,
        R.drawable.die_face_3,
        R.drawable.die_face_4,
        R.drawable.die_face_5,
        R.drawable.die_face_6
    )
    var listOfBooleans = arrayListOf<Boolean>()

    //images global initialization
    private lateinit var playerDice1: ImageView
    private lateinit var playerDice2: ImageView
    private lateinit var playerDice3: ImageView
    private lateinit var playerDice4: ImageView
    private lateinit var playerDice5: ImageView
    private lateinit var systemDice1: ImageView
    private lateinit var systemDice2: ImageView
    private lateinit var systemDice3: ImageView
    private lateinit var systemDice4: ImageView
    private lateinit var systemDice5: ImageView


    //button global initialization
    private lateinit var rollButton: Button
    private lateinit var scoreButton: Button
    private lateinit var reRollbutton: Button
    private lateinit var backBtn: Button

    //text initialization for score
    private lateinit var score: TextView


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
//retrieve extra variable from previous window (user input activity) which contain the target of the game to reach
        target = intent.getIntExtra("targetScore", 101)
        if (target < 101) {

            target = 101
        }


//toast message display to show the user target they have entered goal to win the game
        Toast.makeText(this, "$target is the target to reach to win the game", Toast.LENGTH_SHORT)
            .show()
        //Declaration for Global methods that has been initialised

        reRollbutton = findViewById(R.id.re_rollButton)
        backBtn = findViewById(R.id.backBtn)
        scoreButton = findViewById(R.id.ScoreBtn)
        score = findViewById(R.id.scoreText)
        playerDice1 = findViewById(R.id.img1)
        playerDice2 = findViewById(R.id.img2)
        playerDice3 = findViewById(R.id.img3)
        playerDice4 = findViewById(R.id.img4)
        playerDice5 = findViewById(R.id.img5)
        systemDice1 = findViewById(R.id.img6)
        systemDice2 = findViewById(R.id.img7)
        systemDice3 = findViewById(R.id.img8)
        systemDice4 = findViewById(R.id.img9)
        systemDice5 = findViewById(R.id.img10)
        rollButton = findViewById(R.id.roll)
        listOfBooleans = arrayListOf(false, false, false, false, false)


        //button on click listener for  roll

        rollButton.setOnClickListener {
            roller()
        }
//set re-roll to invisible at the start of the game
        reRollbutton.visibility = View.INVISIBLE
        scoreButton.visibility = View.INVISIBLE
//dices on click listener
        playerDice1.setOnClickListener { listOfBooleans[0] = true }
        playerDice2.setOnClickListener { listOfBooleans[1] = true }
        playerDice3.setOnClickListener { listOfBooleans[2] = true }
        playerDice4.setOnClickListener { listOfBooleans[3] = true }
        playerDice5.setOnClickListener { listOfBooleans[4] = true }
        //score button on click listener
        scoreButton.setOnClickListener {
            score()
            reRollbutton.visibility = View.INVISIBLE

        }
        // go back button on click Listener
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //re rall button on click listerener
        reRollbutton.setOnClickListener {
            plrReRoll()

        }

    }

    //roll method for player and computer
    private fun roller() {
        scoreButton.visibility = View.VISIBLE
        //make for re-roll button visible
        reRollbutton.visibility = View.VISIBLE
        //player roll
        plrRollDiceImg(playerDice1)
        plrRollDiceImg(playerDice2)
        plrRollDiceImg(playerDice3)
        plrRollDiceImg(playerDice4)
        plrRollDiceImg(playerDice5)
        //computer roll using function i have created
        compRollDiceImg(systemDice1)
        compRollDiceImg(systemDice2)
        compRollDiceImg(systemDice3)
        compRollDiceImg(systemDice4)
        compRollDiceImg(systemDice5)
        plrReRollCount = 0
        rollButton.visibility = View.INVISIBLE
        winnerIdentifier()
        compReRoll()
    }

    //reroll method for user
    private fun plrReRoll() {
        //index is used to identify the stored score to re write them with new values
        var index: Int
        //condition statement for the number of clicks re throw
        if (plrReRollCount <2) {
            index = rollCount * 5

            //re roll counter for counting number of time re roll button clicked
            if (!listOfBooleans[0]) {
                plrReRollDiceImage(playerDice1, index)
            }
            index++
            if (!listOfBooleans[1]) {
                plrReRollDiceImage(playerDice2, index)
            }
            index++
            if (!listOfBooleans[2]) {
                plrReRollDiceImage(playerDice3, index)
            }

            index++
            if (!listOfBooleans[3]) {
                plrReRollDiceImage(playerDice4, index)
            }

            index++
            if (!listOfBooleans[4]) {
                plrReRollDiceImage(playerDice5, index)
            }
            plrReRollCount++
//else statement if the user clicks the re roll button a third time and what happens if they do
        } else if (plrReRollCount == 2) {
            Toast.makeText(
                applicationContext, "you only allow to re-roll twice.", Toast.LENGTH_SHORT
            ).show()
            score()

            reRollbutton.visibility = View.INVISIBLE
            plrReRollCount = 0
            rollButton.visibility = View.VISIBLE

        }
        //erase the arraylist with boolean of images clicked on by user before rethrowing
        listOfBooleans.clear()
        listOfBooleans.add(false)
        listOfBooleans.add(false)
        listOfBooleans.add(false)
        listOfBooleans.add(false)
        listOfBooleans.add(false)

    }


    //computer re throw
    private fun compReRoll() {
        //random boolean for computer random decides if he want to re roll or not
        val randomDecision = Random.nextBoolean()
        if (randomDecision) {
            val compReRoll = Random.nextInt(0, 1)

            for (y in 0..compReRoll) {
//index to find the location of the last 5 dices on the list to re roll them as needed
                var index = rollCount * 5
                //function called with perameter passed for index and image dice name for computer
                compReRollDiceImg(systemDice1, index)
                index++
                compReRollDiceImg(systemDice2, index)

                index++
                compReRollDiceImg(systemDice3, index)

                index++
                compReRollDiceImg(systemDice4, index)

                index++
                compReRollDiceImg(systemDice5, index)

            }
            Toast.makeText(this, "computer has rerolled " + (compReRoll + 1), Toast.LENGTH_SHORT)
                .show()
        }
    }


    //player roll function for dice
    private fun plrRollDiceImg(img: ImageView) {
        //random int generator
        roll = Random.nextInt(0, 5)
        //set image for dices
        img.setImageResource(diceFacesList[roll])
        //add to player list
        plrRollScoreList.add(roll + 1)
    }

    //computer roll dice images and points
    private fun compRollDiceImg(img: ImageView) {
//random generator
        roll = Random.nextInt(0, 6)
        //add the random generator plus 1 to list to make the range from 1 to 6 for score
        comptrScoreList.add(roll + 1)
        //image setting for dice displayed to user
        img.setImageResource(diceFacesList[roll])
    }

    //re roll function for computer
    private fun compReRollDiceImg(img: ImageView, index: Int) {
//random generator
        roll = Random.nextInt(0, 6)
        //add the random generator plus 1 to list to make the range from 1 to 6 for score
        comptrScoreList[index] = roll + 1
        //image setting for dice displayed to user
        img.setImageResource(diceFacesList[roll])
    }

    //player roll function with two parameter( the dice image item and the index number
    private fun plrReRollDiceImage(img: ImageView, index: Int) {

        roll = Random.nextInt(0, 5)
        img.setImageResource(diceFacesList[roll])
        plrRollScoreList[index] = roll + 1
    }


    //score calculator
    @SuppressLint("SetTextI18n")
    private fun score() {
        //user arraylist calculate with pre define function for both player and score
        pScore = plrRollScoreList.sum()
        cScore = comptrScoreList.sum()
        //display the result on screen for user to view
        score.text = " score:$pScore/$cScore"
//the roll button visiblity setting
        winnerIdentifier()
        rollButton.visibility = View.VISIBLE
//check who wins the game
        //roll counter to keep track of the number of rounds
        rollCount++
    }

    //check who scored 101 or higher
    private fun winnerIdentifier() {


        val resultDisplay = Intent(this, outcomeActivity::class.java)
        //condition for when both computer and player reach the win target at the same round
        //condition for when  player reach the  target first

        if (pScore >= target) {
            if (cScore >= target) {
                roller()
            } else {
                resultDisplay.putExtra("image", R.drawable.winner)
                resultDisplay.putExtra("outcomeResult", 1)
                humanWin++
                resultDisplay.putExtra("humanWin", humanWin)
                resultDisplay.putExtra("compWin", computerWin)

                startActivity(resultDisplay)
            }
        }
        //condition for when  player reach the win target first
        if (cScore >= target) {
            if (pScore >= target) {
                roller()
            } else {
                resultDisplay.putExtra("image", R.drawable.lose)
                resultDisplay.putExtra("outcomeResult", 0)
                computerWin++
                resultDisplay.putExtra("humanWin", humanWin)

                resultDisplay.putExtra("compWin", computerWin)
                startActivity(resultDisplay)
            }
        }
    }


}






