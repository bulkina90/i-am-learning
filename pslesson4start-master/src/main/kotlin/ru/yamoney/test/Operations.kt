package ru.yamoney.test

import java.math.BigDecimal

interface Operation {
    val sum: BigDecimal
    val user: String
    fun calculate(oldBalance: BigDecimal): BigDecimal
}
data class Deposit(
    override val sum: BigDecimal,
    override val user: String
) : Operation {
    override fun calculate(oldBalance: BigDecimal): BigDecimal {
       return oldBalance.plus(sum)
    }
}

data class Payment(
    override val sum: BigDecimal,
    override val user: String,
    val shopId: String
) : Operation {
    override fun calculate(oldBalance: BigDecimal): BigDecimal {
        return oldBalance.minus(sum)
    }

data class P2PTransfer(
    override val sum: BigDecimal,
    override val user: String,
    val recipient: String
    ) : Operation {

    override fun calculate(oldBalance: BigDecimal): BigDecimal {

        return oldBalance

    }
    // нужно сделать как-то так, если в файле для операции он стоит как пользовтаель то отнимает, если ресипиент, то получает.Но пока
    // не понимаю как это реализовать внутри объявления класса
    fun p2p_calculate(oldBalance: BigDecimal, currentUser: String): BigDecimal {
        if (currentUser == user) {
            return oldBalance.minus(sum)
        }
        return oldBalance.plus(sum)
    }

}
}



