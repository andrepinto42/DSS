package bin.Menu.Phases;

import bin.Controller;
import bin.Pedido.Pedido;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Phase7 extends Phase {
    public Phase7(){

        Messages =  new String[]{ "Finalizar pedido"," " };
        TipForInput = "Insira o identificador do Pedido";
        InputForStages = new String[]{ "",
                "" };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String idPedido = s.get(0);

        Boolean temp = false;
        for(Pedido pdd : Controller.allPedidos.values()){
            if(pdd.getId().equals(idPedido)) {
            }
        }
        if(!temp){
            ChangeWarningMessage("O id inserido não corresponde a nenhum pedido\n");
            return null;
        }

        //Se foi feito com sucesso
        return new Phase1();
    }
}