package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*

lateinit var drink: String
private var myJob: Job? = null
lateinit var descriptionTextView: TextView
class DrinkDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_display)

        descriptionTextView = findViewById(R.id.description)
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
            }
        }
    }
}
