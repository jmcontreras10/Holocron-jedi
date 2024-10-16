package co.mateocontreras.holocron_jedi.exercise_catalog.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import co.mateocontreras.holocron_jedi.R
import co.mateocontreras.holocron_jedi.exercise_catalog.view_model.ExerciseViewModel


@Composable
fun ExerciseDetailScreen(id: String) {

    val viewModel: ExerciseViewModel = hiltViewModel()
    val exercise by viewModel.exerciseDetailLiveData.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchExerciseDetail(id)
    }

    if(exercise != null) {
        Column(modifier = Modifier.padding(24.dp)) {
            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = exercise!!.name,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = exercise!!.name, fontSize = 24.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "${exercise!!.muscularGroup} | ")
                Text(
                    text = exercise!!.location,
                    color = Color.Gray
                )
            }
            Text(text = exercise!!.category)
            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
            Text(text = exercise!!.description)
        }
    } else {Text("Exercise not found")}
}