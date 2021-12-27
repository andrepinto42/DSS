package bin;

import bin.Main;
import bin.Pedido.Pedido;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.Pessoa;
import bin.Controller;

import java.time.LocalDate;
import java.util.List;

public class Phase4 extends Phase {
    public Phase4(){

        Messages =  new String[]{ "Novo pedido"," " };
        TipForInput = "Insira o NIF do Cliente";
        InputForStages = new String[]{ "Nome do Funcionario",
        "Nome do equipamento" };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String NIF = s.get(0);
        String nomeFuncionario = s.get(1);
        String nomeEquipamento = s.get(2);

        if (!NIF.matches("[0-9]+")){
            ChangeWarningMessage("Insira um NIF correto!\n");
            return null;
        }

        for(Pessoa p : Controller.allPessoas){
            //Funcionario do balcao foi encontrado com sucesso
            if( (p.getNome().equals(nomeFuncionario)) && (p instanceof FuncionarioBalcao) )
            {
                Pedido pdd = new Pedido();
                pdd.setId(nomeEquipamento);
                Controller.allPedidos.put(LocalDate.now(),pdd);

        
                //Se foi feito com sucesso
                return new Phase1();

            }
        }

        //Funcionário nao existe na base de dados
        ChangeWarningMessage("O funcionario " + nomeFuncionario + " não existe no nosso sistema\n");
        return null;
    }


}