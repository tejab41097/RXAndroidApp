package com.example.rxandroidapp.ui.firstFragment

import androidx.lifecycle.ViewModel
import com.example.rxandroidapp.data.Post
import com.example.rxandroidapp.repository.FirstRepository
import io.reactivex.Observable

class FirstViewModel(
    private val firstRepository: FirstRepository
) : ViewModel() {


    fun getPosts(): Observable<List<Post>> {
        return firstRepository.getPosts()
    }
}
