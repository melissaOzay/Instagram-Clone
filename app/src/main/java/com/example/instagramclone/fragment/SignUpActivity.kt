package com.example.instagramclone.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth
    }

    fun signUpClicked(view: View) {
        val email = binding.tvMail.text.toString()
        val name = binding.tvName.text.toString()
        val userName = binding.tvUserName.text.toString()
        val password = binding.tvPass.text.toString()

        if (email.equals("") || name.equals("") || userName.equals("") || password.equals("")) {
            Toast.makeText(this, "Boxes cannot be left blank", Toast.LENGTH_LONG).show()

        } else {
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                //kullanıcı email ve şifre ile giriş yapacaktır ve bu kod blogu sayesinde kodum asekron çalışacak.
                val intent = Intent(this, SignOnActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }

        }
    }

}