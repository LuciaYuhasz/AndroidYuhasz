package com.example.androidyuhasz.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidyuhasz.model.Producto;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.androidyuhasz.MainActivity.listaProductos;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Producto>> listaMutable;

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<ArrayList<Producto>> getListaMutable() {

        if(listaMutable==null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }




    public void cargarProducto() {
        ArrayList<Producto> copia = new ArrayList<>(listaProductos);
        Collections.sort(copia, (p1, p2) -> p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion()));
        listaMutable.setValue(copia);
    }}