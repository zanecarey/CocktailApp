package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import retrofit2.await
import retrofit2.awaitResponse

val api = RestApi()
lateinit var textView: TextView
private var myJob: Job? = null
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn = findViewById(R.id.find_cocktail_btn) as Button
        textView = findViewById(R.id.name_textview) as TextView

        searchBtn.setOnClickListener {

            myJob = CoroutineScope(Dispatchers.IO).launch {
                val request = api.getDrinks("margarita").await()
                val drink = request.drinks?.get(0)
                withContext(Dispatchers.Main) {
                    //do something with result
                    textView.text = drink.strDrink
                }
            }
        }
    }
}


