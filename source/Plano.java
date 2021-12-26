package bin;

public class Plano {

    private double totalHoras;
    private double custo;

    public Plano(){
        this.custo = 0;
        this.totalHoras = 0;
    }

    public Plano(double totalHoras, double custo) {
        this.totalHoras = totalHoras;
        this.custo = custo;
    }
}
