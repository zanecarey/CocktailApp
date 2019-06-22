package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


private lateinit var linearLayoutManager : LinearLayoutManager
private lateinit var recyclerView: RecyclerView
private lateinit var adapter: DrinkAdapter
private lateinit var drinks: ArrayList<String>
private lateinit var drinkPics: ArrayList<String>

class ClassicsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classics)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.classicsRecyclerView) as RecyclerView

        drinks.add("Margarita")
        drinks.add("Old Fashioned")
        drinks.add("White Russian")
    }
}
