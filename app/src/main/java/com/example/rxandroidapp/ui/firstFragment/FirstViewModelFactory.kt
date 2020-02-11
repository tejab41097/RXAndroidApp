package com.example.rxandroidapp.ui.firstFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FirstViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return {
//            firstRepository
//        }as T
        return {} as T
    }
}