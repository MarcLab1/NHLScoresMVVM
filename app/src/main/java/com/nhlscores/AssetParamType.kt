package com.nhlscores

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.nhlscores.network.dto.TestItem

//Not using this right now but I may later
class AssetParamType : NavType<TestItem>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): TestItem? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): TestItem {
        return Gson().fromJson(value, TestItem::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: TestItem) {
        bundle.putParcelable(key, value)
    }
}