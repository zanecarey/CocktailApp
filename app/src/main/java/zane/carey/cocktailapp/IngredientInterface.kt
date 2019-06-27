package zane.carey.cocktailapp

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IngredientInterface {
    @Headers("Content-Type: application/json")
    @GET("/api/json/v1/1/search.php")
    fun getData(@Query("i")ingredient: String): Deferred<IngrResults>
}

data class IngrResults(
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>
)

data class Ingredient(
    @SerializedName("idIngredient")
    val idIngredient: Int,
    @SerializedName("strIngredient")
    val strIngredient: String,
    @SerializedName("strDescription")
    val strDescription: String
)