package delegation

/*
abstract class Printer {

    init {
        println("Available colors ${getColors()}")
    }

    abstract fun getColors(): String
}

class OfficePrinter(private val colors: String): Printer() {

    override fun getColors(): String {
        return colors
    }
}

fun main() {
    val secondFloorPrinter = OfficePrinter("Black/White")
}*/

interface ColorDelegate {
    fun getColors(): String
}

class BlackWhiteDelegate : ColorDelegate {

    init {
        println("Available colors: ${getColors()}")
    }

    override fun getColors(): String {
        return "Black/White"
    }
}

class OfficePrinter(private val colorDelegate: ColorDelegate) : ColorDelegate by colorDelegate

fun main() {
    val secondFloorPrinter = OfficePrinter(BlackWhiteDelegate())
}
