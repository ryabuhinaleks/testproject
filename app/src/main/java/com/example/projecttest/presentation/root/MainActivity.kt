package com.example.projecttest.presentation.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.projecttest.R
import com.example.projecttest.presentation.root.navigation.FragmentRouter
import com.example.projecttest.presentation.screen.estatelist.EstateListFragment

class MainActivity : AppCompatActivity(), FragmentRouter {

    private val container: FragmentContainerView by lazy {
        findViewById(R.id.mainContainer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forward(EstateListFragment.newInstance())
    }

    override fun forward(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(container.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun close() {
        supportFragmentManager.popBackStack()
    }
}
