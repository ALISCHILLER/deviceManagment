package com.msa.devicemanagementwithwi_fi.ui.screen.setting.component

import com.msa.devicemanagementwithwi_fi.R

data class ItemsContentModel(
    val textValue: String,
    val lottieIcon: Int
)


object ItemsContentList {
    var myItems = listOf<ItemsContentModel>(

        ItemsContentModel(
            "شارژ باطری:",
            R.raw.battrey
        ),
        ItemsContentModel(
            "دما:",
            R.raw.temperature
        ),
        ItemsContentModel(
            "رطوبت:",
            R.raw.humidity
        ),
        ItemsContentModel(
            "آمونیاک:",
            R.raw.chemistry
        )
    )
}