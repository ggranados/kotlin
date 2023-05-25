package quickstart

data class Worker(var first:String, var last:String, val id:Int)

fun main() {
    var w1 = Worker("Emiliano", "Zapata", 111)
    var w2 = Worker("Benito", "Juarez", 232)
    var w3 = Worker("Andres Manuel", "Lopez", 2024)

    println(w1)

    println("w3 = w2 ? ${w3==w2}")

    var w4 = w3.copy()
    println("w3 = w4 ? ${w3==w4}")

    var w5 = w3.copy(id=1234)
    println("w3 = w5 ? ${w3==w5}")
}