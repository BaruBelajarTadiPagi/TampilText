package com.adityabrian.tampiltext

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button
    private lateinit var btnPindahResult: Button
    private lateinit var tvHasil : TextView

        /** untuk menginisialisasikan request code,
         *  disini karena kita akan meminta berupa nilai Int*/
    companion object{
        const val REQUEST_CODE: Int = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Button Intent Biasa
        btnIntent = findViewById(R.id.btn_Intent)
        btnIntent.setOnClickListener(this)

        // Button Intent DenganData dengan cara lain
        val btnIntentData = findViewById<Button>(R.id.btn_Intent_Data)
        btnIntentData.setOnClickListener(this)

        // button parcelable move object
        val btnIntentObject = findViewById<Button>(R.id.btn_move_object)
        btnIntentObject.setOnClickListener(this)

        // Button Impicit Dial Up
        val btnIntentDial : Button = findViewById(R.id.btn_Implicit)
        btnIntentDial.setOnClickListener(this)

        // Button Result
        btnPindahResult = findViewById(R.id.btn_pindah_result)
        btnPindahResult.setOnClickListener(this)

        // TV Hasil Result
        tvHasil = findViewById(R.id.tv_hasil)
        tvHasil.setOnClickListener(this)


    }
        /** karena kita disini untuk menangkap isinya*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        /** disini kita membuat kondisi*/
        if(requestCode == REQUEST_CODE){
            if (resultCode == ResultActivity.RESULT_CODE){
                    /** disini kita tangkap nilainya yang sudah diresult kan nilai balikan
                     *
                     *  KARENA KITA MENANGKAP NILAI BERUPA INT MAKA MENGGUNAKAN .getInExtra()
                     *  diakhir kita menggunakan defaultValue dari 0 untuk mengantisipasi tidak ada nilai balik*/
                val nilaiPilih = data?.getIntExtra(ResultActivity.EXTRA_PILIH,0)

                    /** KITA SET ISINYA DARI dalam fun tadi*/
                tvHasil.text = "Nilai Yang diPilih : $nilaiPilih"
            }
        }
    }


        /** Intent itu ada 2 Explicit dan Implicit, saat ini kita menggunakan explicit */
    override fun onClick(v: View?) {
        /** di kotlin menggunakan switch catch nya begini,
         *   cara membacanya = ketika kita klikv.id maka lakukannlah btnIntent
         *   lalu inisialisasi intentBiasa dari MainActivity2 ke class IntentBiasaActovity*/
        when (v?.id) {
            R.id.btn_Intent -> run {
                val intentBiasa = Intent(this@MainActivity2, IntentBiasaActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.btn_Intent_Data -> run {
                val intentData = Intent(this@MainActivity2, IntentDenganData::class.java)
                /** karena kita ingin memindahkan data kita menggunakan putExtra() lalu kita pindahkan data tersebut ke
                 *  activity tujuan  untuk memudahannya kita buat dulu variabel di class tujuan
                 *  untuk mengisi nama dari extra ini tersebut,
                 *
                 *  apabila sudah di sebutkan class dan variabelnya lalu value ini adalah text yang dikirim */
                intentData.putExtra(IntentDenganData.EXTRA_TEXT, "Hallo Saya Calon Developer Expert")
                startActivity(intentData)
            }
            R.id.btn_move_object -> run {
                val mobil = Mobil(
                        merk = "Toyota Avanza",
                        tahun = 2010,
                        plat = "AD 1030 ECD"
                )
                val intentObject = Intent(this@MainActivity2,IntentObjectActivity::class.java)
                    /** Jika kita ingin memindahkan data kita harus mengekstrak*/
                intentObject.putExtra(IntentObjectActivity.EKSTRA_MOBIL, mobil)
                startActivity(intentObject)
            }
            R.id.btn_Implicit -> run {
                val telp = "082226151419"
                    /** kita menggunakan Intent untuk menentukan aksi nya dan Uri.parse
                     *   kita bisa mengarahkan apabila web menjadi "http : @variabel isi link tsb*/
                val intentTelp = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telp"))
                startActivity(intentTelp)
            }
            R.id.btn_pindah_result -> run{
                val intentPindahResult = Intent(this@MainActivity2,ResultActivity::class.java)
                    /** disini ada perbedaan karena kita akan menampilkan timbal balik maka isi argumennya
                     *  ada 2, yang kedua adalah requestnya , Kita membutuhkan request code maka dibuatlah companion object*/
                startActivityForResult(intentPindahResult, REQUEST_CODE)
            }
        }
    }
}