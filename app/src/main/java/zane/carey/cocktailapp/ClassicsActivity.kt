package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


private lateinit var linearLayoutManager : LinearLayoutManager
private lateinit var recyclerView: RecyclerView
private lateinit var adapter: DrinkAdapter
private var drinks = ArrayList<Drink>()


class ClassicsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classics)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.classicsRecyclerView) as RecyclerView

        drinks.add(Drink("Margarita", "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg"))
        adapter = DrinkAdapter(drinks, this)
        recyclerView.setAdapter(adapter)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
