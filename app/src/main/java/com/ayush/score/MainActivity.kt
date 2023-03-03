package com.ayush.score

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    var tvScoreTeamOne: TextView? = null
    var tvScoreTeamOneFinal: TextView? = null
    var tvScoreTeamTwoFinal: TextView? = null
    var tvScoreTeamTwo: TextView? = null
    var tvTeamName: TextView? = null
    var imgAddscoreTeamOne: ImageView? = null
    var imgSubscoreTeamOne: ImageView? = null
    var imgAddscoreTeamTwo: ImageView? = null
    var imgSubscoreTeamTwo: ImageView? = null
    var switchChange: Switch? = null
    var swNightMode: Switch? = null
    var rbTwoGoal: RadioButton? = null
    var rbThreeGoal: RadioButton? = null
    var rbFourGoal: RadioButton? = null
    var rbFiveGoal: RadioButton? = null
    var rgScore: RadioGroup? = null
    var btDes: Button? = null
    var btAdd: Button? = null
    var inGoal = 2
    var stTeam = "TEAMA"
    var lvMain: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindID()
    }

    fun bindID() {
        //bind all the ids
        tvScoreTeamOne = findViewById<View>(R.id.tvScoreTeamOne) as TextView
        tvScoreTeamOneFinal = findViewById<View>(R.id.tvScoreTeamOneFinal) as TextView
        tvScoreTeamTwoFinal = findViewById<View>(R.id.tvScoreTeamTwoFinal) as TextView
        tvScoreTeamTwo = findViewById<View>(R.id.tvScoreTeamTwo) as TextView
        tvTeamName = findViewById<View>(R.id.tvTeamName) as TextView
        imgAddscoreTeamOne = findViewById<View>(R.id.imgAddscoreTeamOne) as ImageView
        imgSubscoreTeamOne = findViewById<View>(R.id.imgSubscoreTeamOne) as ImageView
        imgAddscoreTeamTwo = findViewById<View>(R.id.imgAddscoreTeamTwo) as ImageView
        imgSubscoreTeamTwo = findViewById<View>(R.id.imgSubscoreTeamTwo) as ImageView
        switchChange = findViewById<View>(R.id.switchChange) as Switch
        rbTwoGoal = findViewById<View>(R.id.rbTwoGoal) as RadioButton
        rbThreeGoal = findViewById<View>(R.id.rbThreeGoal) as RadioButton
        rbFourGoal = findViewById<View>(R.id.rbFourGoal) as RadioButton
        rbFiveGoal = findViewById<View>(R.id.rbFiveGoal) as RadioButton
        rgScore = findViewById<View>(R.id.rgScore) as RadioGroup
        btAdd = findViewById<View>(R.id.btAdd) as Button
        btDes = findViewById<View>(R.id.btDes) as Button
        lvMain = findViewById(R.id.lvMain)
        //Initiate SharedPref Class

        //Enable or Disable night mode
        //Using switch decide which side of teams is selected
        switchChange!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                stTeam = "TEAMB"
            } else {
                stTeam = "TEAMA"

            }
        }
        rgScore!!.setOnCheckedChangeListener { group, i ->

            //radiogroup will check which radio button is used
            val checkedID = rgScore!!.checkedRadioButtonId
            when (checkedID) {
                R.id.rbTwoGoal -> {
                    inGoal = 2

                }
                R.id.rbThreeGoal -> {
                    inGoal = 3

                }
                R.id.rbFourGoal -> {
                    inGoal = 4

                }
                R.id.rbFiveGoal -> {
                    inGoal = 5

                }
            }
        }
        btAdd!!.setOnClickListener {
            //Add button going to add score
            fun onClick(v: View?) {
                setNewGoalScore(stTeam, inGoal, "add")
            }
        }
        btDes!!.setOnClickListener {
            fun onClick(v: View?) {
                setNewGoalScore(stTeam, inGoal, "sub")
            }
        }
        imgAddscoreTeamOne!!.setOnClickListener{
            //add one goal into Team A

                val oldScore = tvScoreTeamOne!!.text.toString()
                val intNewScore = oldScore.toInt() + 1
                tvScoreTeamOne!!.text = intNewScore.toString()
                tvScoreTeamOneFinal!!.text = intNewScore.toString()

        }
        imgSubscoreTeamOne!!.setOnClickListener {
            //minus one goal into Team A
            fun onClick(v: View?) {
                val oldScore = tvScoreTeamOne!!.text.toString()
                val intNewScore = oldScore.toInt() - 1
                tvScoreTeamOne!!.text = intNewScore.toString()
                tvScoreTeamOneFinal!!.text = intNewScore.toString()

            }
        }
        imgAddscoreTeamTwo!!.setOnClickListener {
            //add one goal into Team B
            fun onClick(v: View?) {
                val oldScore = tvScoreTeamTwo!!.text.toString()
                val intNewScore = oldScore.toInt() + 1
                tvScoreTeamTwo!!.text = intNewScore.toString()
                tvScoreTeamTwoFinal!!.text = intNewScore.toString()

            }
        }
        imgSubscoreTeamTwo!!.setOnClickListener {
            fun onClick(v: View?) {
                //minus score of team 2
                val oldScore = tvScoreTeamTwo!!.text.toString()
                val intNewScore = oldScore.toInt() - 1
                tvScoreTeamTwo!!.text = intNewScore.toString()
                tvScoreTeamTwoFinal!!.text = intNewScore.toString()

            }
        }
    }



    fun setNewGoalScore(stTeam: String, i: Int, stButton: String) {
        //this method is used for add and minus goals accordind to user selection
        if (stTeam === "TEAMA") {
            if (stButton === "add") {
                //add team A goals and set value into textview
                val oldScore = tvScoreTeamOne!!.text.toString()
                val intNewScore = oldScore.toInt() + i
                tvScoreTeamOne!!.text = intNewScore.toString()
                tvScoreTeamOneFinal!!.text = intNewScore.toString()

            } else {
                //Minus Team A goals and set value into textview
                val oldScore = tvScoreTeamOne!!.text.toString()
                val intNewScore = oldScore.toInt() - i
                tvScoreTeamOne!!.text = intNewScore.toString()
                tvScoreTeamOneFinal!!.text = intNewScore.toString()

            }
        } else {
            if (stButton === "add") {
                //Add team B goals and set value into textview
                val oldScore = tvScoreTeamTwo!!.text.toString()
                val intNewScore = oldScore.toInt() + i
                tvScoreTeamTwo!!.text = intNewScore.toString()
                tvScoreTeamTwoFinal!!.text = intNewScore.toString()

            } else {
                //Minus Team B goals and set value into textview
                val oldScore = tvScoreTeamTwo!!.text.toString()
                val intNewScore = oldScore.toInt() - i
                tvScoreTeamTwo!!.text = intNewScore.toString()
                tvScoreTeamTwoFinal!!.text = intNewScore.toString()

            }
        }
    }


}