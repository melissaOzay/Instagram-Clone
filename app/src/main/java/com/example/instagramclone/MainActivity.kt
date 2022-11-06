package com.example.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.instagramclone.fragment.PostFragment
import com.instagram.fragment.HomeFragment
import com.instagram.fragment.ProfileFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
    var bottomNav: ChipNavigationBar? = null
    var fragmentManager: FragmentManager? = null
    private val homeFragment by lazy {
        HomeFragment()
    }

    private val addFragment by lazy {

    }

    private val postFragment by lazy {
        PostFragment()
    }
    private val favoritesFragment by lazy {

    }
    private val profileFragment by lazy {
        ProfileFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentView, HomeFragment()).commit()
        bottomNav = findViewById(R.id.bottomNavMenu)
        bottomNav?.setItemSelected(R.id.home)
        bottomNav?.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                var fragment: Fragment? = null
                when (id) {
                    R.id.home -> fragment = homeFragment
                    R.id.profile -> fragment = profileFragment
                    R.id.post -> fragment = postFragment
                }
                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager()
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.fragmentView, fragment)
                        ?.commit()
                }
            }
        })
    }
}