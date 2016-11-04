package br.com.frozenfitnessgourmet.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

/**
 * Created by 15160046 on 25/10/2016.
 */

public class TabActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TabHost tabHost;
    private ListView listPendente;
    private ListView listHistorico;

    PedidoAdapter pedidoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Pendente");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Pendente");
        tabHost.addTab(spec);

        TabHost.TabSpec spec1 = tabHost.newTabSpec("Histórico");
        spec1.setContent(R.id.tab2);
        spec1.setIndicator("Histórico");
        tabHost.addTab(spec1);

       // tabHost.setOnTabChangedListener(new AnimatedTabHostListener(this, tabHost));

        ArrayList<Pedido> lstpedido = new ArrayList<>();

        lstpedido.add( new Pedido("","teste", "Emagrecer") );
        lstpedido.add( new Pedido("","teste2", "Força") );
        lstpedido.add( new Pedido("","teste3", "Massa Musculas") );
        lstpedido.add( new Pedido("","teste4", "Ficar Gostosa") );

        listHistorico = (ListView) findViewById(R.id.listHistorico);
        listPendente = (ListView) findViewById(R.id.listPendente);

        pedidoAdapter = new PedidoAdapter(TabActivity.this, R.layout.pedido_list_item, lstpedido);
        listPendente.setAdapter(pedidoAdapter);


        listPendente.setOnItemClickListener(TabActivity.this);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("Pendente")){
                    ArrayList<Pedido> lstpedido = new ArrayList<>();

                    lstpedido.add( new Pedido("","teste", "Emagrecer") );
                    lstpedido.add( new Pedido("","teste2", "Força") );
                    lstpedido.add( new Pedido("","teste3", "Massa Musculas") );
                    lstpedido.add( new Pedido("","teste4", "Ficar Gostosa") );

                    pedidoAdapter.clear();
                    pedidoAdapter.addAll(lstpedido);


                }else{
                    ArrayList<Pedido> lstpedido = new ArrayList<>();

                    lstpedido.add( new Pedido("","historico", "Emagrecer") );
                    lstpedido.add( new Pedido("","teste2", "Força") );
                    lstpedido.add( new Pedido("","teste3", "Massa Musculas") );
                    lstpedido.add( new Pedido("","teste4", "Ficar Gostosa") );


                    PedidoAdapter pedidoAdapter = new PedidoAdapter(TabActivity.this, R.layout.pedido_list_item, lstpedido);
                    listHistorico.setAdapter(pedidoAdapter);


                    listHistorico.setOnItemClickListener(TabActivity.this);
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, DetalhesActivity.class);

        startActivity(intent);

    }
}


