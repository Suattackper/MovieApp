package com.example.movieapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.movieapp.databinding.FragmentEditAccountInfoBinding;

public class EditAccountInfoFragment extends Fragment {

    FragmentEditAccountInfoBinding binding;

    public EditAccountInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEditAccountInfoBinding.inflate(inflater, container, false);

        // Lấy dữ liệu từ Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String email = bundle.getString("email");
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");
            binding.editEmail.setText(email);
            binding.editPhone.setText(phone);
            binding.editPassword.setText(name);
            Toast.makeText(getContext(), email, Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(getContext(), "bundle is null", Toast.LENGTH_SHORT).show();

        }

        return binding.getRoot();
    }
    public static EditAccountInfoFragment newInstance(String name,String email, String phone) {
        EditAccountInfoFragment fragment = new EditAccountInfoFragment();
        Bundle args = new Bundle();
        args.putString("name",name);
        args.putString("email", email);
        args.putString("phone", phone);
        fragment.setArguments(args);
        return fragment;
    }
}