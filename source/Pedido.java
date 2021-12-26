package bin;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Pedido {

    private Integer id;
    private long NIF;
    private LocalDate inicio;
    private LocalDate fim;
    private Integer orcamento;
    private Plano pl;

    public Pedido(){
        this.id = 1;
        this.NIF = 0;
        this.inicio = LocalDate.now();
        this.fim = LocalDate.now();
        this.orcamento = 0;
        this.pl = new Plano();

    }

    public Pedido(Integer id,long NIF, LocalDate inicio, LocalDate fim, Integer orcamento, Plano pl){
        this.id = id;
        this.NIF = NIF;
        this.inicio = inicio;
        this.fim = fim;
        this.orcamento = orcamento;
        this.pl = pl;

    }

    public Pedido(Pedido p){
        this.id = p.getId();
        this.NIF = p.getNIF();
        this.inicio = p.getInicio();
        this.fim = p.getFim();
        this.orcamento = p.getOrcamento();
        this.pl = p.getPl();
    }

    public long daysBetween(LocalDate inicio, LocalDate fim){
        return DAYS.between(inicio, fim);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plano getPl() {
        return pl;
    }

    public void setPl(Plano pl) {
        this.pl = pl;
    }

    public Integer getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Integer orcamento) {
        this.orcamento = orcamento;
    }

    public long getNIF() {
        return NIF;
    }

    public void setNIF(long NIF) {
        this.NIF = NIF;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }
}
