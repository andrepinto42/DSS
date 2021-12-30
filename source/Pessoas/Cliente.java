package bin.Pessoas;

import java.util.ArrayList;

import bin.Pessoas.Pessoa;

public class Cliente {
    private String NIF;

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNIF() {
        return NIF;
    }


    public void setNIF(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(String NIF, String nome) {
        //super(nome, ID, password);
        this.NIF = NIF;
        this.nome = nome;
        this.email = "example@gmail.com";
    }
    
    public Cliente(String NIF, String nome,String email) {
        //super(nome, ID, password);
        this.NIF = NIF;
        this.nome = nome;
        this.email = email;
    }
}
