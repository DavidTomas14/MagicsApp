package com.company.mobile.android.appname.app.common.errorhandling

enum class AppAction constructor(val code: Long) {
    UNKNOWN(-1L),
    GET_CARDS(4L);

    override fun toString(): String {
        return java.lang.Long.toString(this.code)
    }

    companion object {

        fun fromCode(code: Long): AppAction {
            var result = UNKNOWN

            val retryActions = values()
            var i = 0
            while (i < retryActions.size && result == UNKNOWN) {
                val retryAction = retryActions[i]
                if (retryAction.code == code) {
                    result = retryAction
                }
                ++i
            }

            return result
        }
    }
}
