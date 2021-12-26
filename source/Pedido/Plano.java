package bin.Pedido;

import java.util.Random;

public class Plano {

    private Integer totalHoras;
    private Integer custo;

    public Plano(){
        this.custo = 0;
        this.totalHoras = 0;
    }

    public Plano(Integer totalHoras, Integer custo) {
        this.totalHoras = totalHoras;
        this.custo = custo;
    }

    //random????
    public static Integer calculaCusto(){
        Random random = new Random();
        return random.nextInt(101 - 10) + 10;
    }

    //random????
    public static Integer calculaHoras(){
        Random random = new Random();
        return random.nextInt(121 - 24) + 24;
    }
}
