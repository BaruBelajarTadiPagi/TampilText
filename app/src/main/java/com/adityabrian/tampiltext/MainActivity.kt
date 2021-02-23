package com.adityabrian.tampiltext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var edText: EditText
    lateinit var btnSubmit: Button
    lateinit var tvTampil :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edText = findViewById(R.id.et_input)
        btnSubmit = findViewById(R.id.btn_submit)
        tvTampil = findViewById(R.id.tv_tampil)

        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.btn_submit){
                /** disini menampung idi tv tmapil tadi dari edText ke tv_tampil*/
            val isiEditText = edText.text.toString()
            tvTampil.text = isiEditText
        }
    }
}