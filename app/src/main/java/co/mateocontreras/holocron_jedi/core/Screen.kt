package co.mateocontreras.holocron_jedi.core

sealed class Screen(val route: String) {
    object ExerciseSearchScreen: Screen("exercise_search_screen")
    object ExerciseDetailScreen: Screen("exercise_detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}