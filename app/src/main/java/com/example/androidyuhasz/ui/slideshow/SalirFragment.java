package com.example.androidyuhasz.ui.slideshow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.androidyuhasz.R;
import com.example.androidyuhasz.databinding.FragmentSlideshowBinding;

public class SalirFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SalirViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SalirViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        new AlertDialog.Builder(requireContext())
                .setTitle("Salir de la app")
                .setMessage("¿Querés cerrar la aplicación?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finishAffinity();
                    }
                })
                /* .setNegativeButton("Volver", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.nav_gallery);
                     }
                 })*/



                .setNegativeButton("Volver", (dialog, which) -> {
                    Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                            .popBackStack(); // vuelve atrás y elimina el fragmento de salir
                })


                .show();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}