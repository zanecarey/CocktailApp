package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.view.View
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
lateinit var ingr4CardView: CardView
lateinit var ingr5CardView: CardView
lateinit var ingr6CardView: CardView
lateinit var ingr7CardView: CardView
lateinit var ingr8CardView: CardView
lateinit var ingr9CardView: CardView
lateinit var ingr10CardView: CardView
lateinit var ingr11CardView: CardView
lateinit var ingr12CardView: CardView
lateinit var ingr13CardView: CardView
lateinit var ingr14CardView: CardView
lateinit var ingr15CardView: CardView
var ingredient1: String? = ""
var ingredient2: String? = ""
var ingredient3: String? = ""
var ingredient4: String? = ""
var ingredient5: String? = ""
var ingredient6: String? = ""
var ingredient7: String? = ""
var ingredient8: String? = ""
var ingredient9: String? = ""
var ingredient10: String? = ""
var ingredient11: String? = ""
var ingredient12: String? = ""
var ingredient13: String? = ""
var ingredient14: String? = ""
var ingredient15: String? = ""
var measure1: String? = ""
var measure2: String? = ""
var measure3: String? = ""
var measure4: String? = ""
var measure5: String? = ""
var measure6:  String? = ""
var measure7: String? = ""
var measure8: String? = ""
var measure9: String? = ""
var measure10: String? = ""
var measure11: String? = ""
var measure12: String? = ""
var measure13: String? = ""
var measure14: String? = ""
var measure15: String? = ""

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
        ingr4CardView = findViewById(R.id.ing4CardView)
        ingr5CardView = findViewById(R.id.ing5CardView)
        ingr6CardView = findViewById(R.id.ing6CardView)
        ingr7CardView = findViewById(R.id.ing7CardView)
        ingr8CardView = findViewById(R.id.ing8CardView)
        ingr9CardView = findViewById(R.id.ing9CardView)
        ingr10CardView = findViewById(R.id.ing10CardView)
        ingr11CardView = findViewById(R.id.ing11CardView)
        ingr12CardView = findViewById(R.id.ing12CardView)
        ingr13CardView = findViewById(R.id.ing13CardView)
        ingr14CardView = findViewById(R.id.ing14CardView)
        ingr15CardView = findViewById(R.id.ing15CardView)

        drink = getDrink()

        retreiveInfo(drink)

    }

    fun getDrink(): String {
        if (getIntent().hasExtra("drinkName")) {
            return getIntent().getStringExtra("drinkName")
        } else return ""
    }

    fun retreiveInfo(drink : String) = runBlocking<Unit>{

        val job = CoroutineScope(Dispatchers.IO).launch {
            val request : Results
            if(drink == "randomDrink"){
                request = api.getRandom().await()
            }
            else {
               request = api.getDrinks(drink).await()
            }
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

                if(ingredient1 == ""){
                    ingr1CardView.visibility = View.GONE
                }
                if(ingredient2 == ""){
                    ingr2CardView.visibility = View.GONE
                }
                if(ingredient3 == ""){
                    ingr3CardView.visibility = View.GONE
                }
                if(ingredient4 == ""){
                    ingr4CardView.visibility = View.GONE
                }
                if(ingredient5 == ""){
                    ingr5CardView.visibility = View.GONE
                }
                if(ingredient6 == ""){
                    ingr6CardView.visibility = View.GONE
                }
                if(ingredient7 == ""){
                    ingr7CardView.visibility = View.GONE
                }
                if(ingredient8 == "" || ingredient8 == null){
                    ingr8CardView.visibility = View.GONE
                }
                if(ingredient9 == "" || ingredient9 == null){
                    ingr9CardView.visibility = View.GONE
                }
                if(ingredient10 == ""|| ingredient10 == null){
                    ingr10CardView.visibility = View.GONE
                }
                if(ingredient11 == "" || ingredient11 == null){
                    ingr11CardView.visibility = View.GONE
                }
                if(ingredient12 == "" || ingredient12 == null){
                    ingr12CardView.visibility = View.GONE
                }
                if(ingredient13 == "" || ingredient13 == null){
                    ingr13CardView.visibility = View.GONE
                }
                if(ingredient14 == "" || ingredient14 == null){
                    ingr14CardView.visibility = View.GONE
                }
                if(ingredient15 == "" || ingredient15 == null){
                    ingr15CardView.visibility = View.GONE
                }

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
        }
    }
}
