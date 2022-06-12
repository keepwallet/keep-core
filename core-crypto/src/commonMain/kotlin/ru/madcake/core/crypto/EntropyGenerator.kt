package ru.madcake.core.crypto

internal interface EntropyGenerator {
    fun generate(): ByteArray?
}