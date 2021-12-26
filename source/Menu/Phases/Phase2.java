package bin;

import java.util.List;
import java.util.ArrayList;

import bin.Phase;
import bin.Phase1;

public class Phase2 extends Phase{
    
    public Phase2()
    {
        Messages =  new String[]{
            "Autenticação",
        };
        TipForInput = "Username";

        InputForStages = new String[]{
            "Password",
        };
        numberStages = InputForStages.length +1;

        CommandsMap.put("any",Phase1.class);

    }
    @Override
    public Phase HandleCommand(List<String> s) {
        
        String username = s.get(0);
        String password = s.get(1);

        //Se nao existir esse usuario na base de dados
        if (!username.equals(password)) {
            ChangeWarningMessage("Não existe o usuário "+  username + " por favor insira algo de jeito\n");
            return null;
        }
        List<String> l =  new ArrayList<String>();
        l.add("any");
        return super.HandleCommand(l);
    }
}