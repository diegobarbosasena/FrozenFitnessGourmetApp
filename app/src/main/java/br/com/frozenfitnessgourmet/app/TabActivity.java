package br.com.frozenfitnessgourmet.app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.google.gson.Gson;

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

        listHistorico = (ListView) findViewById(R.id.listHistorico);
        listPendente = (ListView) findViewById(R.id.listPendente);

        pedidoAdapter = new PedidoAdapter(this, R.layout.pedido_list_item, lstpedido);


        listPendente.setOnItemClickListener(TabActivity.this);



        new ObterPedidos(false).execute("obtem_pendente.php?codUsuario="+ Sessao.usuarioLogado.getCodUsuario());


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                Log.d("setOnTabChangedListener", tabId);

                if (tabId.equals("Pendente")) {

                    new ObterPedidos(false).execute("obtem_pendente.php?codUsuario="+ Sessao.usuarioLogado.getCodUsuario());

                }else {
                   /* ArrayList<Pedido> lstpedido = new ArrayList<>();

                    lstpedido.add(new Pedido("", "historico", "Emagrecer"));
                    lstpedido.add(new Pedido("", "teste2", "Força"));
                    lstpedido.add(new Pedido("", "teste3", "Massa Musculas"));
                    lstpedido.add(new Pedido("", "teste4", "Ficar Gostosa"));


                    PedidoAdapter pedidoAdapter = new PedidoAdapter(TabActivity.this, R.layout.pedido_list_item, lstpedido);
                    listHistorico.setAdapter(pedidoAdapter);


                    listHistorico.setOnItemClickListener(TabActivity.this);*/


                    new ObterPedidos(true).execute("obtem_historico.php?codUsuario="+ Sessao.usuarioLogado.getCodUsuario());
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Pedido p =  pedidoAdapter.getItem(position);
        Intent intent = new Intent(this, DetalhesActivity.class);
        intent.putExtra("pedido", p);
        startActivity(intent);

    }

    private class ObterPedidos extends AsyncTask<String, Void, String> {

        boolean historico =false;

        public ObterPedidos(boolean historico) {
            this.historico = historico;
        }

        @Override
        protected String doInBackground(String... params) {

            String link = getString(R.string.link)+"/API/" + params[0];

            boolean acessarInternet = true;

            HttpRequest http = HttpRequestFabric.getHttpRequest(acessarInternet);

            String json = http.getJson(link);

            return json;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("Json", s);


            if(s !=null) {
                Gson g = new Gson();
                Pedido[] pedidos = g.fromJson(s, Pedido[].class);


                pedidoAdapter.clear();
                pedidoAdapter.addAll(pedidos);

                if(historico){
                    listHistorico.setAdapter(pedidoAdapter);
                }else{
                    listPendente.setAdapter(pedidoAdapter);
                }


            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.fechar=true;
    }
}

