package com.example.rxandroidapp.repository

import com.example.rxandroidapp.data.Post
import com.example.rxandroidapp.network.MyAPI
import io.reactivex.Observable

class FirstRepository(
    private val apiService: MyAPI
) {
    fun getPosts(): Observable<List<Post>> {
        return apiService.getPosts
    }
}