package com.example.phone_book.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacts(

    val name : String,
    val number : String

):Parcelable
