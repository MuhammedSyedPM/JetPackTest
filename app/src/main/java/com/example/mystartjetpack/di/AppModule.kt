package com.example.mystartjetpack.di
import android.content.Context
import androidx.room.Room
import com.example.mystartjetpack.api.MsApi
import com.example.mystartjetpack.db.DataDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): MsApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rfidwmsapi.technowavegroup.com/api/")
            .client(okHttpClient)
            .build()
            .create(MsApi::class.java)

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            // Uncomment the following line if you want to add an interceptor
            // .addInterceptor(interceptor)
            // .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()



    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        DataDatabase::class.java,
        "Database"
    )
        .build()
    //.addMigrations(MIGRATION_3_4, MIGRATION_4_5)


    @Singleton
    @Provides
    fun provideYourDao(db: DataDatabase) = db.getDataDao()
}
