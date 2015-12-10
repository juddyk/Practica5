package com.example.juddyreina.oiste;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation) ;


        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new Frag1()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.item_inicio:
                        FragmentTransaction fT = mFragmentManager.beginTransaction();
                        fT.replace(R.id.containerView, new Frag1()).commit();
                        break;
                    case R.id.item_cinemas:
                        FragmentTransaction fT1 = mFragmentManager.beginTransaction();
                        fT1.replace(R.id.containerView, new TabCine()).commit();
                        break;
                    case R.id.item_teatros:
                        FragmentTransaction fT2 = mFragmentManager.beginTransaction();
                        fT2.replace(R.id.containerView, new TabTeatro()).commit();
                        break;
                    case R.id.item_restaurantes:
                        FragmentTransaction fT3 = mFragmentManager.beginTransaction();
                        fT3.replace(R.id.containerView, new TabRestaurante()).commit();
                        break;
                    case R.id.item_bares:
                        FragmentTransaction fT4 = mFragmentManager.beginTransaction();
                        fT4.replace(R.id.containerView, new TabBar()).commit();
                        break;
                    case R.id.item_sitios:
                        FragmentTransaction fT5 = mFragmentManager.beginTransaction();
                        fT5.replace(R.id.containerView, new TabSitios()).commit();
                        break;
                }
                return false;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.hello,R.string.bye);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

}
