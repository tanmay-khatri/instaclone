package com.example.instaclone.domain.use_cases

data class AuthUseCase(
    val isUserAuthenticated: IsUserAuthenticated,
    val firebaseAuthState: FirebaseAuthState,
    val firebaseSignIn: FirebaseSignIn,
    val firebaseSignUp: FirebaseSignUp,
    val firebaseSignOut: FirebaseSignOut
) {
}