package co.mateocontreras.holocron_jedi.exercise_catalog.domain
data class Exercise (
    var id: String,
    var name: String,
    var description: String,
    var category: String,
    var muscularGroup: String,
    var equipment: String,
    var location: String,
)