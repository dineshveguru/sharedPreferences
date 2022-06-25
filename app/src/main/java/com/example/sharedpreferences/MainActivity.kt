package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val inputid = binding.inputid
//        val inputname = binding.editName
//        val outputid = binding.textviewshowid
//        val outputname = binding.textviewshowname
//        val btn_save = binding.save
//        val btn_clear = binding.clear
//        val btn_view = binding.view
//
//        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
//        btn_save.setOnClickListener {
//            val id:Int = Integer.parseInt(inputid.text.toString())
//            val name:String = inputname.text.toString()
//            val editor: SharedPreferences.Editor = sharedPreferences.edit()
//            editor.putInt("id_key", id)
//            editor.putString("name_key", name)
//            editor.apply()
//            editor.commit()
//        }
//
//        btn_view.setOnClickListener {
//            val sharedid = sharedPreferences.getInt("id_key", 0)
//            val sharedname = sharedPreferences.getString("name_key", "default")
//            outputid.text = sharedid.toString()
//            outputname.setText(sharedname).toString()
//        }
//
//        btn_clear.setOnClickListener {
//            val editor = sharedPreferences.edit()
//            editor.clear()
//            editor.apply()
//            outputname.text = ""
//            outputid.text = ""
//        }


        val inputid = binding.inputid
        val inputname = binding.editName
        val outputname = binding.textviewshowname
        val outputid = binding.textviewshowid
        val save = binding.save
        val clear = binding.clear
        val view = binding.view

        val sharedPreferences: SharedPreferences = this.getSharedPreferences("kotlinsharedprefernces", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        save.setOnClickListener {
            val id: Int = Integer.parseInt(inputid.text.toString())
            val name: String = inputname.text.toString()
            editor.putInt("key_id", id)
            editor.putString("key_name", name)
            editor.apply()
            editor.commit()
        }

        view.setOnClickListener {
            val out_id = sharedPreferences.getInt("key_id", 0)
            val out_name = sharedPreferences.getString("key_name", "default")
            outputid.text = out_id.toString()
            outputname.text = out_name.toString()
        }
//        dinesh

        clear.setOnClickListener {
            editor.clear()
            outputname.text = ""
            outputid.text = ""
        }

    }
}