package com.example.androidyuhasz.ui.gallery;

import static com.example.androidyuhasz.MainActivity.*;
//CUANDO HAYAS HECHO EL MAIN ACTIVITI CAMBIA ABAJO LA REFERENCIA A ESTE Y SOLO DEJA LISTApRODUCTOS
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidyuhasz.databinding.FragmentCargarBinding;
import com.example.androidyuhasz.model.Producto;

public class CargarViewModel extends AndroidViewModel {



    private MutableLiveData<String> mError;
    private MutableLiveData<String> mCorrecto;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String> getMError() {
        if (mError == null) mError = new MutableLiveData<>();
        return mError;
    }

    public LiveData<String> getMCorrecto() {
        if (mCorrecto == null) mCorrecto = new MutableLiveData<>();
        return mCorrecto;
    }

    public void cargarProducto(String codigo, String descripcion, String precio) {
        if (codigo == null || codigo.trim().isEmpty() ||
                descripcion == null || descripcion.trim().isEmpty() ||
                precio == null || precio.trim().isEmpty()) {
            mError.setValue("Todos los campos son obligatorios.");
            return;
        }

        double precioDouble;
        try {
            precioDouble = Double.parseDouble(precio);
            if (precioDouble <= 0) {
                mError.setValue("El precio debe ser mayor a cero.");
                return;
            }
        } catch (NumberFormatException e) {
            mError.setValue("El precio debe ser un número válido.");
            return;
        }

        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                mError.setValue("El código ya existe. Ingrese uno diferente.");
                return;
            }
        }

        Producto nuevoProducto = new Producto(codigo, descripcion, precioDouble);
        listaProductos.add(nuevoProducto);

        mCorrecto.setValue("Producto agregado correctamente.");

// Limpieza automática del mensaje
        new android.os.Handler().postDelayed(() -> {
            if (mCorrecto != null) {
                mCorrecto.setValue("");
            }
        }, 1500);


    }}