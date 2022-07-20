package keep.core.ui

import com.ionspin.kotlin.bignum.decimal.BigDecimal

interface ConversionValueFormatter {
    fun format(decimals: Int, value: BigDecimal): String
    fun format(decimals: Int, value: Double): String

    fun format(decimals: Int, conversionPrice: Double, cryptoValue: BigDecimal): String
    fun format(decimals: Int, conversionPrice: String, cryptoValue: BigDecimal): String
}