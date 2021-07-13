package ru.yamoney.test

interface Billing {
    fun getShopIdOperations(shopId: String)
    fun getUserBalance(user: String)
    fun addOperation(operation: Operation)
}