package com.appsmontreal.projectdrawerlayout;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import model.Country;
import model.CountryFragment;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listViewCountry;
    ArrayList<Country> listOfcountries;
    ArrayAdapter<Country> countryAdapter;
    DrawerLayout drawerLayout;
    public static final String KEY = "country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        listViewCountry = findViewById(R.id.listViewCountry);
        drawerLayout = findViewById(R.id.drawer_layout);
        listViewCountry.setOnItemClickListener(this);
        listOfcountries = new ArrayList<Country>();
        listOfcountries.add(new Country("France","Paris"));
        listOfcountries.add(new Country("India","New Dehli"));
        listOfcountries.add(new Country("Colombia","Bogota"));
        countryAdapter = new ArrayAdapter<Country>(this,android.R.layout.simple_list_item_1,listOfcountries);
        listViewCountry.setAdapter(countryAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY,listOfcountries.get(position));


        //REPLACE THE LINEAR LAYOUT WITH FRAGMENT
        CountryFragment countryFragment = new CountryFragment();
        countryFragment.setArguments(bundle);


        //REFERENCE THE FRAGMENT MANAGER
        android.app.FragmentManager fragmentManager = getFragmentManager();
        //BEGIN THE TRANSACTION
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //REPLACE LINEAR LAYOUT MAIN_UI WITH THE FRAGMENT
        fragmentTransaction.replace(R.id.main_ui,countryFragment);

        //COMMIT THE TRANSACTION
        fragmentTransaction.commit();

        setTitle(listOfcountries.get(position).getCountryName());

        drawerLayout.closeDrawer(listViewCountry);
    }
}
