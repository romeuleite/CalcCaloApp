package com.example.projetofinal.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetofinal.data.DataSource

class FoodViewModel : ViewModel() {

    val foodItems = DataSource.foodItems

    private var previousCalories = 0.0

    private val _tmb = MutableLiveData(0.0)
    val tmb: LiveData<Double?> = _tmb

    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<Double?> = _subtotal

    private val _total = MutableLiveData(0.0)
    val total: LiveData<Double?> = _total


    fun setClickedRadioButton(number: Double) {
        previousCalories = number

        _subtotal.value = (_subtotal.value ?: 0.0) + previousCalories

        _total.value = (_total.value ?: 0.0) - previousCalories

    }


    fun setTmb(rate: Double) {
        _tmb.value = rate
        _total.value = rate
    }

}