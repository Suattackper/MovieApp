package com.example.movieapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieapp.R;

import com.example.movieapp.databinding.FragmentMoreBinding;
import com.example.movieapp.model.InfoUser;


public class MoreFragment extends Fragment {

    InfoUser infoUser;

    FragmentMoreBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        backButtonOnClick();
    }

    private void backButtonOnClick() {
        binding.imvBack.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.frameLayout, new HomeFragment()).commit();
        });
        binding.lnlAcccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoUser infoUser = InfoUser.getInstance();
                String name = infoUser.getName();
                String email = infoUser.getEmail() ; // Replace with actual email
                String phone = infoUser.getPhone(); // Replace with actual phone

                EditAccountInfoFragment editAccountInfoFragment = EditAccountInfoFragment.newInstance(name,email, phone);


                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, editAccountInfoFragment).commit();

            }
        });


//        binding.lnlWatchList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
//                        .beginTransaction();
//                transaction.replace(R.id.frameLayout, new WatchListFragment()).commit();
//            }
//        });
    }

}