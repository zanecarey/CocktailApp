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

        recyclerView = findViewById(R.id.classicsRecyclerView) as RecyclerView

        drinks.add(Drink("Margarita", "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg"))
        drinks.add(Drink("Manhattan", "https://www.thecocktaildb.com//images//media//drink//ec2jtz1504350429.jpg"))
        drinks.add(Drink("Old Fashioned", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/vrwquq1478252802.jpg")))
        drinks.add(Drink("Daiquiri", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/usuuur1439906797.jpg")))
        drinks.add(Drink("Mojito", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/rxtqps1478251029.jpg")))
        drinks.add(Drink("Negroni", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/tutwwv1439907127.jpg")))
        drinks.add(Drink("Moscow Mule", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/3pylqc1504370988.jpg")))
        drinks.add(Drink("Martini", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/71t8581504353095.jpg")))
        drinks.add(Drink("Mai Tai", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/twyrrp1439907470.jpg")))
        drinks.add(Drink("Sidecar", replace("https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/stwxuq1439906852.jpg")))
        adapter = DrinkAdapter(drinks, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun replace(drink: String) : String{
        return drink.replace("\\", "")
    }
}
