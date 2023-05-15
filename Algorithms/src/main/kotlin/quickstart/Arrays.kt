package quickstart

fun main() {

    var arr = DoubleArray(10)

    for(i in arr.indices)
        arr[i] = Math.random() * 100

    val avg = arr.average();
    println("average = $avg")

    for(d in arr) {
        println("$d is ${
            if(d > avg) "higher"
            else "lower"
        }")
    }


}