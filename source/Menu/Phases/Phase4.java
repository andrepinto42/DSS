package bin;

import bin.Phase;
import bin.Phase1;

import java.util.ArrayList;
import java.util.List;

public class Phase4 extends Phase {
    public Phase4(){

        Messages =  new String[]{ "Iniciar pedido"," " };
        TipForInput = "Insira o NIF do Cliente";
        InputForStages = new String[]{ "Nome do Funcionario",
        "Nome do equipamento" };
        numberStages = InputForStages.length +1;
        CommandsMap.put("any", Phase1.class);
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String NIF = s.get(0);
        String nomeFuncionario = s.get(1);
        String nomeEquipamento = s.get(2);

        //Se nao existir esse usuario na base de dados
        if (!NIF.equalsIgnoreCase("balcao")) {
            ChangeWarningMessage("So existe balcao " + " por favor insira algo de jeito\n");
            return null;
        }

        //Se foi feito com sucesso
        Phase p = new Phase1();
        return p;

    }
}