package com.mp.cleanmovie.data.di


import com.mp.cleanmovie.data.repository.home.HomeRepository
import com.mp.cleanmovie.data.repository.home.HomeRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface  DataModule {
  @Binds fun bindHomeRepository(homeRepositoryImp: HomeRepositoryImp): HomeRepository


}
