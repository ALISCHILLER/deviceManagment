@file:OptIn(ExperimentalMaterial3Api::class)

package com.msa.devicemanagementwithwi_fi.ui.screen.report

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.yml.charts.common.utils.DataUtils
import com.msa.devicemanagementwithwi_fi.ui.screen.report.component.StraightLinechart
import com.msa.devicemanagementwithwi_fi.ui.screen.report.component.TopBarReportScreen

@Composable
fun ReportScreen() {
    Scaffold(
        topBar = {
            TopBarReportScreen()
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        Column (
            modifier = Modifier
                .padding(it)
        ){
            StraightLinechart(DataUtils.getLineChartData(50, maxRange = 200))
        }
    }
}

@Composable
@Preview
fun ReportScreenPreview() {
    ReportScreen()
}