package quickstart

fun main() {

    var num = (Math.random() * 99 + 2).toInt()
    var isPrime = true;

    for(n in 2..num){
        isPrime = true
        for(i in 2 until n){
            if(n % i == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime)
            println("$n is prime")
    }


}
