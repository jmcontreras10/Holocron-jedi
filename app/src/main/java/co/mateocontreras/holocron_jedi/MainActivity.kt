package co.mateocontreras.holocron_jedi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.mateocontreras.holocron_jedi.core.Navigation
import co.mateocontreras.holocron_jedi.ui.theme.HolocronjediTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            HolocronjediTheme {
                Navigation()
            }
        }
    }
}
