package quickstart

fun main(){
    display('A', 3, true)
    display('A', 3)
    display('A')
    display(sign = 'A', withIndices = true)
}

fun display(sign: Char, amount: Int = 1, withIndices: Boolean = false){

    if(withIndices)
        for(i in 1..amount)
            println(i)

    for(i in 1..amount)
        println(sign)

}