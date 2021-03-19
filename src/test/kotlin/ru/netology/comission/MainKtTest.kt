package ru.netology.comission

import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun getComission_testShouldDoDiscountByMastercard() {
        val comission = getComission(1, 50000000, 50000)
        assertEquals(comission, 2300)
    }

    @Test
    fun getComission_testShouldDoDiscountByVisa() {
        val comission = getComission(2, 50000000, 5000000)
        assertEquals(comission, 37500)
    }

    @Test
    fun getComission_testShouldDoDiscountByVisaEq35() {
        val comission = getComission(2, 50000000, 500)
        assertEquals(comission, 3500)
    }
    @Test
    fun getComission_testShouldDoDiscountByVKPay() {
        val comission = getComission(0, 50000000, 50000)
        assertEquals(comission, 0)
    }
}