package delegation.android

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*const val VALUE1 = ""

class MyDataSharedPref(private val context: Context) {

    val sharedPref: SharedPreferences by lazy {
        context.getSharedPreferences("myCache", Context.MODE_PRIVATE)
    }

    fun setValue1(value1: String) {
        sharedPref.edit().putString(VALUE1, value1).apply()
    }

    fun getValue1(): String {
        return sharedPref.getString(VALUE1, "") ?: ""
    }


}*/
/*

const val VALUE1 = ""
class MyDataSharedPref(private val context: Context) {

    var value1 by SharedPreferencesDelegate(VALUE1)

    val sharedPref: SharedPreferences by lazy {
        context.getSharedPreferences("myCache", Context.MODE_PRIVATE)
    }
}

class SharedPreferencesDelegate(val id: String): ReadWriteProperty<MyDataSharedPref, String> {

    override fun setValue(thisRef: MyDataSharedPref, property: KProperty<*>, value: String) {
        thisRef.sharedPref.edit().putString(id, value).apply()
    }

    override fun getValue(thisRef: MyDataSharedPref, property: KProperty<*>): String {
        return thisRef.sharedPref.getString(id, "") ?: ""
    }
}
*/
