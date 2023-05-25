package quickstart



fun main() {

    var noNullableBook = Book("The Gods Themselves", "Isaac Asimov", 500)
    //noNullableBook = null
    println("No nullable: ${noNullableBook.noPages}")

    var nullableBook :Book? = Book("", "", 100)
    nullableBook = null

    //compilation error
    //println("Nullable book: ${nullableBook.noPages}")

    //safe pre-testing
    println("Nullable book pre-test: ${if(nullableBook!=null) nullableBook.noPages else 0}")

    //safe call
    println("Nullable book safe call: ${nullableBook?.noPages}")

    //elvis operator
    println("Nullable book elvis operator: ${nullableBook?.noPages ?: -1}")



}