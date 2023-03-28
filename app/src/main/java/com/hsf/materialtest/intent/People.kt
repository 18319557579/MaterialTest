package com.hsf.materialtest.intent

import android.os.Parcel
import android.os.Parcelable

class People() : Parcelable {
    var name = ""
    var age = 0

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeInt(age)
    }

    companion object CREATOR : Parcelable.Creator<People> {
        override fun createFromParcel(parcel: Parcel): People {
            val people = People()
            people.name = parcel.readString() ?: ""
            people.age = parcel.readInt()
            return people
        }

        override fun newArray(size: Int): Array<People?> {
            return arrayOfNulls(size)
        }
    }
}