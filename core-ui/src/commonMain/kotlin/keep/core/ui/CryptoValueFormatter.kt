package keep.core.ui

import com.ionspin.kotlin.bignum.decimal.BigDecimal

interface CryptoValueFormatter {
    fun format(decimals: Int, value: BigDecimal): String
}