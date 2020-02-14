package com.example.rxandroidapp.ui.thirdFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.rxandroidapp.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.android.synthetic.main.third_fragment.*


class ThirdFragment : Fragment() {
    private lateinit var viewModel: ThirdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ThirdViewModel::class.java)
        val acct = GoogleSignIn.getLastSignedInAccount(activity)
        if (acct != null) {
            name.text = acct.displayName
            email.text = acct.email
            userId.text = acct.id
            url.text = acct.photoUrl.toString()
        }
    }

}
