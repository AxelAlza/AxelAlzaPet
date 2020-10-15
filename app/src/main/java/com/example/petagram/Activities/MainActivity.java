package com.example.petagram.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import com.example.petagram.Adaptadores.PageAdapter;
import com.example.petagram.Fragments.FragmentViewPerfil;
import com.example.petagram.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {


    MaterialToolbar Mt;
    ViewPager2 Fvp;
    TabLayout Tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fvp = findViewById(R.id.VPviewpager);
        Tab = findViewById(R.id.tab);
        Mt = findViewById(R.id.topAppBar);
        setSupportActionBar(Mt);
        Tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Fvp.setCurrentItem(0);
                        break;
                    case 1:
                        Fvp.setCurrentItem(1);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                return;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                return;
            }
        });
        setUpViewPager();
        Fvp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        Tab.selectTab(Tab.getTabAt(0));
                        break;
                    case 1:
                        Tab.selectTab(Tab.getTabAt(1));

                }
            }
        });
    }

    public void irFavoritos() {
        Intent intent = new Intent(this, CincoFavoritos.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.favoritos:
                irFavoritos();
                return true;
            case R.id.acercade:
                intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
                return true;
            case R.id.contacto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setUpViewPager(){
        Fvp.setAdapter(new PageAdapter(getSupportFragmentManager(),getLifecycle()));


    }



}