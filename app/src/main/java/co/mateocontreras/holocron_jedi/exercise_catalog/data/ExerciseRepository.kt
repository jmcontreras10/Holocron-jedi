package co.mateocontreras.holocron_jedi.exercise_catalog.data

import javax.inject.Inject


class ExerciseRepository @Inject constructor (
    private val apiService: ExerciseApiService
) {
    suspend fun getExercises() = apiService.getExercises()
    suspend fun getExerciseById(id: String) = apiService.getExerciseById(id)
}
