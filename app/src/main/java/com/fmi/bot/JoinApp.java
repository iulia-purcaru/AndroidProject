package com.fmi.bot;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class JoinApp extends AppCompatActivity {

    BottomNavigationView btnavViewID;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        btnavViewID = findViewById(R.id.bottomNavViewId);
        frameLayout = findViewById(R.id.framLayoutId);
        setFragment(new ListFragment());
        btnavViewID.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_all:
                        btnavViewID.setItemBackgroundResource(R.color.navBar);
                        setFragment(new ListFragment());
                        return true;

                    case R.id.ic_add:
                        btnavViewID.setItemBackgroundResource(R.color.navBar);
                        setFragment(new AddFragment());
                        return true;

                    case R.id.ic_about:
                        btnavViewID.setItemBackgroundResource(R.color.navBar);
                        setFragment(new AboutFragment());
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framLayoutId,fragment);
        fragmentTransaction.commit();
    }

}