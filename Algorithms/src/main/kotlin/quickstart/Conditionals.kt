package quickstart

fun main(){
    var a = (Math.random() * 20).toInt();
    var b = (Math.random() * 20).toInt();
    var c = (Math.random() * 20).toInt();

    var res = "the lengths $a, $b, $c "

    res += if( a + b > c && b + c > a && a + c > b)
        "represent a valid triangle"
    else
        "cannot represent a valid triangle"

    println(res)

}
