package com.example.instaclone.di

import com.example.instaclone.data.AuthenticationRepositoryImpl
import com.example.instaclone.domain.repository.AuthenticationRepository
import com.example.instaclone.domain.use_cases.AuthUseCase
import com.example.instaclone.domain.use_cases.FirebaseAuthState
import com.example.instaclone.domain.use_cases.FirebaseSignIn
import com.example.instaclone.domain.use_cases.FirebaseSignOut
import com.example.instaclone.domain.use_cases.FirebaseSignUp
import com.example.instaclone.domain.use_cases.IsUserAuthenticated
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InstagramModule {

    @Singleton
    @Provides
    fun provideFirebaseAuthentication(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @Singleton
    @Provides
    fun
            provideAuthenticationRepository(
        auth: FirebaseAuth, firestore: FirebaseFirestore
    ) = AuthenticationRepositoryImpl(auth = auth, firestore = firestore)


    @Singleton
    @Provides
    fun provideAuthenticationUseCases(repository: AuthenticationRepository) = AuthUseCase(
        isUserAuthenticated = IsUserAuthenticated(repository),
        firebaseAuthState = FirebaseAuthState(repository),
        firebaseSignIn = FirebaseSignIn(repository),
        firebaseSignOut = FirebaseSignOut(repository),
        firebaseSignUp = FirebaseSignUp(repository)
    )

}