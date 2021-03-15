package ru.netology.just
/*
https://github.com/netology-code/kt-homeworks/tree/master/03_control#задача-1---только-что
* */
fun agoToText(seconds: Int): String {
    return when {
        justNow(seconds) -> "только что"
        someMinAgo(seconds) -> "${specMinAgo(seconds)} ${caseOfMin(seconds)} назад"
        someHoursAgo(seconds) -> "${specHoursAgo(seconds)} ${caseOfHours(seconds)} назад"
        today(seconds) -> "Сегодня"
        yesterday(seconds) -> "Вчера"
        else -> "Давно"
    }

}

fun caseOfHours(seconds: Int): String {
    val hours = specHoursAgo(seconds)
    return when{
        hours == 21 -> "час"
        hours == 1 -> "час"
        hours > 21 -> "часа"
        hours > 5 -> "часов"
        hours > 1 -> "часа"
        else -> "часов"
    }
}

fun caseOfMin(seconds: Int): String {
    val minutes = specMinAgo(seconds)
    return when{
        minutes == 11 -> "минут"
        minutes % 100 == 11 -> "минут"
        minutes % 10 == 1 -> "минуту"
        minutes == 1 -> "минуту"
        minutes == 2 -> "минуты"
        else -> "минут"
    }
}

fun specHoursAgo(seconds: Int): Int {
    return (seconds / 60 / 60)
}

fun specMinAgo(seconds: Int): Int {
    return (seconds / 60)
}

fun yesterday(seconds: Int): Boolean {
    return seconds < 24 * 60 * 60 * 3
}

fun today(seconds: Int): Boolean {
    return seconds < 24 * 60 * 60 * 2
}

fun someHoursAgo(seconds: Int): Boolean {
    return seconds < 24 * 60 * 60
}

fun someMinAgo(seconds: Int): Boolean {
    return seconds < 60 * 60
}

fun justNow(seconds: Int): Boolean {
    return seconds < 60
}


fun main() {
    println(agoToText(50000))
}