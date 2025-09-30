package com.example.androidyuhasz.ui.eliminar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.androidyuhasz.model.Producto;

import java.util.Iterator;

import static com.example.androidyuhasz.MainActivity.listaProductos;

public class DetalleBorrarViewModel extends AndroidViewModel {

    public DetalleBorrarViewModel(@NonNull Application application) {
        super(application);
    }

    public void eliminarProducto(String codigo) {
        Iterator<Producto> iterator = listaProductos.iterator();
        while (iterator.hasNext()) {
            Producto p = iterator.next();
            if (p.getCodigo().equals(codigo)) {
                iterator.remove();
                break;
            }
        }
    }
}