package zane.carey.cocktailapp

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RestApi{
    private val cocktailApi: CocktailApi
    private val randomApi: RandomApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        cocktailApi = retrofit.create(CocktailApi::class.java)
        randomApi = retrofit.create(RandomApi::class.java)
    }

    fun getDrinks(drink: String) : Deferred<Results>{
        return cocktailApi.getData(drink)
    }

    fun getRandom() : Deferred<Results>{
        return randomApi.getRandom()
    }

}
