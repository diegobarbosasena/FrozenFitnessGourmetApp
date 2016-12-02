package br.com.frozenfitnessgourmet.app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 15160046 on 02/12/2016.
 */

public class EntregaDetalheAdapter extends ArrayAdapter<Entregar> {
    int resource;
    Context context;

    public EntregaDetalheAdapter(Context context, int resource, List<Entregar> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(resource, null);

        }
        Entregar e = getItem(position);

        ImageView img_entrega;
        TextView txt_entregar_titulo, txt_entregar_categoria;


        img_entrega = (ImageView) v.findViewById(R.id.imgPratoE);
        txt_entregar_titulo = (TextView) v.findViewById(R.id.txtTituloE);
        txt_entregar_categoria = (TextView) v.findViewById(R.id.txtCategoriaE);

        txt_entregar_titulo.setText(e.getNomePrato());
        txt_entregar_categoria.setText(e.getNomeCategoriaPrato());

        String img_pedido = "http://10.107.134.2/FrozenFitnessGourmetPHP/" + e.getImagemPrato();
        Log.d("imagem", img_pedido);
        Picasso.with(context).load(img_pedido).into(img_entrega);

        return v;
    }
}
