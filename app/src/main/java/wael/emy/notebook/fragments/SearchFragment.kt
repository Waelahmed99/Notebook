package wael.emy.notebook.fragments

import wael.emy.notebook.DbHelper
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_search.*
import wael.emy.notebook.R
import wael.emy.notebook.models.BookItem

class SearchFragment: Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var items:ArrayList<BookItem>
    private lateinit var typesViews:ArrayList<TextView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        database = FirebaseDatabase.getInstance().reference
        items = ArrayList()

        searchRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val dbLoader = DbHelper(context)
        search_view.addTextChangedListener { object:TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    dbLoader.searchForBook(searchRecycler, s.toString())
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    dbLoader.searchForBook(searchRecycler, s.toString())
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    dbLoader.searchForBook(searchRecycler, s.toString())
                }
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}