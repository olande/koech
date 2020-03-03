package com.example.materialdesign.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.materialdesign.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    ViewFlipper v_flipper;


    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragmenthome, container, false);

   int image[] ={R.drawable.image1,R.drawable.image2,R.drawable.image3};




        return root;
    }

    public void flipperImages(int image){





    }
}