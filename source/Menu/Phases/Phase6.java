package bin.Menu.Phases;

import bin.Main;
import bin.Pedido.Pedido;
import bin.Pedido.Plano;
import bin.Pessoas.Cliente;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.Pessoa;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Phase6 extends Phase {
    public Phase6(){

        Messages =  new String[]{ "Iniciar reparação"," " };
        TipForInput = "Insira o identificador do Pedido";
        InputForStages = new String[]{ "",
                "" };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String idPedido = s.get(0);
        String NIFcliente = s.get(1);

        Boolean temp = false;
        for(Pedido pdd : Controller.allPedidos.values()){
            if(pdd.getId().equals(idPedido)) {
                temp = true;

                pdd.setInicio(LocalDate.now());

                long days = (long)(pdd.getPl().getTotalHoras())/24;

                pdd.setFim(LocalDate.now().plus(days, ChronoUnit.DAYS));
            }
        }
        if(!temp){
            ChangeWarningMessage("O id inserido não corresponde a nenhum pedido\n");
            return null;
        }

        //Se foi feito com sucesso
        Phase p = new Phase1();
        return p;
    }
}