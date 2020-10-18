package com.fmi.bot;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    private View v;
    RecyclerView recyclerView;
    List<ModalClass> mList;
    CustomAdapter customAdapter;
    private Button shareSp;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_all, container, false);
        recyclerView = v.findViewById(R.id.recyclerViewId);
        customAdapter = new CustomAdapter(mList, getContext());
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Button mredir = (Button) v.findViewById(R.id.button3);
        mredir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),FullList.class);
                startActivity(in);
            }
        });

        return v;
    }

//    private Button share;
//    public void init() {
//        share = findViewById(R.id.join);
//    }
//
//    public void redirectJoinApp() {
//        share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), JoinApp.class);
//                startActivity(intent);
//            }
//        });
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        mList = new ArrayList<>();
        mList.add(new ModalClass(R.drawable.ic_dress,"Dress"));
        mList.add(new ModalClass(R.drawable.ic_shoe,"Shoe"));

    }

//    public CustomAdapter adapter;
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        menu.clear();
//        inflater.inflate(R.menu.search_menu, menu);
//        MenuItem item = menu.findItem(R.id.action_search);
//        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);
//
//        SearchView searchView = (SearchView) item.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {n
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return true;
//            }
//
//        });
//    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;//super.onCreateOptionsMenu(menu);
//    }


}