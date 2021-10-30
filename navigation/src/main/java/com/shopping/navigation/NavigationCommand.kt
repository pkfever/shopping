package com.shopping.navigation

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class To(val direction: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
}