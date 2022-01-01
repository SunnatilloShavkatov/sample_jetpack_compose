
package com.example.sample.di

import com.example.sample.network.DisneyService
import com.example.sample.persistence.PosterDao
import com.example.sample.viewmodel.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

  @Provides
  @ViewModelScoped
  fun provideMainRepository(
    disneyService: DisneyService,
    posterDao: PosterDao
  ): MainRepository {
    return MainRepository(disneyService, posterDao)
  }
}
