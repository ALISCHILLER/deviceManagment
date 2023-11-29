package com.msa.devicemanagementwithwi_fi.di

import com.msa.devicemanagementwithwi_fi.data.repository.SocketRepositoryIml
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSocketRepository(socketRepositoryIml: SocketRepositoryIml)
}