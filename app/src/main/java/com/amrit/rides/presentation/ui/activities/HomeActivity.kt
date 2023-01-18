package com.amrit.rides.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import com.amrit.rides.R

class HomeActivity : AppCompatActivity() {
    private lateinit var navGraph: NavGraph
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initNavGraph()
    }

    private fun initNavGraph() {
        navController = findNavController(R.id.fragmentContainer)
        navGraph = navController.navInflater.inflate(R.navigation.ride_nav_graph)
    }
}