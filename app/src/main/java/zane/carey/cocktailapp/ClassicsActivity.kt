package zane.carey.cocktailapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_classics.*


private lateinit var linearLayoutManager : LinearLayoutManager
private lateinit var recyclerView: RecyclerView
private lateinit var recyclerViewNonAlcohol: RecyclerView
private lateinit var adapter: DrinkAdapter
private lateinit var adapterNonAlcohol: DrinkAdapter
private var drinks = ArrayList<Drink>()
private var nonAlcoholicDrinks = ArrayList<Drink>()


class ClassicsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classics)

        recyclerView = findViewById(R.id.classicsRecyclerView) as RecyclerView
        recyclerViewNonAlcohol = findViewById(R.id.nonAlcoholicRecyclerView) as RecyclerView

        //alcoholic
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

        //non-alcoholic
        nonAlcoholicDrinks.add(Drink("Afterglow", "https://www.thecocktaildb.com/images/media/drink/vuquyv1468876052.jpg"))
        nonAlcoholicDrinks.add(Drink("Aloha Fruit Punch", "https://www.thecocktaildb.com/images/media/drink/wsyvrt1468876267.jpg"))
        nonAlcoholicDrinks.add(Drink("Castillian Hot Chocolate", "https://www.thecocktaildb.com/images/media/drink/3nbu4a1487603196.jpg"))
        nonAlcoholicDrinks.add(Drink("Egg Cream", "https://www.thecocktaildb.com/images/media/drink/mvis731484430445.jpg"))
        nonAlcoholicDrinks.add(Drink("Frappé", "https://www.thecocktaildb.com/images/media/drink/vqwryq1441245927.jpg"))
        nonAlcoholicDrinks.add(Drink("Limeade", "https://www.thecocktaildb.com/images/media/drink/5jdp5r1487603680.jpg"))
        nonAlcoholicDrinks.add(Drink("Mango Orange Smoothie", "https://www.thecocktaildb.com/images/media/drink/vdp2do1487603520.jpg"))
        nonAlcoholicDrinks.add(Drink("Rail Splitter", "https://www.thecocktaildb.com/images/media/drink/stsuqq1441207660.jpg"))
        nonAlcoholicDrinks.add(Drink("Thai Coffee", "https://www.thecocktaildb.com/images/media/drink/wquwxs1441247025.jpg"))
        nonAlcoholicDrinks.add(Drink("Tomato Tang", "https://www.thecocktaildb.com/images/media/drink/869qr81487603278.jpg"))





        adapter = DrinkAdapter(drinks, this)
        adapterNonAlcohol = DrinkAdapter(nonAlcoholicDrinks, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        nonAlcoholicRecyclerView.adapter = adapterNonAlcohol
        nonAlcoholicRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun replace(drink: String) : String{
        return drink.replace("\\", "")
    }
}
