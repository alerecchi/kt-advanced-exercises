package dsl

fun main() {
    val html = getHtml()
    println(html)
}

@DslMarker
annotation class HtmlDsl

@HtmlDsl
fun html(block: HtmlBuilder.() -> Unit): Html {
    return HtmlBuilder().apply(block).build()
}

fun getHtml(): Html = html {
    head {
        title { "Experimenting with DSLs "}
    }
    body {
        h1 { "This page is made with a DSL" }
        a("www.google.com") {"link to google"}
        p {
            +"Mixed content with text"
            a("www.google.com") {"a link"}
            b { "and some bold text" }
        }
    }
}