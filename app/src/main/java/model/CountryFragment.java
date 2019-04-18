package model;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsmontreal.projectdrawerlayout.MainActivity;
import com.appsmontreal.projectdrawerlayout.R;

public class CountryFragment extends android.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {


        return inflater.inflate(R.layout.country_fragment,container,false);
    }


    //receiving data
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Country country = (Country) getArguments().getSerializable(MainActivity.KEY);
        TextView textViewCapital = getActivity().findViewById(R.id.textViewCapital);
        textViewCapital.setText(country.getCountryCapital());

    }

}
