package br.com.frozenfitnessgourmet.app;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;


public class DetalhesActivity extends AppCompatActivity {

    Button btnMapa;
    Context context;




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        final Intent intent = getIntent();

        btnMapa = (Button) findViewById(R.id.btnmapa);


        ImageView img_list_pedido, img_status;
        TextView txt_list_titulo, txt_list_caloria, txt_list_categoria, txt_list_preco;

        img_status = (ImageView) findViewById(R.id.imgStatus);
        img_list_pedido = (ImageView) findViewById(R.id.imgDetalhe);
        txt_list_titulo = (TextView) findViewById(R.id.txtTituloD);
        txt_list_caloria = (TextView) findViewById(R.id.txtCaloriaD);
        txt_list_categoria = (TextView) findViewById(R.id.txtCategoriaD);
        txt_list_preco =  (TextView) findViewById(R.id.txtPrecoD);

        if(intent != null){
            Pedido p = (Pedido)intent.getSerializableExtra("pedido");



            txt_list_titulo.setText(p.getNomePrato());
            txt_list_caloria.setText(p.getCaloria());
            txt_list_categoria.setText(p.getNomeCategoriaPrato());
            txt_list_preco.setText(NumberFormat.getCurrencyInstance().format(p.getPrecoPrato()));

            String img_pedido = context.getString(R.string.link)+"/FrozenFitnessGourmetPHP/" + p.getImagemPrato();
            Log.d("imagem", img_pedido);
            Picasso.with(context).load(img_pedido).into(img_list_pedido);
            //new DownlogetContext()adImageTask(img_list_pedido).execute(img_pedido);

            if(p.getCodStatus() == 1){
                img_status.setImageResource(R.drawable.img1);
            }else if(p.getCodStatus() == 2){
                img_status.setImageResource(R.drawable.img2);
            }else if(p.getCodStatus() == 3){
                img_status.setImageResource(R.drawable.img3);
            }else if(p.getCodStatus() == 4){
                img_status.setImageResource(R.drawable.img4);
            }else if(p.getCodStatus() == 5){
                img_status.setImageResource(R.drawable.img5);
            }else if(p.getCodStatus() == 6){
                img_status.setImageResource(R.drawable.img6);
            }

        }

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MapsActivity.class));
            }
        });

    }

}
