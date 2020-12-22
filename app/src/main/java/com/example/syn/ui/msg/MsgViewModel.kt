package com.example.syn.ui.msg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MsgViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is msg Fragment"
    }
    val text: LiveData<String> = _text
}