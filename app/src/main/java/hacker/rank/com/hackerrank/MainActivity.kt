package hacker.rank.com.hackerrank

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    message.setText(R.string.title_home)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    message.setText(R.string.title_dashboard)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    message.setText(R.string.title_notifications)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        //---- Challenge V ----- diagonal difference
//        val sampleArray = Array(3) { Array<Int>(3) { 0 } }
//        sampleArray[0] = arrayOf(11, 2, 4)
//        sampleArray[1] = arrayOf(4, 5, 6)
//        sampleArray[2] = arrayOf(10, 8, -12)
//        diagonalDifference(sampleArray)
    }

//    //---- Challenge V ----- diagonal difference
//    fun diagonalDifference(arr: Array<Array<Int>>): Int {
//
//        val d1 = Array(arr.size) { 0 }
//        val d2 = Array(arr.size) { 0 }
//        for (i in 0 until arr.size) {
//            d1[i] = arr[i][i]
//        }
//        for (j in (arr.size - 1) downTo 0) {
//            d2[(arr.size - 1) - j] = arr[j][(arr.size - 1) - j]
//        }
//        return Math.abs(d1.sum() - d2.sum())
//    }
}
