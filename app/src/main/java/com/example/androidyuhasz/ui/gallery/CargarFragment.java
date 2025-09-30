package com.example.androidyuhasz.ui.gallery;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidyuhasz.databinding.FragmentCargarBinding;


public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel cvm;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        cvm = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        // Observa errores
        cvm.getMError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvError.setText(s);
            }
        });

        // Observa éxito
        cvm.getMCorrecto().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvError.setText(s);
                binding.etCodigo.setText("");
                binding.etDescripcion.setText("");
                binding.etPrecio.setText("");

            }
        });




        binding.btnAgregar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ACA NO DEBERIN SE STRING PER COMO ESTAN VACIOS NO [ERMITE CASTEAR,, HACER LA VALIDACIO EN EL VIEWMODEL
                String codigo= binding.etCodigo.getText().toString();
                String descripcion =binding.etDescripcion.getText().toString();
                String precio=binding.etPrecio.getText().toString();
                cvm.cargarProducto(codigo, descripcion, precio);


            }
        }));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}