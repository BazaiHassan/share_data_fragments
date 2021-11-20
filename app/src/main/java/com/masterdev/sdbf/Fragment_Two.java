package com.masterdev.sdbf;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_Two extends Fragment {

    private EditText phone, email;
    private Button btnShow;
    private ItemViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__two, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        findViews(view);
    }

    private void findViews(View view) {
        phone = view.findViewById(R.id.editTextTextPersonName);
        email = view.findViewById(R.id.editTextTextPersonName2);
        btnShow = view.findViewById(R.id.button);
        showLastData();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_Two_to_fragment_Result);
                saveData();
            }
        });
    }

    private void showLastData() {
        phone.setText(viewModel.getPhone());
        email.setText(viewModel.getEmail());
    }

    private void saveData() {
        viewModel.setEmail(email.getText().toString());
        viewModel.setPhone(phone.getText().toString());
    }
}