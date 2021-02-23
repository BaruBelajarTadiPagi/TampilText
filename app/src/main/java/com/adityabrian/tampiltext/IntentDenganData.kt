package com.adityabrian.tampiltext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentDenganData : AppCompatActivity() {

    companion object{
            /** Extra text tu yang akan kita pindahkan, jadi kita memanggil
             *  di putExtra() dengan variabel ini */
        const val EXTRA_TEXT = "extra text"
    }

    private lateinit var tvReceiver : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_dengan_data)

        /** setelah kita deklarasikan ,kita akan menangkap intentnya terlebih dahulu*/
        tvReceiver = findViewById(R.id.tv_PenerimaData)

            /** kita tangkap Intentnya karena yang diterima value string
             *  karena di class MainActivity2 isi dari EXTRA_TEKS memiliki value sendiri jadi akan berubah
             *      KITA DISINI BARU MENANGKAPNYA */
        val textReceived = intent.getStringExtra(EXTRA_TEXT)

            /** disini kita akan menampilkannya*/
        val text = "Teks yang di terima : $textReceived"

            /** lalu kita ganti tv receiver nya*/
        tvReceiver.text = text

    }
}