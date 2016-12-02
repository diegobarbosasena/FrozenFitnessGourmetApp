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
 * Created by 15160046 on 28/10/2016.
 */

public class PedidoAdapter extends ArrayAdapter<Pedido> {

    int resource;
    Context context;

    public PedidoAdapter(Context context, int resource, List<Pedido> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;

        if(v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(resource, null);

        }
        Pedido p = getItem(position);

        ImageView img_list_pedido;
        TextView txt_list_titulo,txt_list_categoria;

        img_list_pedido =(ImageView) v.findViewById(R.id.imgPratoP);
        txt_list_titulo = (TextView) v.findViewById(R.id.txtTituloP);
        txt_list_categoria = (TextView) v.findViewById(R.id.txtCategoriaP);



        txt_list_titulo.setText(p.getNomePrato());
        txt_list_categoria.setText(p.getNomeCategoriaPrato());

        String img_pedido = context.getString(R.string.link)+"/FrozenFitnessGourmetPHP/" + p.getImagemPrato();
        Log.d("imagem", img_pedido);

        Picasso.with(getContext()).load(img_pedido).into(img_list_pedido);
        //new DownloadImageTask(img_list_pedido).execute(img_pedido);

        return v;
    }
}
