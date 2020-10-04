package annotation

import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties

fun main() {
    val userProfile = UserProfile(
        1,
        "Jhon",
        "Male",
        AthleteProfile(
            10,
            "195cm",
            88.4
        ),
        "email@athlete.com"
    )

    println(serialize(userProfile))
}

fun serialize(obj: Any): String {
    val kClass = obj::class

    if (!kClass.hasAnnotation<Json>())
        throw IllegalArgumentException("Class is not annotated with @Json")

    val output: List<String?> = kClass.memberProperties.map { property ->
        serializeProperty(property, obj)
    }

    return "{ ${output.filterNotNull().joinToString()} }"
}

fun serializeProperty(property: KProperty1<*, *>, obj: Any): String? {
    if (property.hasAnnotation<JsonExclude>())
        return null

    val nameAnnotation = property.findAnnotation<JsonName>()

    val name = "\"${nameAnnotation?.name ?: property.name}\""
    val getterValue = property.getter.call(obj)
    val value = if (property.hasAnnotation<JsonSerializer>()) {
        //It means that it's a subclass that we can deserialize
        getterValue?.let { serialize(it) }
    } else {
        "\"${getterValue.toString()}\""
    }

    return "$name:$value"
}