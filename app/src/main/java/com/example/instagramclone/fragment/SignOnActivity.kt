package com.example.instagramclone.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramclone.MainActivity
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivitySignOnLayoutBinding
import com.example.instagramclone.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignOnActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignOnLayoutBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignOnLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth
        val currentUser=auth.currentUser
        if(currentUser !=null){
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
            finish()
            //bu kod parçacığı , kullanıcı eğer daha önceden giriş yapmışsa bu sayfayı otomatik olarak atlatır.
        }

    }

    fun signOnClicked(view: View) {
        val email = binding.tvUserName.text.toString()
        val password = binding.tvPass.text.toString()

        if (email.equals("") || password.equals("")){
            Toast.makeText(this, "Boxes cannot be left blank", Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                //kullanıcı email ve şifre ile giriş yapacaktır ve bu kod blogu sayesinde kodum asekron çalışacak.
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }

        }
    }
    fun signUpClicked(view: View){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

}