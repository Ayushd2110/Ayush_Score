//package com.ayush.score
//
//import android.os.Bundle
//import android.widget.LinearLayout
//import android.widget.Switch
//import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.app.AppCompatDelegate
//
//class SettingAtivity : AppCompatActivity() {
//    var swSave: Switch? = null
//    var lvMain: LinearLayout? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_setting)
//        SharedPrefManager.init(this@SettingAtivity)
//        bindID()
//        swSave!!.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) {
//                //Save the data
//                SharedPrefManager.putInt("Data_save", 0)
//                SharedPrefManager.putInt("switchCheck", 0)
//            } else {
//                //unSave the data
//                SharedPrefManager.putInt("Data_save", 1)
//                SharedPrefManager.putInt("switchCheck", 1)
//            }
//        }
//    }
//
//    private fun bindID() {
//        swSave = findViewById(R.id.swSave)
//        lvMain = findViewById(R.id.lvMain)
//        setSwitchCheck()
//    }
//
//    private fun setSwitchCheck() {
//        //check weather switch is already check or not
//        val isCheck = SharedPrefManager.getInt("switchCheck", 1)
//        if (isCheck == 0) {
//            swSave!!.isChecked = true
//            SharedPrefManager.putInt("Data_save", 0)
//        } else {
//            swSave!!.isChecked = false
//            SharedPrefManager.putInt("Data_save", 1)
//        }
//        setNightMode()
//    }
//
//    private fun setNightMode() {
//        //Change the theme according to sharedPref
//        val isDavaSave = SharedPrefManager.getInt("night_mode", 1)
//        if (isDavaSave == 0) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            SharedPrefManager.putInt("night_mode", 0)
//            lvMain!!.setBackgroundColor(resources.getColor(R.color.black))
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            SharedPrefManager.putInt("night_mode", 1)
//            lvMain!!.setBackgroundColor(resources.getColor(R.color.white))
//        }
//    }
//}