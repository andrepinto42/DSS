package bin.Pedido;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import bin.Pessoas.*;

public class ReadLoadPedidos {
    public static String nameFile = "dados/pedidos.txt";


    public static void WritePedido(Pedido p){
        var fwriter = GetFileWriter();

        String writePedido = "";
        writePedido += GetNameClassPedido(p) + ";";
        writePedido += p.getId() + ";";
        writePedido += p.getNIF() + ";";
        writePedido += p.getInicio() + ";";
        writePedido += p.getFim() + ";";
        writePedido += p.getOrcamento() + ";";
        //...........
        System.out.println(writePedido);

        try {
            fwriter.write(writePedido);
            fwriter.flush();
            fwriter.close();
        } catch (Exception e) {e.printStackTrace();}

    }

    public static List<String> ReadAllPedidos() {
        return null;
    }

//.......



    private static FileWriter GetFileWriter()
    {
        try {
            File f = new File(nameFile);
            FileWriter filePedidos = new FileWriter(f,true);

            return filePedidos;
        } catch (Exception e) { e.printStackTrace(); return null;       }
    }
    private static BufferedReader GetFileReader()
    {
        try {
            File f = new File(nameFile);
            FileReader filePedidos = new FileReader(f);
            BufferedReader br = new BufferedReader(filePedidos);

            return br;
        } catch (Exception e) {e.printStackTrace(); return null;        }
    }

    private static String GetNameClassPedido(Pedido p)
    {
        String s;
        try {
            s = p.getClass().getSimpleName();
        } catch (Exception e) {
            s = "";
        }
        return s;
    }
}