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
                //retrieve info

//                myJob = CoroutineScope(Dispatchers.IO).launch {
//                    val request = api.getDrinks(drink).await()
//                    val response = request.drinks?.get(0)
//                    withContext(Dispatchers.Main) {
//                        //do something with result
//                        nametextView.text = response.strDrink
//                        detailsTextView.text = response.strInstructions
//                    }
//                }
            }

            val dialog = builder.create()
            dialog.show()

        }

        browseBtn.setOnClickListener{
            //launch classics activity
            val intent = Intent(this, ClassicsActivity::class.java)
            startActivity(intent)
        }
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}


