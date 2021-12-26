package bin.Menu.Phases;

import bin.*;
import bin.Pedido.Pedido;
import bin.Pedido.Plano;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.util.List;

public class Phase5 extends Phase {
    public Phase5(){

        Messages =  new String[]{ "Calcular tempo de reparação e orçamento"," " };
        TipForInput = "";
        InputForStages = new String[]{ "",
                "" };
        numberStages = InputForStages.length +1;
        CommandsMap.put("any", Phase1.class);
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        LocalDate dataH = LocalDate.now();

        for(LocalDate data : Main.allPedidos.keySet()){
            if(data.compareTo(dataH)<0){
                dataH = data;
            }
        }

        Pedido pdd = Main.allPedidos.get(dataH);
        Plano pll = new Plano(Plano.calculaHoras(),Plano.calculaCusto());
        pdd.setPl(pll);
        pdd.setOrcamento(Plano.calculaCusto());


        //Se foi feito com sucesso
        Phase p = new Phase1();
        return p;

    }
}