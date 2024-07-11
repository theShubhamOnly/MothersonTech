package com.example.mothersontech.ServerCall

import com.example.mothersontech.dataModel.NewCallRepoImplementation
import com.example.mothersontech.Repositary.NetworkCallRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract  fun provideRepo(repo: NewCallRepoImplementation): NetworkCallRepo
}