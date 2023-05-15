package quickstart

fun main() {

    var str = "simplemente un conchasumare muy poderoso"

    for( s in str)
        println(s)

    for( i in str.indices)
        println(i)

    for( (i,s) in str.withIndex())
        println("$i : $s")
}