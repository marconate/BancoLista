package com.example.bancolista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

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
        //TODO: Obter lsta de usuários

    }
}
