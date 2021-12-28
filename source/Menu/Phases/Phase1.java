package bin;

import bin.Phase2;
import bin.Phase3;
import bin.Phase4;
import bin.Phase5;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.FuncionarioReparacao;
import bin.Pessoas.Gestor;
import bin.Pessoas.Pessoa;

import java.util.HashMap;
import java.util.List;

public class Phase1 extends bin.Phase {
    private HashMap<String,Class<? extends Phase>> CommandsMap =
        new HashMap<String,Class<? extends Phase>>();
    public static Pessoa currentPessoa = null;

    public Phase1(String s)
    {
        ChangeSucessMessage(s);
        Default();
        BuildForPessoa();
    }
    public Phase1()
    {
        Default();
        BuildForPessoa();
    }

    private void BuildForPessoa()
    {
        if (currentPessoa == null) return;

        if (currentPessoa instanceof FuncionarioBalcao)
            BuildFuncionario();
        else if (currentPessoa instanceof FuncionarioReparacao)
            BuildReparacao();
        else if (currentPessoa instanceof Gestor)
            BuildGestor();
    }
    public void BuildFuncionario()
    {
        Messages =  new String[]{
            "Reparação de Sistemas",
            "Seja Bem-vindo",
            (currentPessoa != null)? currentPessoa.getNome() : "",
            "Comandos",
            "quit -> Sair do programa",
            "login -> Autenticar utilizador",
            "register -> Registar utilizador",
            "iniciate -> Iniciar novo pedido",
            "final -> Finalizar um pedido de um cliente",
            "express -> Iniciar um pedido express ",
        };

        CommandsMap.put("iniciate",Phase4.class);
        CommandsMap.put("final",Phase7.class);
        CommandsMap.put("express",Phase8.class);
    }

    public void BuildReparacao()
    {
        Messages =  new String[]{
            "Reparação de Sistemas",
            "Seja Bem-vindo",
            (currentPessoa != null)? currentPessoa.getNome() : "",
            "Comandos",
            "quit -> Sair do programa",
            "login -> Autenticar utilizador",
            "register -> Registar utilizador",
            "final -> Definir horas de trabalho e custo de um pedido",
        };

        CommandsMap.put("final", Phase5.class);
    }
    public void BuildGestor()
    {
        Messages =  new String[]{
            "Reparação de Sistemas",
            "Seja Bem-vindo Gestor",
            (currentPessoa != null)? currentPessoa.getNome() : "",
            "Comandos",
            "quit -> Sair do programa",
            "login -> Autenticar utilizador",
            "register -> Registar utilizador",
            "saldo -> Visualizar gerencia da loja",
        };
    }

    private void Default() {
        Messages =  new String[]{
            "Reparação de Sistemas",
            "Seja Bem-vindo",
            (currentPessoa != null)? currentPessoa.getNome() : "",
            "Comandos",
            "quit -> Sair do programa",
            "login -> Autenticar utilizador",
            "register -> Registar utilizador",
        };
        TipForInput = "Escreva um comando";
        InputForStages = new String[]{
          
        };
        numberStages = InputForStages.length +1;

        CommandsMap.put("login", Phase2.class);
        CommandsMap.put("register", Phase3.class);
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        String firstCommand = s.get(0);
        
        if (!CommandsMap.containsKey(firstCommand)) 
        {
            ChangeWarningMessage("Ups não inseriu nada de jeito\n");
            return null;
        }
        Phase p= null;
        try {
            p = CommandsMap.get(firstCommand).getDeclaredConstructor().newInstance();
            
        } catch (Exception ignored) { }     
        return p;        
    }

}
