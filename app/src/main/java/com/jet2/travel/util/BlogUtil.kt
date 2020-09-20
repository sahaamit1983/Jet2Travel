package com.jet2.travel.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


object BlogUtil {

    fun convertToK(count: Long?) : String {
        if(count?.compareTo(1000)!! >= 0) {
            val pos = count.toString().length -2
            val result = count.toString().substring(startIndex = 0, endIndex = pos).toLong()
            val remainder = result % 10
            val precision = result / 10
            if(remainder.compareTo(0) == 0 and precision.compareTo(0)) {
                return "1K"
            }
            return "$precision.${remainder}K"
        }
        return count.toString()
    }

    fun convertTime(date: String) : String? {
        try {
            /** DEBUG dateStr = '2006-04-16T04:00:00Z' **/
            val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val d1 = formatter.parse(date)
            val diff = System.currentTimeMillis() - d1.time
            val diffDays = diff / (24 * 60 * 60 * 1000)
            if(diffDays.compareTo(0) == 0 ) {
                val diffHours = diff / (60 * 60 * 1000) % 24
                if(diffHours.compareTo(0) == 0 ) {
                    val diffMinutes = diff / (60 * 1000) % 60
                    if(diffMinutes.compareTo(0) == 0 ) {
                        return "$diffMinutes min"
                    }
                    val diffSeconds = diff / 1000 % 60
                    return "$diffSeconds sec"
                } else {
                    return "$diffHours hr"
                }
            } else {
                return "$diffDays days"
            }
        } catch (e: Exception){
            Log.e("mDate", e.toString()) // this never gets called either
        }
        return ""
    }
}