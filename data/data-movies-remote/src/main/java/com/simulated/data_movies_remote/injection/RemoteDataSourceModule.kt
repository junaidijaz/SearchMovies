package com.simulated.data_movies_remote.injection

import com.simulated.data_movies_remote.networking.SearchMovieService
import com.simulated.data_movies_remote.source.RemoteMoviesSourceImp
import com.simulated.data_movies_repository.data_sources.remote.RemoteMoviesSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {


    @Binds
    abstract fun bindsRemoteMoviesSource(source: RemoteMoviesSourceImp): RemoteMoviesSource

    companion object {
        @Provides
        fun provideMoviesService(retrofit: Retrofit): SearchMovieService =
            retrofit.create(SearchMovieService::class.java)
    }

}