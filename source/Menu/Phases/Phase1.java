package bin;
import bin.Phase2;

import java.util.HashMap;
import java.util.List;


public class Phase1 extends bin.Phase {
    private HashMap<String,Class<? extends Phase>> CommandsMap =
        new HashMap<String,Class<? extends Phase>>();

    public Phase1()
    {
        Messages =  new String[]{
            "Reparação de Sistemas",
            "Seja Bem-vindo",
            "",
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
