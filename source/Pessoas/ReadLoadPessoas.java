package bin.Pessoas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import bin.Pessoas.*;

public class ReadLoadPessoas {
    public static String nameFile = "dados/baseDados.txt";
    private static Map<String,Class<? extends Pessoa>> stringPessoas = new HashMap<String,Class<? extends Pessoa>>()
    {
        {
            put("Cliente", Cliente.class);
            put("Funcionario", FuncionarioBalcao.class);
            put("Gestor", Gestor.class);
            put("Reparacao", FuncionarioReparacao.class);
        }
    };

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

    public static List<Pessoa> ReadAllPessoa()
    {
        var br =  GetFileReader();
        var allLines=  br.lines().collect(Collectors.toList());
        List<Pessoa> allPessoas = new ArrayList<Pessoa>();
        Scanner sc;
        
        for (int i = 0; i < allLines.size(); i++) {
            sc = new Scanner(allLines.get(i));
            sc.useDelimiter(";");

            Pessoa pI = null;
            String tipoPessoa =  sc.next();
            String nomePessoa =  sc.next();
            String IDPessoa =  sc.next();
            String passwordPessoa =  sc.next();

            try {
                Constructor<Pessoa> construt =(Constructor<Pessoa>) stringPessoas.get(tipoPessoa).getConstructors()[0];
                pI = construt.newInstance(
                    nomePessoa,
                    IDPessoa,
                    passwordPessoa
                );    
            } catch (Exception e) { e.printStackTrace();}
            
            if (pI != null)
            allPessoas.add(pI);
        }
        return allPessoas;
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
