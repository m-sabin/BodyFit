package com.example.bodyfit.feature.home.ui

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val workouts: List<String>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
    }