package co.mateocontreras.holocron_jedi.exercise_catalog.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.mateocontreras.holocron_jedi.exercise_catalog.data.ExerciseRepository
import co.mateocontreras.holocron_jedi.exercise_catalog.domain.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
): ViewModel() {
    private val _exercisesLiveData = MutableLiveData<List<Exercise>>()
    val exercisesLiveData: LiveData<List<Exercise>> get() = _exercisesLiveData

    private val _exerciseDetailLiveData = MutableLiveData<Exercise>()
    val exerciseDetailLiveData: LiveData<Exercise> get() = _exerciseDetailLiveData

    fun findExercises() {
        viewModelScope.launch {
            try {
                val newItem = withContext(Dispatchers.IO) {
                    exerciseRepository.getExercises()
                }
                _exercisesLiveData.postValue(newItem)
            } catch (e: Exception) {
                Log.e("getDetail", "Error fetching details: ${e.message}")
            }
        }
    }

    fun fetchExerciseDetail(exerciseId: String) {
        viewModelScope.launch {
            try {
                val exercise = exerciseRepository.getExerciseById(exerciseId)
                _exerciseDetailLiveData.postValue(exercise)
            } catch (e: Exception) {
                Log.e("getDetail", "Error fetching details: ${e.message}")
            }
        }
    }
}