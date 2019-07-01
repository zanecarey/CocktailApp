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
lateinit var instructionsTextView: TextView
lateinit var drinkImage: ImageView
lateinit var drinkNameTextView: TextView
lateinit var ing1: TextView
lateinit var ing2: TextView
lateinit var ing3: TextView
lateinit var ing4: TextView
lateinit var ing5: TextView
lateinit var ing6: TextView
lateinit var ing7: TextView
lateinit var ing8: TextView
lateinit var ing9: TextView
lateinit var ing10: TextView
lateinit var ing11: TextView
lateinit var ing12: TextView
lateinit var ing13: TextView
lateinit var ing14: TextView
lateinit var ing15: TextView
lateinit var ingr1CardView: CardView
lateinit var ingr2CardView: CardView
lateinit var ingr3CardView: CardView
var ingredient1 = ""
var ingredient2 = ""
var ingredient3 = ""
var ingredient4 = ""
var ingredient5 = ""
var ingredient6 = ""
var ingredient7 = ""
var ingredient8 = ""
var ingredient9 = ""
var ingredient10 = ""
var ingredient11 = ""
var ingredient12 = ""
var ingredient13 = ""
var ingredient14 = ""
var ingredient15 = ""
var ingr1Description = ""
var ingr2Description = ""
var ingr3Description = ""
var ingr4Description = ""
var ingr5Description = ""
var ingr6Description = ""
var ingr7Description = ""
var ingr8Description = ""
var ingr9Description = ""
var ingr10Description = ""
var ingr11Description = ""
var ingr12Description = ""
var ingr13Description = ""
var ingr14Description = ""
var ingr15Description = ""
var measure1 = ""
var measure2 = ""
var measure3 = ""
var measure4 = ""
var measure5 = ""
var measure6 = ""
var measure7 = ""
var measure8 = ""
var measure9 = ""
var measure10 = ""
var measure11 = ""
var measure12 = ""
var measure13 = ""
var measure14 = ""
var measure15 = ""

val api = RestApi()

class DrinkDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_display)

        instructionsTextView = findViewById(R.id.instructions)
        drinkImage = findViewById(R.id.drinkImage)
        drinkNameTextView = findViewById(R.id.drinkName_textView)

        ing1 = findViewById(R.id.ingredient1)
        ing2 = findViewById(R.id.ingredient2)
        ing3 = findViewById(R.id.ingredient3)
        ing4 = findViewById(R.id.ingredient4)
        ing5 = findViewById(R.id.ingredient5)
        ing6 = findViewById(R.id.ingredient6)
        ing7 = findViewById(R.id.ingredient7)
        ing8 = findViewById(R.id.ingredient8)
        ing9 = findViewById(R.id.ingredient9)
        ing10 = findViewById(R.id.ingredient10)
        ing11 = findViewById(R.id.ingredient11)
        ing12 = findViewById(R.id.ingredient12)
        ing13 = findViewById(R.id.ingredient13)
        ing14 = findViewById(R.id.ingredient14)
        ing15 = findViewById(R.id.ingredient15)

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
                instructionsTextView.text = response.strInstructions
                ingredient1 = response.strIngredient1
                ingredient2 = response.strIngredient2
                ingredient3 = response.strIngredient3
                ingredient4 = response.strIngredient4
                ingredient5 = response.strIngredient5
                ingredient6 = response.strIngredient6
                ingredient7 = response.strIngredient7
                ingredient8 = response.strIngredient8
                ingredient9 = response.strIngredient9
                ingredient10 = response.strIngredient10
                ingredient11 = response.strIngredient11
                ingredient12 = response.strIngredient12
                ingredient13 = response.strIngredient13
                ingredient14 = response.strIngredient14
                ingredient15 = response.strIngredient15
                measure1 = response.strMeasure1
                measure2 = response.strMeasure2
                measure3 = response.strMeasure3
                measure4 = response.strMeasure4
                measure5 = response.strMeasure5
                measure6 = response.strMeasure6
                measure7 = response.strMeasure7
                measure8 = response.strMeasure8
                measure9 = response.strMeasure9
                measure10 = response.strMeasure10
                measure11 = response.strMeasure11
                measure12 = response.strMeasure12
                measure13 = response.strMeasure13
                measure14 = response.strMeasure14
                measure15 = response.strMeasure15

                Glide.with(this@DrinkDisplayActivity)
                    .asBitmap()
                    .load(response.strDrinkThumb)
                    .into(drinkImage)

                drinkNameTextView.text = response.strDrink
                //ing1.text = ingredient1
                ing1.text = ingredient1 + " - " + measure1
                ing2.text = ingredient2 + " - " + measure2
                ing3.text = ingredient3 + " - " + measure3
                ing4.text = ingredient4 + " - " + measure4
                ing5.text = ingredient5 + " - " + measure5
                ing6.text = ingredient6 + " - " + measure6
                ing7.text = ingredient7 + " - " + measure7
                ing8.text = ingredient8 + " - " + measure8
                ing9.text = ingredient9 + " - " + measure9
                ing10.text = ingredient10 + " - " + measure10
                ing11.text = ingredient11 + " - " + measure11
                ing12.text = ingredient12 + " - " + measure12
                ing13.text = ingredient13 + " - " + measure13
                ing14.text = ingredient14 + " - " + measure14
                ing15.text = ingredient15 + " - " + measure15
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
