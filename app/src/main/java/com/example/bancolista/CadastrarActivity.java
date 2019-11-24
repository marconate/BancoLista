package com.example.bancolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    EditText edLoginCadastro;
    EditText edSenhaCadastro;
    EditText edConfirmacaoSenhaCadastro;
    Context context;
    int toastDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        context = getApplicationContext();
        toastDuration = Toast.LENGTH_SHORT;

        edLoginCadastro = findViewById(R.id.edLoginCadastro);
        edSenhaCadastro = findViewById(R.id.edSenhaCadastro);
        edConfirmacaoSenhaCadastro = findViewById(R.id.edConfirmaSenhaCadastro);
    }

    public void onClickSalvar(View v) {
        String login = edLoginCadastro.getText().toString();
        String senha = edSenhaCadastro.getText().toString();
        String confirmacao = edConfirmacaoSenhaCadastro.getText().toString();
        Toast toast;

        if (senha.equals(confirmacao)) {
            salvarUsuario(login, senha);
            toast = Toast.makeText(context, "Salvo com sucesso!", toastDuration);
            edLoginCadastro.setText("");
            edSenhaCadastro.setText("");
            edConfirmacaoSenhaCadastro.setText("");
        } else {
            toast = Toast.makeText(context, "Senhas não conferem!", toastDuration);
        }

        toast.show();
        finish();
    }

    private void salvarUsuario(String login, String senha) {
        //Cadastrar usuário
        Usuario usuario = new Usuario(login, senha);
        new UsuariosDAO(getApplicationContext()).insert(usuario);
    }
}
