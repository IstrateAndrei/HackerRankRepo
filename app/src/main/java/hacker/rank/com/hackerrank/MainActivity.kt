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



        twoArrays(3, arrayOf(1, 2, 0), arrayOf(0, 3, 1))
    }


    fun twoArrays(k: Int, A: Array<Int>, B: Array<Int>): String {

        val arr = MutableList(0) { 0 }
        val brr = MutableList(0) { 0 }

        for (i in 0 until A.size) {
            for (j in 0 until B.size) {
                if (A[i] + B[j] >= k && !brr.contains(B[j])) {
                    arr.add(i, A[i])
                    brr.add(i, B[j])
                    break
                }
            }
        }
        return if (arr.size == A.size && brr.size == B.size) "YES" else "NO"
    }
}
