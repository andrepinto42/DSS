package bin.Pessoas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadLoadClientes {
    public static String nameFile = "dados/clientes.txt";

    public static void WriteCliente(Cliente c){
        var fwriter = GetFileWriter();

        String WriteCliente = "";
        WriteCliente += c.getNome() + ";";
        WriteCliente += c.getNIF() + ";\n";
        System.out.println(WriteCliente);

        try {
            fwriter.write(WriteCliente);
            fwriter.flush();
            fwriter.close();
        } catch (Exception e) {e.printStackTrace();}

    }

    public static List<Pessoa> ReadAllCliente()
    {
        var br =  GetFileReader();
        var allLines=  br.lines().collect(Collectors.toList());
        List<Cliente> clientes = new ArrayList<Cliente>();
        Scanner sc;

        for (int i = 0; i < allLines.size(); i++) {
            sc = new Scanner(allLines.get(i));
            sc.useDelimiter(";");

            Cliente pI = null;
            String nomeCliente =  sc.next();
            String nifCliente =  sc.next();

            pI = BuildClienteFromString(nomeCliente, nifCliente);

            if (pI != null)
                clientes.add(pI);
        }
        return clientes;
    }
//??????????????????????????????????????????????????????????????????????????????
    public static Cliente BuildClienteFromString(String nomeCliente, String nifCliente) {
        Cliente pI = null;
        try {
            //Constructor<Cliente> construt =(Constructor<Cliente>) stringPessoas.get(tipoPessoa).getConstructors()[0];
            pI = construt.newInstance(
                    nomeCliente,
                    nifCliente

            );
        } catch (Exception e) { e.printStackTrace();}
        return pI;
    }


    private static FileWriter GetFileWriter()
    {
        try {
            File f = new File(nameFile);
            FileWriter fileClientes = new FileWriter(f,true);

            return fileClientes;
        } catch (Exception e) { e.printStackTrace(); return null;       }
    }
    private static BufferedReader GetFileReader()
    {
        try {
            File f = new File(nameFile);
            FileReader fileClientes = new FileReader(f);
            BufferedReader br = new BufferedReader(fileClientes);

            return br;
        } catch (Exception e) {e.printStackTrace(); return null;        }
    }
}
