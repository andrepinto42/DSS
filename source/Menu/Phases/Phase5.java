package bin;

import bin.*;
import bin.Pedido.Pedido;
import bin.Pedido.Plano;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Phase5 extends Phase {
    public Phase5(){

        Messages =  new String[]{ "Definir tempo de reparação e custo de peças"," " };
        TipForInput = "Insira o tempo de reparação em horas";
        InputForStages = new String[]{ "Insira o custo total das peças",
                "" };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        String t = s.get(0);
        String c = s.get(1);

        int tempo = Integer.parseInt(t);
        int custo = Integer.parseInt(c);

        //buscar o pedido mais antigo
        /*for(LocalDate data : Controller.allPedidos.keySet()){
            if(data.compareTo(dataH)<0){
                dataH = data;
            }
        }*/
        if (!t.matches("[0-9]+")){
            ChangeWarningMessage("ERRO!: Insira um número de horas!\n");
            return null;
        }else {if (!c.matches("[0-9]+")){
                ChangeWarningMessage("Insira o valor do custo total das peças!\n");
                return null;
            }
        }

        Controller.allPedidos.sort(Comparator.comparing(Pedido::getDataRegisto));
        Pedido pdd = Controller.allPedidos.get(0);

        Plano pll = new Plano();
        pll.setTotalHoras(tempo);
        pll.setCusto(custo);
        pdd.setPl(pll);
        pdd.setOrcamento(pll.getCusto()+10);//custo das peças + mão de obra


        //Se foi feito com sucesso
        return new Phase1();


    }
}