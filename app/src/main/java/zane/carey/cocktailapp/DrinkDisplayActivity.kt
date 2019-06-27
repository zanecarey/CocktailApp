package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import org.w3c.dom.Text

lateinit var drink: String
lateinit var descriptionTextView: TextView
lateinit var drinkImage: ImageView
lateinit var drinkNameTextView: TextView
lateinit var ing1: TextView
lateinit var ing2: TextView
lateinit var ing3: TextView
lateinit var ingr1CardView: CardView
lateinit var ingr2CardView: CardView
lateinit var ingr3CardView: CardView
var ingredient1 = ""
var ingredient2 = ""
var ingredient3 = ""
var ingr1Description = ""
var ingr2Description = ""
var ingr3Description = ""

val api = RestApi()

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

        ingr1CardView = findViewById(R.id.ing1CardView)
        ingr2CardView = findViewById(R.id.ing2CardView)
        ingr3CardView = findViewById(R.id.ing3CardView)

        drink = getDrink()
        retreiveInfo(drink)

        ingr1CardView.setOnClickListener {


            //alert dialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle(ingredient1)

            val textView = TextView(this)
            textView.text = ingr1Description
            builder.setView(textView)

            builder.setPositiveButton("Ok") { dialog, which ->

            }
            val dialog = builder.create()
            dialog.show()
        }


    }

    fun getDrink(): String {
        if (getIntent().hasExtra("drinkName")) {
            return getIntent().getStringExtra("drinkName")
        } else return ""
    }

    fun retreiveInfo(drink : String) = runBlocking<Unit>{

        val job = CoroutineScope(Dispatchers.IO).launch {
            val request = api.getDrinks(drink).await()
            val response = request.drinks?.get(0)
            withContext(Dispatchers.Main) {
                //do something with result
                descriptionTextView.text = response.strInstructions
                ingredient1 = response.strIngredient1
                ingredient2 = response.strIngredient2
                ingredient3 = response.strIngredient3

                Glide.with(this@DrinkDisplayActivity)
                    .asBitmap()
                    .load(response.strDrinkThumb)
                    .into(drinkImage)

                drinkNameTextView.text = response.strDrink
                //ing1.text = ingredient1
                ing1.text = ingredient1
                ing2.text = ingredient2
                ing3.text = ingredient3
            }
        }.invokeOnCompletion {
            val jobIng1 = CoroutineScope(Dispatchers.IO).launch {
                val request = api.getIngredient(ingredient1).await()
                val response = request.ingredients?.get(0)
                withContext(Dispatchers.Main){

                    ingr1Description = response.strDescription

                }
            }

//            val jobIng2 = CoroutineScope(Dispatchers.IO).launch {
//                val request = api.getIngredient(ingredient2).await()
//                val response = request.ingredients?.get(0)
//                withContext(Dispatchers.Main){
//
//                    ingr2Description = response.strDescription
//
//                }
//            }
//
//            val jobIng3 = CoroutineScope(Dispatchers.IO).launch {
//                val request = api.getIngredient(ingredient3).await()
//                val response = request.ingredients?.get(0)
//                withContext(Dispatchers.Main){
//
//                    ingr3Description = response.strDescription
//
//                }
//            }
        }





    }
}
