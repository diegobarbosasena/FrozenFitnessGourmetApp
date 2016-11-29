package br.com.frozenfitnessgourmet.app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 15160046 on 18/11/2016.
 */

class EntregarAdapter extends ArrayAdapter<Entregar>{

    int resource;


    public EntregarAdapter(Context context, int resource, List<Entregar> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;

        if(v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(resource, null);

        }
        Entregar e = getItem(position);

        ImageView img_entregar;
        TextView txt_entregar_titulo,txt_entregar_cliente, txt_entregar_rua, txt_entregar_cidade;

        img_entregar =(ImageView)v.findViewById(R.id.imgPratoE);
        txt_entregar_titulo = (TextView) v.findViewById(R.id.txtTituloE);
        txt_entregar_cliente = (TextView) v.findViewById(R.id.txtClienteE);
        txt_entregar_rua = (TextView) v.findViewById(R.id.txtRuaE);
        txt_entregar_cidade = (TextView) v.findViewById(R.id.txtCidadeE);



        return v;
    }
}
