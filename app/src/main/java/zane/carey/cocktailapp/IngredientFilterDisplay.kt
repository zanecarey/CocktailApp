package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.coroutines.*


lateinit var ingredient: String
private lateinit var filterRecyclerView: RecyclerView
private lateinit var filterAdapter: DrinkAdapter
private var filterDrinks = ArrayList<Drink>()

class IngredientFilterDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_filter_display)

        filterRecyclerView = findViewById(R.id.filterRecyclerView)

        ingredient = getIngredient()

        getDrinks(ingredient)
    }


    fun getIngredient(): String {
        if (getIntent().hasExtra("ingredient")) {
            return getIntent().getStringExtra("ingredient")
        } else return ""
    }

    fun getDrinks(ingredient: String) = runBlocking<Unit> {

        val job = CoroutineScope(Dispatchers.IO).launch {

            val request = api.getIngredientResults(ingredient).await()

            for(i in 0..request.drinks!!.size-1){
                filterDrinks.add(Drink(request.drinks[i].strDrink, replace(request.drinks[i].strDrinkThumb)))
            }
            withContext(Dispatchers.Main) {
                initializeRecyclerView()
            }
        }
    }

    fun initializeRecyclerView(){
        filterAdapter = DrinkAdapter(filterDrinks, this)
        filterRecyclerView.adapter = filterAdapter
        filterRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun replace(drink: String) : String{
        return drink.replace("\\", "")
    }

    override fun onBackPressed() {
        filterDrinks.clear()
        filterAdapter.notifyDataSetChanged()
        super.onBackPressed()
    }
}

