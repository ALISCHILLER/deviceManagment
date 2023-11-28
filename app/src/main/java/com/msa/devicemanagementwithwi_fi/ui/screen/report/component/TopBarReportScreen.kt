@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.msa.devicemanagementwithwi_fi.ui.screen.report.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.calendar.CalendarScreen
import com.msa.devicemanagementwithwi_fi.ui.theme.BlueDark
import com.msa.devicemanagementwithwi_fi.ui.theme.Bluelight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarReportScreen() {

    var hideDatePicker by remember {
        mutableStateOf(true)
    }
    var setDate by remember {
        mutableStateOf("دریافت اطلاعات")
    }
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("دما", "رظوبت", "آمونیاک")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                bottomEnd = 16.dp,
                topEnd = 0.dp,
                bottomStart = 16.dp
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                BlueDark.copy(alpha = 0.2f),
                                Bluelight.copy(alpha = 0.2f),
                            )
                        )
                    )
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .padding(top = 5.dp)
                        .clickable {
                            hideDatePicker = false
                        }
                    ,
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(5.dp),
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "date",
                        tint = Color.Red

                    )
                    Text(
                        modifier = Modifier
                            .padding(5.dp),
                        text = setDate,
                        color = Color.White,
                        fontFamily = FontFamily.Serif

                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .padding(top = 5.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        TextField(
                            value = selectedText,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = {
                                ExposedDropdownMenuDefaults
                                    .TrailingIcon(expanded = expanded)
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .background(Color.Transparent),
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            coffeeDrinks.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    },
                                    leadingIcon = {
                                        Icon(
                                            Icons.Outlined.AllInbox,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }

                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                BlueDark.copy(alpha = 0.2f),
                                Bluelight.copy(alpha = 0.2f),
                            )
                        )
                    )
            ) {

                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .padding(top = 5.dp),
                ) {
                    Button(onClick = {

                    }) {
                        Text(text = "دریافت اطلاعات")
                    }
                }
            }
        }
    }
    if (!hideDatePicker) {
        CalendarScreen(
            onDismiss = { hideDatePicker = true },
            onConfirm = { setDate = it }
        )
    }
}

@Preview
@Composable
fun TopBarReportScreenPreview() {
    TopBarReportScreen()
}