package ru.yamoney.test

import org.junit.Test
import java.lang.IllegalArgumentException

const val USAGE_MESSAGE ="""
    java -jar app.jar [COMMAND] [ARGUMENTS]
                Commands:
                payment %USER% %SUM% %SHOP_ID%
                deposit %USER% %SUM%
                balance %USER%
                shop_info %SHOP_ID%
"""

 class AppTest {

    @Test
    fun myFun() {
        println("Hello, world")
    }

    @Test
    fun payment() {
        main(arrayOf("payment", "Петя", "3", "4454"))
    }

    @Test
    fun deposit() {
        main(arrayOf("deposit", "Петя", "11", "4454"))
    }

    @Test
    fun balance() {
        //main(arrayOf("balance", "Вася"))
        main(arrayOf("balance", "Петя"))
    }

    @Test
    fun shopInfo() {
        main(arrayOf("shop_info", "4454"))
    }

     @Test
     fun p2pTransfer() {
         main(arrayOf("p2p_transfer", "Вася", "Петя", "5"))
     }
}
