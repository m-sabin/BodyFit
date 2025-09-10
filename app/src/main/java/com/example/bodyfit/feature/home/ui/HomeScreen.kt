package com.example.bodyfit.feature.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.bodyfit.core.navigation.BottomNavbar

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen() {
    

    Scaffold(

        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(8.dp)
            ) {
                HomeHeader()
                BestForYouSection()
                HomePopularSection()
            }
        }
    )
}

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile Icon",
            modifier = Modifier
                .weight(0.2f)
                .aspectRatio(1f)
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(0.6f)
        ) {

            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "Hello, Amy",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, top = 2.dp),
                text = "Gym lover",
                style = MaterialTheme.typography.bodySmall,

                )
        }

        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notification Icon",
            modifier = Modifier.size(24.dp)
        )
    }


}

@Composable
fun BestForYouSection(
    items: List<String> = listOf(
        "Yoga",
        "Cardio",
        "Strength",
        "Pilates",
        "Crossfit"
    )
) {
    Text(
        text = "Para Você",
        style = MaterialTheme.typography.headlineLarge.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items) { item ->
            WorkoutCard(item)
        }
    }
}

@Composable
fun WorkoutCard(title: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(150.dp, 200.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }
}

@Composable
fun HomePopularSection(
    itemsPopular: List<String> = listOf(
        "Treino HIIT 20min",
        "Força para iniciantes",
        "Alongamento matinal",
        "Cardio Intenso 30min",
        "Treino de Core para iniciantes",
        "Yoga Relaxante 15min"
    )
) {
    Text(
        text = "Populares",
        style = MaterialTheme.typography.headlineLarge.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
    )
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsPopular) { item ->
            PopularCard(item)
        }
    }
}


@Composable
fun PopularCard(title: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(200.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}