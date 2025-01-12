package com.vokrob.wampserverapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainApi: MainApi) : ViewModel() {
    val userList = mutableStateOf(emptyList<User>())

    init {
        viewModelScope.launch {
            userList.value = mainApi.getAllUsers()
        }
    }

    fun saveUser(user: User) = viewModelScope.launch {
        mainApi.saveUser(user)
        userList.value = mainApi.getAllUsers()
    }
}

























