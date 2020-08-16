package com.example.template.di

import com.example.template.data.DataSource
import com.example.template.data.remote.RemoteDataSourceImpl
import com.example.template.domain.Repo
import com.example.template.domain.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindRepoImpl(repoImpl: RepoImpl): Repo

    @Binds
    abstract fun bindRemoteDatasourceImpl(remoteDataSourceImpl: RemoteDataSourceImpl): DataSource

}