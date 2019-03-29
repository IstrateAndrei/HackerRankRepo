package hacker.rank.com.hackerrank

fun main(){

//  Challenge I --- Customer Orders
    val sampleArr = Array(5) { Array(2) { 0 } }
    sampleArr[0] = arrayOf(8, 1)
    sampleArr[1] = arrayOf(4, 2)
    sampleArr[2] = arrayOf(5, 6)
    sampleArr[3] = arrayOf(3, 1)
    sampleArr[4] = arrayOf(4, 3)
    jimOrders(sampleArr)
}


//  Challenge I --- Customer Orders
fun jimOrders(orders: Array<Array<Int>>): Array<Int> {

    val timeArr = MutableList(orders.size) { 0 }
    for (i in 0 until orders.size) {
        timeArr[i] = orders[i][0] + orders[i][1]
    }

    val indexArr = MutableList(0) { 0 }
    var customerIndex = 0
    for (i in orders.size - 1 downTo 0) {
        customerIndex = timeArr.indexOf(timeArr.min())
        indexArr.add(customerIndex + 1)
        timeArr[customerIndex] = timeArr.max()!! + 1
    }
    return indexArr.toTypedArray()
}