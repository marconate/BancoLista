package com.example.bancolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edLogin;
    EditText edSenha;
    Context context;
    int toastDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        toastDuration = Toast.LENGTH_SHORT;

        edLogin = findViewById(R.id.edLogin);
        edSenha = findViewById(R.id.edSenha);
    }

    public void onClickEntrar(View v){
        String login = edLogin.getText().toString();
        String senha = edSenha.getText().toString();

        //Obter do SQLite
        Usuario usuario = new UsuariosDAO(getApplicationContext()).get(login);

        if (usuario != null && usuario.Senha.equals(senha)) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else {
            Toast toast;
            toast = Toast.makeText(context, "Login ou senha inválidos", toastDuration);
            toast.show();
        }

    }

    public void onClickCadastrar(View v){
        Intent intent = new Intent(getApplicationContext(), CadastrarActivity.class);
        startActivity(intent);
    }
}
