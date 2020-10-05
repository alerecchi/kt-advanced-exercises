package sequences

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import kotlin.system.measureTimeMillis

val df = SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa")

fun getCrimeList(): List<Crime> {
    val listOfString = getListFromFile()
    return listOfString
        .drop(1)
        .map {
            it.toCrime()
        }
}

fun getCrimeListLazy(): Sequence<Crime> {
    val reader = readFileLazy()
    return generateSequence {
        reader.readLine()
    }
        .drop(1)//Skipping the first line because it contains the columns name
        .map { it.toCrime() }
}

fun getListFromFile(): List<String> {
    return File("files/crimes.csv").readLines()
}

fun readFileLazy(): BufferedReader {
    return File("files/crimes.csv").bufferedReader()
}

fun String.toCrime(): Crime {
    val fields = this.split(',')
    return Crime(
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

fun measureAndPrintTime(string: String, block: () -> Unit) {
    measureTimeMillis {
        block()
    }.run {
        println()
        println("$string in ${this}ms")
    }
}