package com.example.androidyuhasz.ui.eliminar;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.androidyuhasz.model.Producto;

import java.util.List;

import static com.example.androidyuhasz.MainActivity.listaProductos;

public class BorrarViewModel extends AndroidViewModel {

    private final MutableLiveData<String> error = new MutableLiveData<>();
    private final MutableLiveData<Bundle> navegarConProducto = new MutableLiveData<>();

    public BorrarViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public MutableLiveData<Bundle> getNavegarConProducto() {
        return navegarConProducto;
    }

    public void buscarProducto(String codigo) {
        // Limpia el estado anterior
        navegarConProducto.setValue(null);
        error.setValue(null);

        if (codigo == null || codigo.trim().isEmpty()) {
            error.setValue("Debe ingresar un código.");
            return;
        }

        List<Producto> productos = listaProductos;
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                Bundle bundle = new Bundle();
                bundle.putString("codigo", p.getCodigo());
                bundle.putString("descripcion", p.getDescripcion());
                bundle.putDouble("precio", p.getPrecio());
                navegarConProducto.setValue(bundle);
                return;
            }
        }

        error.setValue("Producto no encontrado.");
    }
}


