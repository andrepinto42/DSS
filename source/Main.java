package bin;
import java.time.LocalDate;
import java.util.*;

import bin.Interpreter;
import bin.Pessoas.Pessoa;
import bin.Pedido.*;
import bin.Pessoas.*;
public class Main {
    public static List<Pessoa> allPessoas = new ArrayList<Pessoa>();
    //public static List<Pedido> allPedidos = new ArrayList<>();
    public static Map<LocalDate, Pedido> allPedidos = new HashMap<LocalDate,Pedido>();

    public static void main(String[] args) {

        allPessoas = ReadLoadPessoas.ReadAllPessoa();

        Interpreter it = new Interpreter();
        it.Initialize();
    }

    public static void doStuff() {
        Pessoa p = new Cliente("andre", "12315", "dab");
        Pessoa p1 = new Cliente("rui", "12315", "dab");
        ReadLoadPessoas.WritePessoa(p);
        ReadLoadPessoas.WritePessoa(p1);
    }
}
