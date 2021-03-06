package zane.carey.cocktailapp

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_listitem.view.*

class DrinkAdapter(val drinks: ArrayList<Drink>, val context: Context) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_listitem, p0, false))
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.drinkName.text = drinks[p1].drink
        Glide.with(context)
            .asBitmap()
            .load(drinks[p1].drinkPic)
            .into(p0.drinkPicture)
        p0.cardView.setOnClickListener{
            val intent = Intent(context, DrinkDisplayActivity::class.java)
            intent.putExtra("drinkName", drinks[p1].drink)
            context.startActivity(intent)
        }


    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val drinkName = view.drinkName
        val drinkPicture = view.drinkPic
        val cardView = view.cardView
    }
}

