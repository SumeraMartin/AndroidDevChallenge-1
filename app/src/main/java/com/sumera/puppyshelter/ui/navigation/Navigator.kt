package com.sumera.puppyshelter.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.sumera.puppyshelter.ui.screens.puppydetail.PuppyDetailScreen
import com.sumera.puppyshelter.ui.screens.puppylist.PuppyListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navigator = remember { Navigator(navController) }

    NavHost(navController, startDestination = "puppies") {
        composable("puppies") { PuppyListScreen(navigator) }
        composable(
            "puppies/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val puppyId = arguments.getString("id") ?: error("Required argument is missing")
            PuppyDetailScreen(puppyId, navigator)
        }
    }
}

class Navigator(private val navController: NavController) {

    fun navigateBack() {
        navController.popBackStack()
    }

    fun navigateToPuppyDetail(id: String) {
        navController.navigate("puppies/$id")
    }
}
