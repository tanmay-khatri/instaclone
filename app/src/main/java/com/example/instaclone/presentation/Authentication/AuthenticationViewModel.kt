package com.example.instaclone.presentation.Authentication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import com.example.instaclone.InstagramClone
import com.example.instaclone.domain.use_cases.AuthUseCase
import com.example.instaclone.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    val isUserAuthenticated get() = authUseCase.isUserAuthenticated()

    private val _signInState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signInState: State<Response<Boolean>> = _signInState

    fun signIn(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            authUseCase.firebaseSignIn(
                email = password,
                password = password
            ).collect {
                _signInState.value = it
            }
        }
    }
}

