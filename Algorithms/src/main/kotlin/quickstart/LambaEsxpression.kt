package quickstart

fun main(){
    var arr = intArrayOf(4, 2, 7, 5, 9)

    printArray(map(arr) { x -> x * x })
    printArray(map(arr) { x -> -x })
}

fun map( intArr: IntArray, mapping: (Int)->Int ): IntArray{
    for(i in intArr.indices)
        intArr[i] = mapping(intArr[i])
    return intArr
}

fun printArray( arr: IntArray){
    for (i in arr)
        println("$i,")
}