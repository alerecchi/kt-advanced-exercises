package sequences

import java.io.File
import java.text.SimpleDateFormat
import kotlin.system.measureTimeMillis

fun getCrimeList(): List<Crime> {
    val listOfString = getListFromFile()
    val df = SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa")
    return listOfString
        .drop(1)
        .map {
            val fields = it.split(',')
            Crime(
                id = fields[0].toInt(),
                caseNumber = fields[1],
                date = df.parse(fields[2]),
                block = fields[3],
                reportingCode = fields[4],
                type = fields[5],
                description = fields[6],
                locationDescription = fields[7],
                arrest = fields[8].toBoolean(),
                domestic = fields[9].toBoolean(),
                district = fields[11],
                fbiCode = fields[14],
                latitude = fields[19].toDoubleOrNull(),
                longitude = fields[20].toDoubleOrNull()
            )
        }
}

fun getListFromFile(): List<String> {
    return File("files/crimes.csv").readLines()
}

fun measureAndPrintTime(string: String, block: () -> Unit) {
    measureTimeMillis {
        block()
    }.run {
        println()
        println("$string in ${this}ms")
    }
}