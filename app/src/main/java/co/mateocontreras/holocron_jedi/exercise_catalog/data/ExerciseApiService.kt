package co.mateocontreras.holocron_jedi.exercise_catalog.data

import co.mateocontreras.holocron_jedi.exercise_catalog.domain.Exercise
import retrofit2.http.GET
import retrofit2.http.Path

interface ExerciseApiService {
    @GET("/api/v1/exercises/")
    suspend fun getExercises(): List<Exercise>

    @GET("/api/v1/exercises/{id}")
    suspend fun getExerciseById(@Path("id") id: String): Exercise
}