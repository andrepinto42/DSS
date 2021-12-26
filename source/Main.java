package bin;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bin.Interpreter;
import bin.Pessoas.Pessoa;
import bin.Pessoas.*;
public class Main{
    public static List<Pessoa> allPessoas = new ArrayList<Pessoa>();
    public static void main(String[] args) {

        allPessoas = ReadLoadPessoas.ReadAllPessoa();

    // Interpreter it = new Interpreter();
    // it.Initialize();
    }
    public static void doStuff()
    {
        Pessoa p = new Cliente("andre","12315","dab");
        Pessoa p1 = new Cliente("rui","12315","dab");
        ReadLoadPessoas.WritePessoa(p);
        ReadLoadPessoas.WritePessoa(p1);
    }
}