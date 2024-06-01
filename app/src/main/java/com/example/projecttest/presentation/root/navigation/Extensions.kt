package com.example.projecttest.presentation.root.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <T : Fragment> T.withArguments(block: Bundle.() -> Unit) = this.apply {
    arguments = Bundle().apply(block)
}
