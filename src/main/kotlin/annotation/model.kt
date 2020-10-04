package annotation

@Json
data class UserProfile(
    val id: Int,
    @JsonName("name")
    val athleteName: String,
    val gender: String,
    @JsonSerializer
    val athleteProfile: AthleteProfile,
    @JsonExclude
    val email: String
)

@Json
data class AthleteProfile(
    val strength: Int,
    val height: String,
    val weight: Double
)

