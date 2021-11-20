package com.masterdev.sdbf;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Fragment_Result extends Fragment {

    private TextView firstName, lastName, phone, email;
    private Button btnExit;
    private ItemViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__result, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        findView(view);
        showData();

    }

    private void showData() {
        firstName.setText(viewModel.getFirstName());
        lastName.setText(viewModel.getLastName());
        phone.setText(viewModel.getPhone());
        email.setText(viewModel.getEmail());

    }


    private void findView(View view) {
        firstName = view.findViewById(R.id.textView2);
        lastName = view.findViewById(R.id.textView3);
        phone = view.findViewById(R.id.textView4);
        email = view.findViewById(R.id.textView5);
        btnExit = view.findViewById(R.id.button2);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });
    }
}