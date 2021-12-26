package bin;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Pedido {

    private long NIF;
    private LocalDate inicio;
    private LocalDate fim;
    private Integer orcamento;

    private Plano p;

    public Pedido(){
        this.NIF = 0;
        this.inicio = LocalDate.now();
        this.fim = LocalDate.now();
        this.orcamento = 0;
    }

    public Pedido(long NIF, LocalDate inicio, LocalDate fim, Integer orcamento){
        this.NIF = NIF;
        this.inicio = inicio;
        this.fim = fim;
        this.orcamento = orcamento;

    }

    public Pedido(Pedido p){
        this.NIF = p.getNIF();
        this.inicio = p.getInicio();
        this.fim = p.getFim();
        this.orcamento = p.getOrcamento();
    }

    public long daysBetween(LocalDate inicio, LocalDate fim){
        return DAYS.between(inicio, fim);
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
