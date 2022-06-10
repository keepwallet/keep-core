package keep.core.model

import com.ionspin.kotlin.bignum.integer.BigInteger

sealed class Balance(
    val value: BigInteger
) {
    open fun includeToTotal(coin: Coin): Boolean = true
}

class Available(value: BigInteger) : Balance(value)
class Pending(value: BigInteger) : Balance(value = value)
class Frozen(value: BigInteger) : Balance(value = value) {
    override fun includeToTotal(coin: Coin): Boolean = when(coin) {
        Coin.BINANCE, Coin.TRON -> true
        else -> false
    }
}
class Locked(value: BigInteger) : Balance(value = value) {
    override fun includeToTotal(coin: Coin): Boolean = when(coin) {
        Coin.TRON, Coin.POLKADOT -> false
        else -> true
    }
}
class Staked(value: BigInteger) : Balance(value = value) {
    override fun includeToTotal(coin: Coin): Boolean = when(coin) {
        Coin.TRON, Coin.TEZOS, Coin.ALGORAND, Coin.POLKADOT -> false
        else -> true
    }
}
class Rewards(value: BigInteger) : Balance(value = value)

fun List<Balance>.total(coin: Coin) = fold(BigInteger.ZERO) { acc, i ->
    acc + if (i.includeToTotal(coin)) i.value else BigInteger.ZERO
}

fun Array<Balance>.total(coin: Coin) = fold(BigInteger.ZERO) {
        acc, i -> acc + if (i.includeToTotal(coin)) i.value else BigInteger.ZERO
}