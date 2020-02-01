package wael.emy.notebook;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import wael.emy.notebook.adapters.BookItemAdapter;
import wael.emy.notebook.models.BookItem;

public class DbHelper {

    private Context _context;
    private DatabaseReference _database;
    private List<BookItem> _bookItems;
    private ProgressDialog progressDialog;

    private String BOOK_ITEMS = "book_items";

    public DbHelper(Context context) {
        _context = context;
        _bookItems = new ArrayList<>();
        _database = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(_context);
    }

    public void loadBooksTypes(final RecyclerView recyclerView, final int count) {
        progressDialog.setMessage("جاري تحميل الكتب");
        progressDialog.setCancelable(false);
        progressDialog.show();
        _database.child(BOOK_ITEMS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapShot) {
                for (DataSnapshot child : snapShot.getChildren()) {
                    _bookItems.add(child.getValue(BookItem.class));
                }
                List list = _bookItems.subList(0, count);
                recyclerView.setAdapter(new BookItemAdapter(_bookItems));
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void searchForBook(final RecyclerView recyclerView, final String name) {
        _database.child(BOOK_ITEMS).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapShot) {
                for (DataSnapshot child : snapShot.getChildren()) {
                    if (child.child("name").getValue(String.class).contains(name))
                        _bookItems.add(child.getValue(BookItem.class));
                }
                recyclerView.setAdapter(new BookItemAdapter(_bookItems));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
