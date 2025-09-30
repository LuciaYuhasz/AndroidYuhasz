package com.example.androidyuhasz.ui.eliminar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidyuhasz.databinding.FragmentDetalleBorrarBinding;

public class DetalleBorrarFragment extends Fragment {

    private FragmentDetalleBorrarBinding binding;
    private DetalleBorrarViewModel dvm;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dvm = new ViewModelProvider(this).get(DetalleBorrarViewModel.class);
        binding = FragmentDetalleBorrarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle args = getArguments();
        if (args != null) {
            binding.tvCodigo.setText(args.getString("codigo"));
            binding.tvDescripcion.setText(args.getString("descripcion"));
            binding.tvPrecio.setText(String.valueOf(args.getDouble("precio")));
        }

        binding.btnConfirmar.setOnClickListener(v -> {
            String codigo = args.getString("codigo");
            dvm.eliminarProducto(codigo);
            requireActivity().getSupportFragmentManager().popBackStack(); // Volver atrás
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}