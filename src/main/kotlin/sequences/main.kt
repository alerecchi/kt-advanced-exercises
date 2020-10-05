package sequences

fun main() {
    val listOfCrimes = getCrimeList()
    /*measureAndPrintTime("List first 2000 ROBBERY cases") {
        listOfCrimes
            .filter { it.type == "ROBBERY" }
            .take(2000)
            .forEach { println(it) }
    }*/
    measureAndPrintTime("Sequence first 2000 ROBBERY cases") {
        listOfCrimes
            .asSequence()
            .filter { it.type == "ROBBERY" }
            .take(2000)
            .forEach { println(it) }
    }
    measureAndPrintTime("Sequence first 2000 ROBBERY cases") {
        getCrimeListLazy()
            .filter { it.type == "ROBBERY" }
            .take(2000)
            .forEach { println(it) }
    }

}






