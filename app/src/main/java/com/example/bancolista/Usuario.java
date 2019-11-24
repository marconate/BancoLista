package com.example.bancolista;

public class Usuario {

    public Usuario(String login, String senha){
        this.Login = login;
        this.Senha = senha;
    }

    public String Login;
    public String Senha;

    @Override
    public String toString() {
        return Login;
    }
}
