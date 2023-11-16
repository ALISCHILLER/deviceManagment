package com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.utils

fun lerp(start: Float, stop: Float, fraction: Float) =
    (start * (1 - fraction) + stop * fraction)