
package ru.yamoney.test

import java.lang.IllegalArgumentException
import java.math.BigDecimal

const val USAGE_MESSAGE = """
java -jar app.jar [COMMAND] [ARGUMENTS]
            Commands:
            payment %USER% %SUM% %SHOP_ID%
            deposit %USER% %SUM%
            balance %USER%
            shop_info %SHOP_ID%
            p2p_transfer %USER% %RECIPIENT% %SUM%
"""
val billing: Billing = BillingImpl()

fun main(args: Array<String>) {
    try {
        when(args.command()) {
            "PAYMENT" -> billing.addOperation(
                Payment(BigDecimal(args[2]), args[1], args[3]))
            "DEPOSIT" -> billing.addOperation(
                Deposit(BigDecimal(args[2]), args[1]))
            "BALANCE" -> billing.getUserBalance(args[1])
            "SHOP_INFO" -> billing.getShopIdOperations(args[1])
            "P2P_TRANSFER" -> billing.addOperation(
                P2PTransfer(BigDecimal(args[3]), args[1], args[2]))
            else -> throw IllegalArgumentException("Unknown command")
        }

    } catch (e: Throwable) {
        e.printStackTrace()
        println(USAGE_MESSAGE)

    }

}


private fun Array<String>.command(): String = this[0].toUpperCase()



