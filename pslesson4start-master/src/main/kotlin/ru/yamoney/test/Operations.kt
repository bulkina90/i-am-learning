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

data class P2PTransfer(
    override val sum: BigDecimal,
    override val user: String,
    val recipient: String
) : Operation {
    override fun calculate(oldBalance: BigDecimal): BigDecimal {
        var Balance = oldBalance
        if (this.user == user) {
            Balance -= sum
        }   else if (this.user == recipient){
            Balance += sum
        }
        return Balance
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


}



