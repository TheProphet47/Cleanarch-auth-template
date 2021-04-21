package com.freesia.homeownersnotices.cleanarch.presentation.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.freesia.homeownersnotices.R
import com.freesia.homeownersnotices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView()
        initViewModel()

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.main_frame, MainFragment.newInstance())
//                    .commitNow()
//        }
    }

    private fun initView() {
        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(binding.toolbar.mainToolbar)

        val hostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        navController = hostFragment.navController

    }

    private fun initViewModel() {

    }


    override fun onBackPressed() {
        if (!navController.popBackStack()) finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}