package bin.Menu.Phases;

import bin.Phase;
import bin.Phase1;

import java.util.ArrayList;
import java.util.List;

public class Phase4 extends Phase {
    public Phase4(){

        Messages =  new String[]{ "Iniciar pedido"," " };
        TipForInput = "Insira o seu NIF";
        InputForStages = new String[]{ "" };
        numberStages = InputForStages.length +1;
        CommandsMap.put("any", Phase1.class);
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String NIF = s.get(0);
        String id = s.get(1);

        //Se nao existir esse usuario na base de dados
        if (!cargo.equalsIgnoreCase("balcao")) {
            ChangeWarningMessage("So existe balcao " + " por favor insira algo de jeito\n");
            return null;
        }

        List<String> l =  new ArrayList<String>();
        l.add("any");
        return super.HandleCommand(l);
    }