package bin.Pessoas;

import bin.Pessoas.Pessoa;

public class Cliente extends Pessoa{
    private String NIF;
    /*
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    */

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Cliente(String nome, String ID, String password) {
        super(nome, ID, password);
        this.NIF = ID;
    }
    
}
