package com.mobwaysolutions.appdi

sealed class MainInteractions {

    object Loading : MainInteractions()
    data class Error(val message: String?, val e: Exception?) : MainInteractions()
    object Success : MainInteractions()

}
