package com.example.androidyuhasz.ui.home;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidyuhasz.R;
import com.example.androidyuhasz.model.Producto;

import java.util.ArrayList;
import java.util.List;


public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProducto> {
    private ArrayList<Producto>listado;
    private Context context;
    private LayoutInflater li;


    public ProductoAdapter(ArrayList<Producto>listado,Context context,LayoutInflater li){
        this.context=context;
        this.listado=listado;
        this.li=li;
    }


    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = li.inflate(R.layout.item,parent,false);
        return new ViewHolderProducto(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {




        /*
        if (listado.isEmpty()) {
            holder.codigo.setText("");
            holder.descripcion.setText("");
            holder.precio.setText("");
        } else {
            Producto prodActual = listado.get(position);
            holder.codigo.setText(prodActual.getCodigo());
            holder.descripcion.setText(prodActual.getDescripcion());
            //String precioFormateado = formatoPrecio.format(prodActual.getPrecio());
            holder.precio.setText("$ "+ prodActual.getPrecio());
        }
*/
        Producto prodActual = listado.get(position);
        holder.codigo.setText(prodActual.getCodigo());
        holder.descripcion.setText(prodActual.getDescripcion());
        holder.precio.setText("$ " + prodActual.getPrecio());


    }

    @Override
    public int getItemCount() {
        return listado.size();
    }



    public class ViewHolderProducto extends RecyclerView.ViewHolder{
        TextView codigo, descripcion,precio;


        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            codigo=itemView.findViewById(R.id.tvCodigo);
            descripcion =itemView.findViewById(R.id.tvDescripcion);
            precio=itemView.findViewById(R.id.tvPrecio);

        }}


}
