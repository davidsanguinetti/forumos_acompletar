package com.example.forumos.postinsert

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forumos.api.Constants.Companion.BASE_URL
import com.example.forumos.model.ForumosPost
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertPostViewModel : ViewModel() {
    val successInsertion = MutableLiveData<Boolean>()

    fun insertPost(newPost : ForumosPost) {



        viewModelScope.launch {
            /**
             *  TODO: um excelente sitio para adicionar (ou POSTar) uma chamada ao servidor
             */
        }
    }
}