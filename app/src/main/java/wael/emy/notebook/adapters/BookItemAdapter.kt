package wael.emy.notebook.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_item_model.view.*
import kotlinx.android.synthetic.main.book_search_model.view.*
import wael.emy.notebook.R
import wael.emy.notebook.models.BookItem


class BookItemAdapter(private val items: List<BookItem>) : RecyclerView.Adapter<PlaceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.book_item_model, parent, false)
        return PlaceHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.name.text = items[position].name
        holder.writerID.text = items[position].writerID
        Picasso.get().load(items[position].image).into(holder.image)
    }
}


class PlaceHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.book_name
    var image: ImageView = view.book_image
    var writerID: TextView = view.item_book_writer
}