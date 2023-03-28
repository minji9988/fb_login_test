package com.example.fb_login_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//사용자가 버튼 클릭 시 그 사용자에게 UID 값이란 걸 부여한다.
// 그 UID값을 통해서 비회원도 북마크 할 수 있고, 그 기록 저장해서
// 비회원한테 보여줄 수도 있다.


class MainActivity : AppCompatActivity() {

    //firebase 인증기능 사용
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //firebase 인증기능 사용
        auth = Firebase.auth


        val btn = findViewById<Button>(R.id.noEmailLoginBtn)
        btn.setOnClickListener {


            //인증 기능 중 익명 기능을 사용하겠다.

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->


                    if (task.isSuccessful) {

                        //로그인에 성공하면 현재 유저의 값을 가져올 수 있다.
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser

                        Log.d("MainAcitivy", user!!.uid)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        }
    }
}