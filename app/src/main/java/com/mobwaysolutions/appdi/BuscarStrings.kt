package com.mobwaysolutions.appdi

import android.content.Context

class BuscarStrings(private val context: Context) {

    fun getStringLoading() : String {
        return context.getString(R.string.loading)
    }

    fun getStringSave() : String {
        return context.getString(R.string.save)
    }

}