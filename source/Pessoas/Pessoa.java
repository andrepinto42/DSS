package bin.Pessoas;

public abstract class Pessoa {
    protected String nome;
    protected String ID;
    protected String password;

    public Pessoa(String nome,String ID,String password)
    {
        this.nome = nome;
        this.ID = ID;
        this.password = password;
    }
}
