package com.adityabrian.tampiltext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentObjectActivity : AppCompatActivity() {

    private lateinit var tvReceiver : TextView

    companion object {
        const val EKSTRA_MOBIL = "extra mobil"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_object)

        tvReceiver = findViewById(R.id.tv_objectReciever)

            /** kita disini tinggal menangkap dari MainActivity2 tadi */
        val mobil: Mobil = intent.getParcelableExtra(EKSTRA_MOBIL)!!

            /** Disini kita tinggal membuat teks untuk menampung parcelable tadi */
        val text = "Merk : ${mobil.merk} \nTahun : ${mobil.tahun} \nPlat : ${mobil.plat}"

            /** lalu kita ubah teks penerima tadi*/
        tvReceiver.text = text
    }
}