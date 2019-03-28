package hacker.rank.com.hackerrank

import java.text.DecimalFormat



fun main(){

//Challenge V ----- diagonal difference
        val sampleArray = Array(3) { Array<Int>(3) { 0 } }
        sampleArray[0] = arrayOf(11, 2, 4)
        sampleArray[1] = arrayOf(4, 5, 6)
        sampleArray[2] = arrayOf(10, 8, -12)
        diagonalDifference(sampleArray)

//Challenge VI ----- under decimal lists
        plusMinus(arrayOf(-1, 0, 2, 3, 4, -5))

//Challenge VII ------ # staircase
        staircase(6)


//Challenge VIII ----------- Mini-Max Sum
        miniMaxSum(arrayOf(5, 5, 5, 5, 5))

//Challenge IX -------------- Birthday Cake Candles
        birthdayCakeCandles(arrayOf(1,2,3,4,4))

//Challenge X --------- Time 12 -> 24 format
        timeConversion("12:45:40PM")
}



//    //---- Challenge V ----- diagonal difference
    fun diagonalDifference(arr: Array<Array<Int>>): Int {

        val d1 = Array(arr.size) { 0 }
        val d2 = Array(arr.size) { 0 }
        for (i in 0 until arr.size) {
            d1[i] = arr[i][i]
        }
        for (j in (arr.size - 1) downTo 0) {
            d2[(arr.size - 1) - j] = arr[j][(arr.size - 1) - j]
        }
        return Math.abs(d1.sum() - d2.sum())
    }

//---- Challenge VI ----- under decimal lists
    fun plusMinus(arr: Array<Int>): Unit {
        val positiveArr = arr.filter { item -> item > 0 }
        val negativeArr = arr.filter { item -> item < 0 }
        val neutralArr = arr.filter { item -> item == 0 }

        val decimalFormat = DecimalFormat("#.######")
        val arr1 = ((positiveArr.size.toDouble() / arr.size.toDouble()))
        val arr2 = ((negativeArr.size.toDouble() / arr.size.toDouble()))
        val arr3 = ((neutralArr.size.toDouble() / arr.size.toDouble()))

        println(decimalFormat.format(arr1))
        println(decimalFormat.format(arr2))
        println(decimalFormat.format(arr3))
    }

//    Challenge VII - staircase of #
    fun staircase(n: Int): Unit {
        var line: String = ""
        val space: String = " "
        val hashtag: String = "#"

        for (i in 0 until n) {
            for (j in n - 2 downTo 0) {
                line += if (j < i) hashtag
                else space
            }
            line += if (i < n - 1) {
                hashtag + "\n"
            } else hashtag
        }
        println(line)
    }

//    Challenge VIII - Mini-Max Sum
    fun miniMaxSum(arr: Array<Int>): Unit {

        val tempArr = mutableListOf<MutableList<Int>>()

        tempArr.add(0, mutableListOf())
        val minArr: Array<Long> = Array(4) { 0L }
        val maxArr: Array<Long> = Array(4) { 0L }

        for (i in 0 until 4) {
            tempArr.add(i, mutableListOf())
            if (i == 0) {
                maxArr[i] = arr.max()!!.toLong()
                arr.filterTo(tempArr[i]) { it -> it != arr.max()!! }
            } else {
                if (tempArr[i - 1].isNotEmpty()) {
                    maxArr[i] = tempArr[i - 1].max()!!.toLong()
                    tempArr[i - 1].filterTo(tempArr[i]) { it -> it != tempArr[i - 1].max()!! }
                } else
                    maxArr[i] = arr.max()!!.toLong()
            }
        }
        tempArr.clear()
        for (i in 0 until 4) {
            tempArr.add(i, mutableListOf())
            if (i == 0) {
                minArr[i] = arr.min()!!.toLong()
                arr.filterTo(tempArr[i]) { it -> it != arr.min()!! }
            } else {
                if (tempArr[i - 1].isNotEmpty()) {
                    minArr[i] = tempArr[i - 1].min()!!.toLong()
                    tempArr[i - 1].filterTo(tempArr[i]) { it -> it != tempArr[i - 1].min()!! }
                } else
                    minArr[i] = arr.min()!!.toLong()
            }
        }
        println("${minArr.sum()} ${maxArr.sum()}")
    }

//    -------- Challenge IX -------- BirthdayCake Candles
    fun birthdayCakeCandles(ar: Array<Int>): Int {
        //note here --- "Terminated due to timeout error" be careful with long array operations
        var size = 0
        val max = ar.max()
        for (i in 0 until ar.size) {
            if (ar[i] == max) size += 1
        }
        return size
    }
//
//    ----------  Challenge X --------- Time 12 -> 24 format
    fun timeConversion(s: String): String {
        var hour = s.substring(0, 2).toInt()
        if (s.substring(s.length - 2) == "PM") hour += 12
        else if (hour == 12) hour = 0
        val timeFormat = DecimalFormat("##")
        if (hour >= 24) hour = 12
        return if (hour < 10) "0${timeFormat.format(hour)}:${s.substring(3, 5)}:${s.substring(6, 8)}"
        else "${timeFormat.format(hour)}:${s.substring(3, 5)}:${s.substring(6, 8)}"
    }