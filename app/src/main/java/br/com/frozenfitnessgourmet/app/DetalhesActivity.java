package br.com.frozenfitnessgourmet.app;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.text.NumberFormat;

import static android.widget.Toast.makeText;
import static java.security.AccessController.getContext;


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

        final Intent intent = getIntent();


        ImageView img_list_pedido, img_status;
        TextView txt_list_titulo, txt_list_caloria, txt_list_categoria, txt_list_preco;

        img_status = (ImageView) findViewById(R.id.imgStatus);
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
                Intent veiculo = new Intent(context,MapsActivity.class);
                startActivity(veiculo);
            }
        });

    }

}
