package com.example.bodyfit.feature.activity.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bodyfit.R
import java.time.LocalDate
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ActivityScreen() {

    Scaffold(

        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                ActivityHeader()
                WeeklySelector()
                WeeklyActivityGraph(
                    data = listOf(30, 50, 0, 70, 40, 20, 90), // exemplo
                    modifier = Modifier.fillMaxWidth()
                )
                StatCardSection()
                TodayPlanSection()
            }
        }
    )
}

@Composable
fun ActivityHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = "Suas Atividades",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.primary
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Date Icon"
            )
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications Icon"
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeeklySelector() {

    val today = LocalDate.now()
    val startOfWeek = today.minusDays(today.dayOfWeek.ordinal.toLong())
    val weekDays = (0..6).map { startOfWeek.plusDays(it.toLong()) }

    var selectedDate by remember { mutableStateOf(today) }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        weekDays.forEach { date ->
            val isSelected = date == selectedDate
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        else MaterialTheme.colorScheme.surface
                    )
                    .clickable { selectedDate = date }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = date.dayOfWeek.getDisplayName(
                        java.time.format.TextStyle.SHORT,
                        Locale.getDefault()
                    ).take(1),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSurface
                    )
                )
                Text(
                    text = date.dayOfMonth.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }
    }
}

@Composable
fun WeeklyActivityGraph(
    data: List<Int>,
    modifier: Modifier = Modifier
) {
    val maxValue = (data.maxOrNull() ?: 1).toFloat()

    Canvas(
        modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(160.dp)

    ) {
        val barWidth = size.width / (data.size * 2)
        data.forEachIndexed { index, value ->
            val barHeight = ((value / maxValue) * size.height).coerceAtLeast(4f)
            val x = index * (barWidth * 2) + barWidth / 2

            drawRoundRect(
                color = if (value > 0) Color(0xFFDAFF62) else Color.White,
                topLeft = Offset(x, size.height - barHeight),
                size = Size(barWidth, barHeight),
                cornerRadius = CornerRadius(8f, 8f)
            )


        }
    }
}

@Composable
fun StatCardSection(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatCard(
                title = "Calories",
                value = "788 kcal",
                icon = 0,
                color = Color(0xffdaff62),
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Duration",
                value = "1.26 hrs",
                icon = 0,
                color = Color(0xffffffff),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatCard(
                title = "Steps",
                value = "6666 steps",
                icon = 0,
                color = Color(0xfff0c7ff),
                modifier = Modifier.weight(1f)
            )
            StatCard(
                title = "Water",
                value = "6/8 cups",
                icon = 0,
                color = Color(0xffd9e6ec),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun StatCard(title: String, value: String, icon: Int, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier
            .height(80.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )


            Text(
                value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

        }
    }
}

@Composable
fun TodayPlanSection(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Text(
            text = "Treino de Hoje",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
        )
        TodayPlanItem()

    }
}

@Composable
fun TodayPlanItem(modifier: Modifier = Modifier) {

    Box(
        modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(16.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(8.dp)

    ) {
        Row(
            modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.img_women),
                contentDescription = "Image Today'Plan",
                modifier.clip(RoundedCornerShape(16))

                )

            Column(
                modifier
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Superior + Biceps",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Spacer(modifier.height(8.dp))

                Text(
                    text = "01:30 de treino - 2min entre exercícios",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black
                )
                Spacer(modifier.height(16.dp))

                LinearProgressIndicator(
                    progress = { 6f / 8f },
                    modifier = modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .clip(RoundedCornerShape(50)),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
                )
            }

        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ActivityScreenPreview() {
    ActivityScreen()
}