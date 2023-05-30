package algorithms.sort.insert

class InsertSortRecursive {

    fun sort(elements: MutableList<Int>): MutableList<Int> {

        return sort(elements, 1)
    }

    private fun sort(elements: MutableList<Int>, index: Int): MutableList<Int> {

        if (index >= elements.size)
            return elements

        val key = elements[index]
        val prevIndex = index - 1

        replaceBackwards(elements, key, prevIndex)

        return sort(elements, index + 1)
    }

    private fun replaceBackwards(elements: MutableList<Int>, key: Int, prevIndex: Int) {
        if(prevIndex < 0 || key >= elements[prevIndex])
           return

        elements[prevIndex + 1] = elements[prevIndex]
        elements[prevIndex] = key

        replaceBackwards(elements, key, prevIndex-1)

    }


}