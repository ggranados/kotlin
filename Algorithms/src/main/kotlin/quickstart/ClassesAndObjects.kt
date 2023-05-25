package quickstart

fun main(){
    var b1 = Book("1984", "George Orwell", 250)
    println("is long book? : ${b1.isLongBook()}")

    var b2 = Book("Moby Dick", "Herman Melville")
    println("is long book? : ${b2.isLongBook()}")
}
class Book(var title: String, var author: String, var noPages: Int) {
    val LONG = 200

    init{
        println("initialization of: $title")
        if(noPages <= 0)
            noPages = 1
    }
    constructor(title: String, author: String): this(title, author, 0)
    {
        println("secondary constructor for $title")
        println("number of pages is $noPages")
    }

    fun isLongBook() = noPages > LONG
}