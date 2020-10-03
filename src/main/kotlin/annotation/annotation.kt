package annotation

@Target(AnnotationTarget.CLASS)
annotation class Json

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

@Target(AnnotationTarget.PROPERTY)
annotation class JsonName(val name: String)

@Target(AnnotationTarget.PROPERTY)
annotation class JsonSerializer