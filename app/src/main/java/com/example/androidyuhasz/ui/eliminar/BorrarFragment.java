package com.example.androidyuhasz.ui.eliminar;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.androidyuhasz.R;
import com.example.androidyuhasz.databinding.FragmentBorrarBinding;

public class BorrarFragment extends Fragment {

    private FragmentBorrarBinding binding;
    private BorrarViewModel bvm;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bvm = ViewModelProvider.AndroidViewModelFactory
                .getInstance(requireActivity().getApplication())
                .create(BorrarViewModel.class);

        binding = FragmentBorrarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Observa errores
        bvm.getError().observe(getViewLifecycleOwner(), s -> binding.tvError.setText(s));

        // Observa navegación con datos del producto
        bvm.getNavegarConProducto().observe(getViewLifecycleOwner(), bundle -> {
            DetalleBorrarFragment detalle = new DetalleBorrarFragment();
            detalle.setArguments(bundle);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main, detalle)
                    .addToBackStack(null)
                    .commit();
        });

        // Botón buscar
        binding.btnBuscar.setOnClickListener(v -> {
            String codigo = binding.etCodigo.getText().toString();
            bvm.buscarProducto(codigo);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
