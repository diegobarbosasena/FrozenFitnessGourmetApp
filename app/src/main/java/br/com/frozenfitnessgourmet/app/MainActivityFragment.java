package br.com.frozenfitnessgourmet.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import static br.com.frozenfitnessgourmet.app.R.id.btnentrar;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    String url = "";
    String parametros = "";


    EditText editLogin;
    EditText editSenha;
    Button btnEntrar;

    public MainActivityFragment() {
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        editLogin = (EditText) view.findViewById(R.id.edtLogin);
        editSenha = (EditText) view.findViewById(R.id.edtSenha);
        btnEntrar = (Button) view.findViewById(btnentrar);

        btnEntrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)
                        getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {

                    String usuario = editLogin.getText().toString();
                    String senha = editSenha.getText().toString();

                    if (usuario.isEmpty() || senha.isEmpty()) {
                        Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();
                    } else {
                        url = getString(R.string.link)+"/API/autenticacao_usuario.php";

                        parametros = "usuario=" + usuario + "&senha=" + senha;
                        new SolicitaDados().execute(url);
                    }
                } else {
                    Toast.makeText(getContext(), "Nehuma conexãoo detectada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametros);

        }
        // onPostExecute displays the results of the AsyncTask.


        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            String titulo ="Efetuando Login";
            String mensagem = "Aguarde...";
            boolean indeterminado =true;
            boolean podeCancelar = false;

            progressDialog = ProgressDialog
                    .show(getContext(),
                            titulo,
                            mensagem,
                            indeterminado,
                            podeCancelar
                    );
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            progressDialog.dismiss();


            Log.d("login", resultado);

           LoginUsuario login = new Gson().fromJson(resultado, LoginUsuario.class);

            Sessao.usuarioLogado = login;

            if(login.getTipo().equals("login_cliente")){
                Intent cliente = new Intent(getActivity(), TabActivity.class);
                startActivity(cliente);
            }else if(login.getTipo().equals("login_veiculo")){
                Intent veiculo = new Intent(getActivity(), VeiculoActivity.class);
                startActivity(veiculo);
            }else{
                Toast.makeText(getContext(), "Usuario ou Senha incorreto", Toast.LENGTH_SHORT).show();
            }
        }
    }




}
