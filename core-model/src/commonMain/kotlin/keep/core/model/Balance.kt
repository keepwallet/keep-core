package keep.core.model

import com.ionspin.kotlin.bignum.integer.BigInteger

sealed class Balance(
    val value: BigInteger
) {
    open fun includeToTotal(chain: Chain): Boolean = true
}

class Available(value: BigInteger) : Balance(value)
class Pending(value: BigInteger) : Balance(value = value)
class Frozen(value: BigInteger) : Balance(value = value) {
    override fun includeToTotal(chain: Chain): Boolean = when(chain) {
        Chain.BNBBeaconChain -> true
        else -> false
    }
}

class Locked(value: BigInteger) : Balance(value = value) {
    override fun includeToTotal(chain: Chain): Boolean = true
}

class Staked(value: BigInteger) : Balance(value = value) {
    override fun includeToTotal(chain: Chain): Boolean = true
}

class Rewards(value: BigInteger) : Balance(value = value)

fun List<Balance>.total(chain: Chain) = fold(BigInteger.ZERO) { acc, i ->
    acc + if (i.includeToTotal(chain)) i.value else BigInteger.ZERO
}

fun Array<Balance>.total(chain: Chain) = fold(BigInteger.ZERO) {
        acc, i -> acc + if (i.includeToTotal(chain)) i.value else BigInteger.ZERO
}