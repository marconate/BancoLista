package com.example.bancolista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuariosDAO {
    UsuariosDbHelper dbHelper;

    public UsuariosDAO(Context context){
        dbHelper = new UsuariosDbHelper(context);
    }

    public void insert(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("LOGIN", usuario.Login);
        values.put("SENHA", usuario.Senha);

        db.insert("USUARIOS", null, values);
    }

    public ArrayList<Usuario> getAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        String sql = "SELECT LOGIN, SENHA FROM USUARIOS";
        Cursor cur = db.rawQuery(sql, null);

        if (cur.moveToFirst()){
            do {
                listaUsuarios.add(new Usuario(cur.getString(0), cur.getString(1)));
            } while(cur.moveToNext());
        }

        return listaUsuarios;
    }

    public Usuario get(String login){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Usuario usuario = null;

        String[] projection = { "LOGIN", "SENHA" };
        String selection = "LOGIN = ?";
        String[] selectionArgs = { login };

        Cursor cur = db.query("USUARIOS", projection, selection, selectionArgs, null, null, null);

        if (cur.moveToFirst()){
            do {
                usuario = new Usuario(cur.getString(0), cur.getString(1));
            } while(cur.moveToNext());
        }

        return usuario;
    }
}
