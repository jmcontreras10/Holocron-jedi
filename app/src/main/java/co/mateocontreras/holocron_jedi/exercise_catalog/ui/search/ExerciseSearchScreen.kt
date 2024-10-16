package co.mateocontreras.holocron_jedi.exercise_catalog.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.mateocontreras.holocron_jedi.R
import co.mateocontreras.holocron_jedi.core.Screen
import co.mateocontreras.holocron_jedi.exercise_catalog.domain.Exercise
import co.mateocontreras.holocron_jedi.exercise_catalog.view_model.ExerciseViewModel


@Composable
fun ExerciseSearchScreen(navController: NavController) {
    val viewModel: ExerciseViewModel = hiltViewModel()
    val exercises by viewModel.exercisesLiveData.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.findExercises()
    }

    LazyColumn {
        itemsIndexed(exercises) { _, exercise ->
            ExerciseItem(exercise, navController)
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise, navController: NavController) {
    Column {
        ListItem(
            headlineContent = {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(exercise.name)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "${exercise.muscularGroup} | ")
                        Text(
                            text = exercise.location,
                            color = Color.Gray
                        )
                    }
                }
            },
            leadingContent = {
                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = exercise.name
                )
            },
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.ExerciseDetailScreen.withArgs(exercise.id))
                }
        )
        HorizontalDivider()
    }
}