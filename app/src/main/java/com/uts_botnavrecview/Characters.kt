package com.uts_botnavrecview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Characters(
    var imgCharacter : Int,
    var nameCharacter : String,
    var descChar : String
) :Parcelable

