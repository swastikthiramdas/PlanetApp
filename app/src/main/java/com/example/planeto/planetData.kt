package com.example.planeto

import android.os.Parcel
import android.os.Parcelable

data class planetData(
    val id:Int,
    val tittle:String?,
    val galaxy:String?,
    val distance:String?,
    val gravity:String?,
    val overview:String?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(tittle)
        parcel.writeString(galaxy)
        parcel.writeString(distance)
        parcel.writeString(gravity)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<planetData> {
        override fun createFromParcel(parcel: Parcel): planetData {
            return planetData(parcel)
        }

        override fun newArray(size: Int): Array<planetData?> {
            return arrayOfNulls(size)
        }
    }

}
