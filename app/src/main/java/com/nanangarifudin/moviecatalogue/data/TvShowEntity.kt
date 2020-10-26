package com.nanangarifudin.moviecatalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowEntity(
    var id : Int,
    var title : String,
    var description : String,
    var poster : Int
) : Parcelable