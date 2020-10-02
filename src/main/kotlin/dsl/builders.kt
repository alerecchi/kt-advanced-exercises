package dsl

@HtmlDsl
class HtmlBuilder {

    private lateinit var head: Head
    private lateinit var body: Body

    fun head(block: HeadBuilder.() -> Unit) {
        head = HeadBuilder().apply(block).build()
    }

    fun body(block: BodyBuilder.() -> Unit) {
        body = BodyBuilder().apply(block).build()
    }

    fun build(): Html {
        return Html(head, body)
    }
}

@HtmlDsl
class HeadBuilder {

    private val tags = mutableListOf<Tag>()

    fun title(block: () -> String) {
        tags.add(
            Title(
                block()
            )
        )
    }

    fun build(): Head {
        return Head(tags)
    }
}

@HtmlDsl
class BodyBuilder {

    private val tags = mutableListOf<Tag>()

    fun h1(block: () -> String) {
        tags.add(
            H1(block())
        )
    }

    fun a(href: String, block: () -> String) {
        tags.add(
            A(href, block())
        )
    }

    fun p(block: PBuilder.() -> Unit) {
        tags.add(
            PBuilder().apply(block).build()
        )
    }

    fun build(): Body {
        return Body(tags)
    }
}

@HtmlDsl
class PBuilder {

    val tags = mutableListOf<Tag>()



    fun build(): P {
        return P(tags)
    }
}
