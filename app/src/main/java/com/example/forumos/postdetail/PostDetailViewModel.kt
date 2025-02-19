package com.example.forumos.postdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forumos.api.Constants.Companion.BASE_URL
import com.example.forumos.model.ForumosPost
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostDetailViewModel : ViewModel() {
    val post = MutableLiveData<ForumosPost>()

    fun fetchPost(postId : Int) {
        /**
         * TODO: Mais um bom sitio para colocar uma chamada ao servidor
         */
    }



}