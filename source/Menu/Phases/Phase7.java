package bin;

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
        InputForStages = new String[]{ "Insira o NIF do cliente",
                "" };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String idPedido = s.get(0);
        String NIF = s.get(1);

        for(Pedido pdd : Controller.allPedidos){
            if(pdd.getId().equals(idPedido) && pdd.getNIF().equals(NIF)) {

                if(LocalDate.now().equals(pdd.getFim())){

                    Controller.pedidosFinalizados.add(pdd);
                    Controller.allPedidos.remove(pdd);

                    return new Phase1();


                }else{
                    ChangeWarningMessage("O pedido ainda não está pronto!\n");
                    return null;
                }
            }
        }
        ChangeWarningMessage("O id ou NIF inserido não corresponde a nenhum pedido\n");
        return null;
    }
}
