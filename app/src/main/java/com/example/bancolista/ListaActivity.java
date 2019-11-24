package com.example.bancolista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ListView lstUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lstUsuarios = findViewById(R.id.lstUsuarios);
        ListarUsuarios();
    }

    private void ListarUsuarios() {
        //Obter lsta de usuários
        ArrayList<Usuario> listaUsuarios = new UsuariosDAO(getApplicationContext()).getAll();
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaUsuarios);
        lstUsuarios.setAdapter(adapter);
    }
}
