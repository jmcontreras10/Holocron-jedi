package co.mateocontreras.holocron_jedi.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.mateocontreras.holocron_jedi.exercise_catalog.ui.search.ExerciseSearchScreen
import co.mateocontreras.holocron_jedi.exercise_catalog.ui.detail.ExerciseDetailScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ExerciseSearchScreen.route) {
        composable(route = Screen.ExerciseSearchScreen.route) {
            ExerciseSearchScreen(navController = navController)
        }
        composable(
            route = Screen.ExerciseDetailScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )) { entry ->
            entry.arguments?.getString("id")?.let { ExerciseDetailScreen(id = it) }
        }
    }
}
