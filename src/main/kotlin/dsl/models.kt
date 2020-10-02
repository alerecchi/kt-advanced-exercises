package dsl

data class Html(val head: Head, val body: Body)

data class Head(val tag: List<Tag>)

data class Body(val tag: List<Tag>)

abstract class Tag(val htmlTag: String)

data class Title(val text: String): Tag("title")

data class H1(val text: String): Tag("h1")
data class P(val children: List<Tag>): Tag("p")
data class B(val text: String): Tag("b")
data class A(val link: String, val text: String): Tag("a")

data class TextTag(val text: String) : Tag("")
