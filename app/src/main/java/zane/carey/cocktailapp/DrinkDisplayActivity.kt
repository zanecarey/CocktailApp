package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.*

lateinit var drink: String
private var myJob: Job? = null
lateinit var descriptionTextView: TextView
lateinit var drinkImage: ImageView
lateinit var drinkNameTextView: TextView
lateinit var ing1: TextView
lateinit var ing2: TextView
lateinit var ing3: TextView
class DrinkDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_display)

        descriptionTextView = findViewById(R.id.description)
        drinkImage = findViewById(R.id.drinkImage)
        drinkNameTextView = findViewById(R.id.drinkName_textView)
        ing1 = findViewById(R.id.ingredient1)
        ing2 = findViewById(R.id.ingredient2)
        ing3 = findViewById(R.id.ingredient3)

        drink = getDrink()
        retreiveInfo(drink)

    }

    fun getDrink(): String {
        if (getIntent().hasExtra("drinkName")) {
            return getIntent().getStringExtra("drinkName")
        } else return ""
    }

    fun retreiveInfo(drink : String) {

        myJob = CoroutineScope(Dispatchers.IO).launch {
            val request = api.getDrinks(drink).await()
            val response = request.drinks?.get(0)
            withContext(Dispatchers.Main) {
                //do something with result
                descriptionTextView.text = response.strInstructions

                Glide.with(this@DrinkDisplayActivity)
                    .asBitmap()
                    .load(response.strDrinkThumb)
                    .into(drinkImage)

                drinkNameTextView.text = response.strDrink
                ing1.text = response.strIngredient1
                ing2.text = response.strIngredient2
                ing3.text = response.strIngredient3
            }
        }
    }
}
