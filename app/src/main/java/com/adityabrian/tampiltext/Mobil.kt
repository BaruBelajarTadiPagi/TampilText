package com.adityabrian.tampiltext

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

    /** kita dapat menggunakan @Parcelize tanpa mengimplement isi dari Parcelable tadi
     *  karena kita menggunakan androidEkstensions di gradle*/
@Parcelize
data class Mobil(
        val merk: String,
        val tahun: Int,
        val plat: String
    ) : Parcelable