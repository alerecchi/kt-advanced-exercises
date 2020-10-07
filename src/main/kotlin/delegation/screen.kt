package delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*

enum class SpellCheckType { EMAIL, PASSWORD, TEXT }

abstract class TorchableScreen() {

    init {
        println("I can toggle the torch")
    }

    fun toggleTorch() {
        TODO()
    }
}

abstract class SpellCheckableScreen : TorchableScreen() {

    init {
        println("I can spellcheck")
    }

    fun spellCheck(string: String, checkType: SpellCheckType): String {
        TODO()
    }
}

class LoginScreen : SpellCheckableScreen() {

    private lateinit var _email: String
    private lateinit var _password: String

    fun setEmail(string: String) {
        _email = spellCheck(string, SpellCheckType.EMAIL)
    }

    fun setPassword(string: String) {
        _password = spellCheck(string, SpellCheckType.PASSWORD)
    }
}

class RegistrationScreen : SpellCheckableScreen() {

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
}

class FeedbackScreen: SpellCheckableScreen() {

    ???
}*/

enum class SpellCheckType { EMAIL, PASSWORD, TEXT }

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

interface Torchable {
    fun toggleTorch()
}

class TorchDelegate() : Torchable {

    init {
        println("I can toggle the torch")
    }

    override fun toggleTorch() {
        TODO("Not yet implemented")
    }
}

class LoginScreen(torchDelegate: TorchDelegate) : Torchable by torchDelegate {
    var email by SpellCheckDelegate(SpellCheckType.EMAIL)
    var password by SpellCheckDelegate(SpellCheckType.PASSWORD)

}