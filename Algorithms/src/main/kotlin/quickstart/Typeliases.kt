package quickstart

typealias WorkerList = ArrayList<Worker>

fun main() {

    var w1 = Worker("Emiliano", "Zapata", 111)
    var w2 = Worker("Benito", "Juarez", 232)
    var w3 = Worker("Andres Manuel", "Lopez", 2024)

    val workers = WorkerList()
    workers.add(w1)
    workers.add(w2)
    workers.add(w3)

    print(workers)
}