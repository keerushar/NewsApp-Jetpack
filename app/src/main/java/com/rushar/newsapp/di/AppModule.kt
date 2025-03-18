package com.rushar.newsapp.di

import android.app.Application
import android.app.LocaleManager
import com.rushar.newsapp.data.manager.LocalUserManagerImpl
import com.rushar.newsapp.domain.manager.LocalUserManager
import com.rushar.newsapp.domain.usecases.AppEntryUseCases
import com.rushar.newsapp.domain.usecases.ReadAppEntry
import com.rushar.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}