package com.raphael.shoe_inventory_udacity.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoes(
    var shoeName: String,
    var size: String,
    var shoePrice: String,
    var shoesDetails: String,
    var shoeManufacturer: String,
): Parcelable
