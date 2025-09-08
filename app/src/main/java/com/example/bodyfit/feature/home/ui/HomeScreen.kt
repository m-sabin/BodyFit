package com.example.bodyfit.feature.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.bodyfit.core.navigation.BodyFitNavHost
import com.example.bodyfit.core.navigation.BottomNavbar
import com.example.bodyfit.feature.home.viewmodel.HomeViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
//    val state by homeViewModel.uiState.collectAsState()
//    when (state) {
//        is HomeUiState.Loading -> CircularProgressIndicator()
//        is HomeUiState.Success -> LazyColumn {
//            items((state as HomeUiState.Success).workouts) { workout ->
//                Text(workout)
//            }
//        }
//
//        is HomeUiState.Error -> Text("Erro: ${(state as HomeUiState.Error).message}")
//    }

    val navController = rememberNavController()

        Scaffold(
        bottomBar = { BottomNavbar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                BodyFitNavHost(navController)
            }
        }
    )
}