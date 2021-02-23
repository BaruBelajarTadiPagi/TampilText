 package com.adityabrian.tampiltext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rgPilih : RadioGroup
    private lateinit var btnPilih : Button

    /** DISINI KITA MEMBUTUHKAN MEMBUAT companion object untuk result code*/
    companion object{
        val RESULT_CODE = 210
        val EXTRA_PILIH = "ekstra pilih"  /** SEBAGAI KEY nya*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        rgPilih = findViewById(R.id.id_rg)
        btnPilih = findViewById(R.id.btn_result)

        btnPilih.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_result){
            if(rgPilih.checkedRadioButtonId != 0){
                    /** kita membuat variabel untuk menampung value dari radio button*/
                    var nilai = 0
                when(rgPilih.checkedRadioButtonId){
                    R.id.id_1 -> nilai = 1
                    R.id.id_2 -> nilai = 2
                    R.id.id_3 -> nilai = 3
                    R.id.id_4 -> nilai = 4
                }
                    /** selanjutnya kita membuat intent untuk result nya*/
                val resultIntent = Intent()

                    /** kita masukin EXTRA NYA yang akan kita EXTRA kan*/
                resultIntent.putExtra(EXTRA_PILIH,nilai)
                setResult(RESULT_CODE, resultIntent)

                    /** disini kita finis karena agar nantinya kembali ke MainActivity*/
                finish()
            }
        }
    }
}