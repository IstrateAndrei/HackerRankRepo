package hacker.rank.com.hackerrank

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

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


        val sampleArr = Array(3) { Array(2) { 0 } }
        sampleArr[0] = arrayOf(5, 3)
        sampleArr[1] = arrayOf(3, 2)
        sampleArr[2] = arrayOf(6, 5)
        jimOrders(sampleArr)
    }


    fun jimOrders(orders: Array<Array<Int>>): Array<Int> {

        val timeArr = Array(orders.size) { 0 }
        for (i in 0 until orders.size) {
            timeArr[i] = orders[i][0] + orders[i][1]
        }
        val iterator = timeArr.iterator()
        return timeArr
    }

}
