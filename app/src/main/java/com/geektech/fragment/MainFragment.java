package com.geektech.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.fragment.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    public static String KEY = "data";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sendData.setOnClickListener(v -> {
            if (binding.etWrite.getText().toString().isEmpty()) {
                binding.etWrite.setError("Заполните поле!");
            } else {
                Bundle bundle = new Bundle();
                String sendData = binding.etWrite.getText().toString();
                bundle.putString(KEY, sendData);
                SecondFragment firstFragment = new SecondFragment();
                firstFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();

            }

        });
    }
}