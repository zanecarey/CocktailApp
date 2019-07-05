package zane.carey.cocktailapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import retrofit2.await
import retrofit2.awaitResponse


lateinit var nametextView: TextView
lateinit var detailsTextView: TextView
private var myJob: Job? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn = findViewById(R.id.find_cocktail_cardview) as CardView
        val browseBtn = findViewById(R.id.browse_cardview) as CardView
        val randBtn = findViewById(R.id.random_cardview) as CardView
        val ingrBtn = findViewById(R.id.ingredient_cardview) as CardView


        //SEARCH ON CLICK
        searchBtn.setOnClickListener {
            //launch alert dialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Enter Drink")

            val editText = EditText(this)

            builder.setView(editText)

            builder.setPositiveButton("Ok") { dialog, which ->

                val drink = editText.text.toString()
                //launch display activity
                val intent = Intent(this, DrinkDisplayActivity::class.java)
                intent.putExtra("drinkName", drink)
                startActivity(intent)

            }

            val dialog = builder.create()
            dialog.show()

        }

        //BROWSE ON CLICK
        browseBtn.setOnClickListener {
            //launch classics activity
            val intent = Intent(this, ClassicsActivity::class.java)
            startActivity(intent)
        }

        //RANDOM ONCLICK
        randBtn.setOnClickListener {

            //get random cocktail
            val intent = Intent(this, DrinkDisplayActivity::class.java)
            intent.putExtra("drinkName", "randomDrink")
            startActivity(intent)
        }

        //INGREDIENT ONCLICK
        ingrBtn.setOnClickListener {
            //launch alert dialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Enter Ingredient")

            val editText = EditText(this)

            builder.setView(editText)

            builder.setPositiveButton("Ok") { dialog, which ->

                val ingredient = editText.text.toString()
                //launch display activity
                val intent = Intent(this, IngredientFilterDisplay::class.java)
                intent.putExtra("ingredient", ingredient)
                startActivity(intent)
            }
            val dialog = builder.create()
            dialog.show()
        }
    }
}


