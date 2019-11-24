package com.example.bancolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickListar(View v){
        Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
        startActivity(intent);
    }

    public void onClickCadastrar(View v){
        Intent intent = new Intent(getApplicationContext(), CadastrarActivity.class);
        startActivity(intent);
    }
}
