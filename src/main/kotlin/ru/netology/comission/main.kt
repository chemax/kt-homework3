package ru.netology.comission
/*
https://github.com/netology-code/kt-homeworks/tree/master/03_control#задача-2---разная-комиссия
 */

const val mastercardLimit = 75000_00
const val mastercardPercentComs = 0.006
const val mastercardStaticComs = 20_00
const val visaPercentComs = 0.0075
const val visaMinComsLimit = 35_00

fun main() {
    println(getComission(1, prevTransferSum = 50000000, transferSum = 5000))
}

fun getComission(type: Int = 0, prevTransferSum: Int = 0, transferSum: Int): Int {
    return when (type) {
        1 -> mastercard(prevTransferSum, transferSum)
        2 -> visa(transferSum)
        else -> 0 //vk pay
    }
}

fun visa(transferSum: Int): Int {
    return if(transferSum * visaPercentComs < visaMinComsLimit) visaMinComsLimit
    else (transferSum * visaPercentComs).toInt()
}

fun mastercard(prevTransferSum: Int, transferSum: Int): Int {
    return if (prevTransferSum < mastercardLimit) 0
    else (transferSum * mastercardPercentComs).toInt() + mastercardStaticComs
}
