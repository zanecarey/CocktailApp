package zane.carey.cocktailapp

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface CocktailApi {

    @Headers("Content-Type: application/json")
    @GET("/api/json/v1/1/search.php")
    fun getData(@Query("s") drink: String): Deferred<Results>
}

data class Results(
    @SerializedName("drinks")
    val drinks: List<Drinks>
)

data class Drinks(
    @SerializedName("idDrink")
    val idDrink: Int,
    @SerializedName("strDrink")
    val strDrink: String,
    @SerializedName("strGlass")
    val strGlass: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strIngredient1")
    val strIngredient1: String,
    @SerializedName("strIngredient2")
    val strIngredient2: String,
    @SerializedName("strIngredient3")
    val strIngredient3: String,
    @SerializedName("strIngredient4")
    val strIngredient4: String,
    @SerializedName("strInstructions")
    val strInstructions: String,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String
)