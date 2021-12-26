package bin;
import java.time.LocalDate;
import java.util.*;

<<<<<<< HEAD
import bin.Interpreter;
import bin.Pessoas.Pessoa;
=======
import bin.Pedido.Pedido;
>>>>>>> 27539156badf448d16b98d72ceebcf4d7cd3f965
import bin.Pessoas.*;
public class Main {
    public static List<Pessoa> allPessoas = new ArrayList<Pessoa>();
    //public static List<Pedido> allPedidos = new ArrayList<>();
    public static Map<LocalDate, Pedido> allPedidos = new HashMap<>();

    public static void main(String[] args) {

<<<<<<< HEAD
        allPessoas = ReadLoadPessoas.ReadAllPessoa();

    // Interpreter it = new Interpreter();
    // it.Initialize();
=======
        // ReadLoadPessoas.ReadAllPessoa();
        Interpreter it = new Interpreter();
        it.Initialize();
>>>>>>> 27539156badf448d16b98d72ceebcf4d7cd3f965
    }

    public static void doStuff() {
        Pessoa p = new Cliente("andre", "12315", "dab");
        Pessoa p1 = new Cliente("rui", "12315", "dab");
        ReadLoadPessoas.WritePessoa(p);
        ReadLoadPessoas.WritePessoa(p1);
    }
}
