package algorithms.sort

fun sort(elements: MutableList<Int>): MutableList<Int>{

    for(j in 1 until elements.size ){

        val key = elements[j]
        var i = j-1
        while(i >= 0 && key < elements[i]){
            elements[i+1] = elements[i]
            elements[i] = key
            i--
        }
    }

    return elements
}