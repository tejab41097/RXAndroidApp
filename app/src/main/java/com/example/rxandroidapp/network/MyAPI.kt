package com.example.rxandroidapp.network

import com.example.rxandroidapp.data.Post
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface MyAPI {

    @get:GET("posts")
    val getPosts: Observable<List<Post>>

    companion object RetrofitObject {
        private val URL = "https://jsonplaceholder.typicode.com/"

        operator fun invoke(): MyAPI {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient.newBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(MyAPI::class.java)
        }
    }
}