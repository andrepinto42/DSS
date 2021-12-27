package bin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bin.Pedido.Pedido;
import bin.Pessoas.Pessoa;
import bin.Pessoas.ReadLoadPessoas;

public class Controller {
    public  static List<Pessoa> allPessoas = new ArrayList<Pessoa>();
    public static List<Pedido> allPedidos = new ArrayList<>();
    public static List<Pedido> pedidosFinalizados = new ArrayList<>();

    public Controller()
    {
        LoadDataBase();
    }
    public static void LoadDataBase()
    {
        allPessoas = ReadLoadPessoas.ReadAllPessoa();

    }
}
