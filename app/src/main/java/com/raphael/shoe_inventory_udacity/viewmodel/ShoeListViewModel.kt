package com.raphael.shoe_inventory_udacity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raphael.shoe_inventory_udacity.data.Shoes

class ShoeListViewModel : ViewModel() {


    private var _shoes = MutableLiveData<MutableList<MutableList<String>>>()
    val shoes: LiveData<MutableList<MutableList<String>>>
        get() = _shoes

    var _shoeName = MutableLiveData<String?>()
    val shoeName: MutableLiveData<String?>
        get() = _shoeName

    var _shoeCompany = MutableLiveData<String?>()
    val shoeCompany: LiveData<String?>
        get() = _shoeCompany

    var _shoeSize = MutableLiveData<String?>()
    val shoeSize: LiveData<String?>
        get() = _shoeSize

    var _shoeDescription = MutableLiveData<String?>()
    val shoeDescription: MutableLiveData<String?>
        get() = _shoeDescription

    // This create the list of shoes
    var shoesAdded = mutableListOf(
        mutableListOf("Udacity", "Access bank", "wear it"),
    )

    // helps add more shoes
    fun addShoeDetails(text: MutableList<String>) {
        shoes.value?.add(text)
    }

    // perform adding views to fragment everytime it gets data from the details fragment
    init {
        _shoes.value = shoesAdded
    }

    // Clear the fields after navigation is complete
    fun navigationComplete() {
        _shoeName.value = null
        _shoeCompany.value = null
        _shoeSize.value = null
        _shoeDescription.value = null
    }

}