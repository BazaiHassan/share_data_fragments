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

public class Fragment_One extends Fragment {

    private EditText fistName, lastName;
    private Button btnNext;
    private ItemViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__one, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        findViews(view);
    }

    private void findViews(View view) {
        fistName = view.findViewById(R.id.editTextTextPersonName);
        lastName = view.findViewById(R.id.editTextTextPersonName2);
        btnNext = view.findViewById(R.id.button);
        showLastData();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_One_to_fragment_Two);
                saveData();
            }
        });
    }

    private void showLastData() {
        fistName.setText(viewModel.getFirstName());
        lastName.setText(viewModel.getLastName());
    }

    private void saveData() {
        viewModel.setFirstName(fistName.getText().toString());
        viewModel.setLastName(lastName.getText().toString());
    }
}