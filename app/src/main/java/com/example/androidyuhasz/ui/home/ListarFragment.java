package com.example.androidyuhasz.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;


import com.example.androidyuhasz.databinding.FragmentListarBinding;
import com.example.androidyuhasz.model.Producto;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        mv.getListaMutable().observe(getViewLifecycleOwner(), new Observer<ArrayList<Producto>>() {


            @Override
            public void onChanged(ArrayList<Producto> productos) {
                ProductoAdapter la = new ProductoAdapter((ArrayList<Producto>) productos,getContext(),getLayoutInflater());


                GridLayoutManager glm = new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL,false);
                binding.lista.setLayoutManager(glm);
                binding.lista.setAdapter(la);
            }
        });

        mv.cargarProducto();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}