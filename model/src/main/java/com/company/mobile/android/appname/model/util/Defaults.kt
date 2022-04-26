package com.company.mobile.android.appname.model.util

const val DEFAULT_INT = Int.MIN_VALUE
const val DEFAULT_LONG = Long.MIN_VALUE
const val DEFAULT_DOUBLE = -10000.1
const val DEFAULT_STRING = ""
const val DEFAULT_FORM = "N/A"

fun Int?.orDefault(): Int = this ?: DEFAULT_INT

fun Long?.orDefault(): Long = this ?: DEFAULT_LONG

fun Double?.orDefault(): Double = this ?: DEFAULT_DOUBLE

fun Boolean?.orFalse(): Boolean = this ?: false

fun Long.orNull(): Long? {
    return if (this == DEFAULT_LONG) {
        null
    } else this
}

fun Double?.zeroIfDefault(): Double {
    this?.let {
        if (this != DEFAULT_DOUBLE) {
            return this
        }
    }

    return 0.0
}

fun Int?.zeroIfDefault(): Int {
    this?.let {
        if (this != DEFAULT_INT) {
            return this
        }
    }

    return 0
}

fun Long?.zeroIfDefault(): Long {
    this?.let {
        if (this != DEFAULT_LONG) {
            return this
        }
    }

    return 0
}

fun Int.orNull(): Int? {
    return if (this == DEFAULT_INT) {
        null
    } else this
}

fun Double.orNull(): Double? {
    return if (this == DEFAULT_DOUBLE) {
        null
    } else this
}

fun String.orNull(): String? {
    return if (this == DEFAULT_STRING) {
        null
    } else this
}

fun String.isDefault(): String? {
    return if (this == DEFAULT_STRING) {
        null
    } else this
}

fun String.orPorcentaje(): String {
    return if (this.isEmpty()) {
        "%"
    } else "%$this%"
}

fun String.orPorcentajeM(): String {
    return if (this.isEmpty()) {
        "%"
    } else this
}