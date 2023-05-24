package quickstart

fun main(){
    println( isOrdered( intArrayOf(1,2,3,4,5) ))
    println( isOrdered( intArrayOf(1,5,6,3,7) ))
    println( isOrdered( intArrayOf(1,2,3,4,5), asc = false))
    println( isOrdered( intArrayOf(5,4,3,2,1), false ))

    println( isOrderedMine( intArrayOf(1,2,3,4,5) ))
    println( isOrderedMine( intArrayOf(1,5,6,3,7) ))
    println( isOrderedMine( intArrayOf(1,2,3,4,5), asc = false))
    println( isOrderedMine( intArrayOf(5,4,3,2,1), false ))

    println( isOrderedGPT( intArrayOf(1,2,3,4,5) ))
    println( isOrderedGPT( intArrayOf(1,5,6,3,7) ))
    println( isOrderedGPT( intArrayOf(1,2,3,4,5), asc = false))
    println( isOrderedGPT( intArrayOf(5,4,3,2,1), false))

}

fun isOrderedMine( intArray: IntArray, asc: Boolean = true): Boolean{

    var result = true;

    for((i,n) in intArray.withIndex()){
        if(i > 0){
            val prev = intArray[i - 1]

            if(asc && n < prev)
                result = false

            if(!asc && n > prev)
                result = false
        }

    }

    return result
}

fun isOrderedGPT(intArray: IntArray, asc: Boolean = true): Boolean {
    for (i in 1 until intArray.size) {
        val current = intArray[i]
        val prev = intArray[i - 1]

        if ((asc && current < prev) || (!asc && current > prev)) {
            return false
        }
    }

    return true
}

fun isOrdered(numbers: IntArray, asc: Boolean = true) : Boolean {
    for(i in 0..numbers.size - 2)
        if(asc && numbers[i] > numbers[i+1] ||
            !asc && numbers[i] < numbers[i+1])
            return false
    return true
}