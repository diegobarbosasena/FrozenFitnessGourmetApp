package br.com.frozenfitnessgourmet.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;


public class DetalhesActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        ImageView img_list_pedido;
        TextView txt_list_titulo, txt_list_categoria, txt_list_caloria, txt_list_preco;

        txt_list_titulo = (TextView) findViewById(R.id.txtTituloD);
        txt_list_categoria = (TextView) findViewById(R.id.txtCategoriaD);
        txt_list_caloria = (TextView) findViewById(R.id.txtCaloriaD);
        txt_list_preco =  (TextView) findViewById(R.id.txtPrecoD);

        if(intent != null){
            Pedido p = (Pedido)intent.getSerializableExtra("pedido");

            txt_list_titulo.setText(p.getNomePrato());
            txt_list_categoria.setText(p.getNomeCategoriaPrato());
            txt_list_caloria.setText(p.getCaloria());
            txt_list_preco.setText(NumberFormat.getCurrencyInstance().format(p.getPrecoPrato()));
        }

    }

}
