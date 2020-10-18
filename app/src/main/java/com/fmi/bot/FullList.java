package com.fmi.bot;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FullList extends AppCompatActivity {
    private FullListAdapter adapter;
    private List<ModalClass> exampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulllist);
        fillExampleList();
        setUpRecyclerView();
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ModalClass(R.drawable.ic_dress,"Dress"));
        exampleList.add(new ModalClass(R.drawable.ic_shoe,"Shoe"));
        exampleList.add(new ModalClass(R.drawable.ic_pants,"Pants"));
        exampleList.add(new ModalClass(R.drawable.ic_cap,"Cap"));
        exampleList.add(new ModalClass(R.drawable.ic_tshirt,"T-Shirt"));
        exampleList.add(new ModalClass(R.drawable.ic_tie,"Tie"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new FullListAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}