package com.example.rxandroidapp.ui.firstFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rxandroidapp.repository.FirstRepository

@Suppress("UNCHECKED_CAST")
class FirstViewModelFactory(
    private val firstRepository: FirstRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FirstViewModel(
            firstRepository
        ) as T
    }
}