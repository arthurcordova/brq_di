package com.mobwaysolutions.appdi

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBuscarStrings(@ApplicationContext context: Context): BuscarStrings {
        return BuscarStrings(context)
    }

    @Provides
    fun providesMainRepository(@ApplicationContext context: Context): MainRepository {
        return MainRepository(BuscarStrings(context))
    }

    @Provides
    fun providesLista(): List<String> {
        return arrayListOf("Arthur", "Alan", "Catia", "Adriano", "Danielle", "Alexssander")
    }


}