package com.example.forumos.listposts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.forumos.api.Constants.Companion.BASE_URL
import com.example.forumos.model.ForumosPost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class ListFragmentViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<ForumosPost>>()
    val posts: MutableLiveData<List<ForumosPost>> = _posts

    fun getPosts() {
        /**
         * TODO: Um bom sitio para fazer uma chamada ao servidor
         */
    }

}