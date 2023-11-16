package com.msa.devicemanagementwithwi_fi.ui.device_navigator

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    object ReportScreen : Route(route = "reportScreen")
    object SettingScreen : Route(route = "settingScreen")
}