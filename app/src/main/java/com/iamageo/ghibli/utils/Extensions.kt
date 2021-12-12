package com.iamageo.ghibli.utils

fun IntToHoursAndMinutes(minutes: Int) : String {
    val hours: Int = minutes / 60
    val min: Int = minutes % 60

    return hours.toString() + "h:" + min + "min"
}



