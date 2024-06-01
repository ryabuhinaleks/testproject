package com.example.projecttest.presentation.root.navigation

import androidx.fragment.app.Fragment

interface FragmentRouter {
    fun forward(fragment: Fragment)
}