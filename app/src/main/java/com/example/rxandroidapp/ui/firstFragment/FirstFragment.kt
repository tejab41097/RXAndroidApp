package com.example.rxandroidapp.ui.firstFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxandroidapp.R
import com.example.rxandroidapp.network.MyAPI
import com.example.rxandroidapp.repository.FirstRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel
    internal lateinit var compositeDisposable: CompositeDisposable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val apiService = MyAPI.RetrofitObject()
        val firstRepository = FirstRepository(apiService)
        val factory = FirstViewModelFactory(firstRepository)
        compositeDisposable = CompositeDisposable()
        viewModel = ViewModelProviders.of(this, factory).get(FirstViewModel::class.java)

        view_recycler_first.setHasFixedSize(true)
        view_recycler_first.layoutManager = LinearLayoutManager(context)


        compositeDisposable.add(
            viewModel.getPosts()
            .subscribeOn(Schedulers.io())!!
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { posts ->
                val adapter = FirstRecyclerAdapter(context!!, posts)
                view_recycler_first.adapter = adapter
            })
    }

}
