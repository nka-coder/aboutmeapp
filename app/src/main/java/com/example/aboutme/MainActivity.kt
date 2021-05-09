package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
        //}
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //nicknameTextView.text = editText.text
        //editText.visibility = View.GONE
        //view.visibility = View.GONE
        //nicknameTextView.visibility = View.VISIBLE
        binding.apply {
            //nicknameText.text = binding.nicknameEdit.text
            myName?.fullname = fullnameEdit.text.toString()
            myName?.firstname = fullnameEdit.text.split(" ")[0].toString()
            myName?.bio = "Hi, my name is "+ myName?.firstname +".\n\nI love fish." +
                    "\n\nThe kind that is alive and swims around in an aquarium or river, or a lake, and definitely the ocean." +
                    "\nFun fact is that I have several aquariums and also a river." +
                    "\nI like eating fish too. Raw fish. Grilled fish. Smoked fish. Poached fish - not so mush." +
                     "\nAnd sometimes I even go fishing.\n" +
                    "\nAnd even less sometimes, I actually catch something." +
                    "\n\nOnce, when I was camping in Canada, and very hungry, I even caught a large salmon with my hand." +
                    "\n\nI\'ll be happy to teach you how to make your own aquarium." +
                    "\nYou should ask someone else\n"
            invalidateAll()
            fullnameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            firstnameText.visibility = View.VISIBLE
            starImage.visibility = View.VISIBLE
            bioScroll.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}