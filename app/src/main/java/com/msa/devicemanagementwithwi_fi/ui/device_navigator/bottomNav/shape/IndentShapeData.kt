package com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.shape

import com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.animation.indendshape.ShapeCornerRadius
import com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.animation.indendshape.shapeCornerRadius


data class IndentShapeData(
    val xIndent: Float = 0f,
    val height: Float = 0f,
    val width: Float = 0f,
    val cornerRadius: ShapeCornerRadius = shapeCornerRadius(0f),
    val ballOffset: Float = 0f,
)