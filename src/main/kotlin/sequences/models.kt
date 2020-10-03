package sequences

import java.util.*

data class Crime(
    val id: Int,
    val caseNumber: String,
    val date: Date,
    val block: String,
    val reportingCode: String,
    val type: String,
    val description: String,
    val locationDescription: String,
    val arrest: Boolean,
    val domestic: Boolean,
    val district: String,
    val fbiCode: String,
    val latitude: Double?,
    val longitude: Double?,
)