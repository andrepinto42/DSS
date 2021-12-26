package bin.Pessoas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import bin.Pessoas.*;

public class ReadLoadPessoas {
    public static String nameFile = "dados/baseDados.txt";


    public static void WritePessoa(Pessoa p){
        var fwriter = GetFileWriter();

        String writePessoa = "";
        writePessoa += GetNameClassPessoa(p) + ";";
        writePessoa += p.nome + ";";
        writePessoa += p.ID + ";";
        writePessoa += p.password + ";\n";
        System.out.println(writePessoa);

        try {
            fwriter.write(writePessoa);
            fwriter.flush();
            fwriter.close();
        } catch (Exception e) {e.printStackTrace();}
        
    }

    public static List<String> ReadAllPessoa()
    {
        var br =  GetFileReader();
        String line ="";
        var allLines=  br.lines().collect(Collectors.toList());

        Scanner sc;
        for (int i = 0; i < allLines.size(); i++) {
            sc = new Scanner(allLines.get(i));
            sc.useDelimiter(";");

            String tipoPessoa =  sc.next();
            String nomePessoa =  sc.next();
            String IDPessoa =  sc.next();
            String passwordPessoa =  sc.next();
        }
        return null;
    }





    private static FileWriter GetFileWriter()
    {
        try {
            File f = new File(nameFile);
            FileWriter filePessoas = new FileWriter(f,true);

            return filePessoas;
        } catch (Exception e) { e.printStackTrace(); return null;       }
    }
    private static BufferedReader GetFileReader()
    {
        try {
            File f = new File(nameFile);
            FileReader filePessoas = new FileReader(f);
            BufferedReader br = new BufferedReader(filePessoas);
            
            return br;
        } catch (Exception e) {e.printStackTrace(); return null;        }
    }

    private static String GetNameClassPessoa(Pessoa p)
    {
        String s;
        try {
            s = p.getClass().getSimpleName();
        } catch (Exception e) {
            s = "Cliente";
        }
        return s;
    }
}
