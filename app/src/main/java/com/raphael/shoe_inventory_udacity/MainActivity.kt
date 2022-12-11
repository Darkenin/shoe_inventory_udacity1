package com.raphael.shoe_inventory_udacity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FInd nav controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.NavHostFragment)
        val navController = navHostFragment!!.findNavController()

        // Hookup nav UI with action bar
        NavigationUI.setupActionBarWithNavController(this, navController)
        //Hook up drawer with UI
        appBarConfiguration = AppBarConfiguration(navController.graph)
    }

    // Handle what happens when up button is pressed
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.NavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

}