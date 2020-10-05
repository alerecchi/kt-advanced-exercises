package delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

enum class SpellCheckType { EMAIL, PASSWORD, TEXT }

/*
abstract class SpellCheckableScreen {

    init {
        println("I can spellcheck")
    }

    fun spellCheck(string: String, checkType: SpellCheckType): String {
        TODO()
    }
}

abstract class ScrollableScreen: SpellCheckableScreen() {

    init {
        println("I can scroll")
    }

    fun scroll(){
        TODO()
    }
}

class LoginScreen: ScrollableScreen() {

    private lateinit var _email: String
    private lateinit var _password: String

    fun setEmail(string: String) {
        _email = spellCheck(string, SpellCheckType.EMAIL)
    }

    fun setPassword(string: String) {
        _password = spellCheck(string, SpellCheckType.PASSWORD)
    }
}

class RegistrationScreen: ScrollableScreen() {

    private lateinit var _name: String
    private lateinit var _surname: String
    private lateinit var _email: String
    private lateinit var _password: String

    fun setName(string: String) {
        _name = spellCheck(string, SpellCheckType.TEXT)
    }

    fun setSurname(string: String) {
        _surname = spellCheck(string, SpellCheckType.TEXT)
    }

    fun setEmail(string: String) {
        _email = spellCheck(string, SpellCheckType.EMAIL)
    }

    fun setPassword(string: String) {
        _password = spellCheck(string, SpellCheckType.PASSWORD)
    }
}*/

class SpellCheckDelegate(private val spellCheckType: SpellCheckType) : ReadWriteProperty<Any, String> {

    var internalString = ""

    init {
        println("I can spellcheck")
    }

    private fun spellCheck(string: String, checkType: SpellCheckType): String {
        TODO()
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        internalString = spellCheck(value, spellCheckType)
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return internalString
    }
}

interface Scrollable {
    fun scroll()
}

class ScrollDelegate() : Scrollable {

    init {
        println("I can scroll")
    }

    override fun scroll() {
        TODO("Not yet implemented")
    }
}

class LoginScreen(scrollDelegate: ScrollDelegate): Scrollable by scrollDelegate{
    var email by SpellCheckDelegate(SpellCheckType.EMAIL)
    var password by SpellCheckDelegate(SpellCheckType.PASSWORD)
}