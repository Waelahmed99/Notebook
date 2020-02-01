package wael.emy.notebook.fragments

import wael.emy.notebook.DbHelper
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import wael.emy.notebook.R

class HomeFragment: Fragment() {

    private lateinit var typesViews:List<TextView>
    private var booksType = BooksType.ALL
    private lateinit var dbHelper:DbHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        typesViews = listOf<TextView>(all_type, culture_type, fiction_type, philosophy_type)
        dbHelper = DbHelper(context)

        for (i in typesViews.indices) {
            typesViews[i].setOnClickListener {
                setActiveType(i)
                when (typesViews[i].text) {
                    context!!.getString(R.string.all) -> booksType = BooksType.ALL
                    context!!.getString(R.string.culture) -> booksType = BooksType.CULTURE
                    context!!.getString(R.string.fiction) -> booksType = BooksType.FICTION
                    context!!.getString(R.string.philosophy) -> booksType = BooksType.PHILOSOPHY
                }
            }
        }

        setReversedLayout(bookItemRecycler)
        setReversedLayout(mostBuyingRecycler)
        dbHelper.loadBooksTypes(bookItemRecycler, 3)
        dbHelper.loadBooksTypes(mostBuyingRecycler, 2)

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setReversedLayout(view:RecyclerView) {
        view.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, true)
    }

    private fun setActiveType(id: Int) {
        for (i in typesViews.indices) {
            when (i) {
                id -> {
                    typesViews[i].setTextColor(Color.WHITE)
                    if (i != 0)
                        typesViews[i].setBackgroundResource(R.drawable.rounded_button)
                    else
                        typesViews[i].setBackgroundResource(R.drawable.rounded_layout)
                }
                else -> {
                    typesViews[i].setTextColor(Color.BLACK)
                    typesViews[i].setBackgroundResource(R.drawable.grey_shade)
                }
            }
        }
    }

    enum class BooksType {ALL, CULTURE, FICTION, PHILOSOPHY}
}