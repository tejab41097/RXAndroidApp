package com.example.rxandroidapp.ui.secondFragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.rxandroidapp.R
import com.example.rxandroidapp.ui.thirdFragment.ThirdFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class SecondFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModel: SecondViewModel
    private var RC_SIGN_IN: Int = 0
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var signInButton: SignInButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(context!!, gso)
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        signInButton = view!!.findViewById(R.id.sign_in_button)
        signInButton.setOnClickListener {
            Log.e("setOnClickListener", "done")
            signIn()
        }
        //signIn()
    }

    override fun onClick(v: View) {
        Log.e("onclick", "done")
        signIn()
//        when (v!!.id) {
//            R.id.sign_in_button -> signIn()
//        }
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(context)
        //updateUI(account)
    }

    private fun signIn() {
        Log.e("signIn", "done")
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e("requestCode", "done $requestCode")
        if (requestCode === RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            Log.e("handleSignInResult", "done")
            val account = completedTask.getResult(ApiException::class.java)
            Log.e("account", "name :- ${account!!.displayName} \n email :- ${account.email}")
            val sThirdFragment = ThirdFragment()
            fragmentManager!!
                .beginTransaction()
                .replace(R.id.frame_holder, sThirdFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        } catch (e: ApiException) { // The ApiException status code indicates the detailed failure reason.
// Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
        }
    }
}
