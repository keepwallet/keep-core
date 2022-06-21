package keep.core.model

data class Result<T>(val data: T, val error: KeepError)