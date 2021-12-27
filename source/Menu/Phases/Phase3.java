package bin;


import java.util.List;
import java.util.ArrayList;

import bin.Phase;
import bin.Phase1;

public class Phase3 extends Phase {
    public Phase3(){

    Messages =  new String[]{ "Registe-se no Sistema"," " };
    TipForInput = "Insira o seu nome";
    InputForStages = new String[]{ "Insira o seu encargo" };
    numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        
        String name = s.get(0);
        String cargo = s.get(1);

        //Se nao existir esse usuario na base de dados
        if (!cargo.equalsIgnoreCase("balcao")) {
            ChangeWarningMessage("So existe balcao " + " por favor insira algo de jeito\n");
            return null;
        }

         //Se foi feito com sucesso
         return new Phase1();

    }
}
