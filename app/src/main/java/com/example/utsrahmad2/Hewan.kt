package com.example.utsrahmad2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Hewan(
    val imghewan: Int,
    val namehewan: String,
    val deschewan: String
) : Parcelable
