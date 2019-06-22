package zane.carey.cocktailapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DrinkAdapter(val drinks: ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder> {

    //constructor
    fun DrinkAdapter()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_listitem, p0, false))
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

}