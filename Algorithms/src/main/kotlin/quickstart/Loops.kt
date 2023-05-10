package quickstart

fun main(args: Array<String>) {

    var str = "simplemente un conchasumer muy poderoso"

    for( s in str)
        println(s)

    for( i in str.indices)
        println(i)

    for( (i,s) in str.withIndex())
        println("$i : $s")
}