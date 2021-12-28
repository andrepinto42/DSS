package bin.Menu.Phases;

import bin.Controller;
import bin.Pedido.Pedido;
import bin.Pessoas.Cliente;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.FuncionarioReparacao;
import bin.Pessoas.Pessoa;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Phase9 extends Phase {
    public Phase9(){

        Messages =  new String[]{ "Verificar centro"," " };
        TipForInput = "";
        InputForStages = new String[]{"" };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        for(Pessoa p : Controller.allPessoas){
            if(p instanceof Cliente) {
                warning += p.getNome()
            }else if(p instanceof FuncionarioBalcao){

            }else if(p instanceof FuncionarioReparacao){

            }else {

            }

        //Se foi feito com sucesso
        return new Phase1();

    }
}