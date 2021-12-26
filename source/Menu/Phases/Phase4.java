package bin;

import bin.Pedido.Pedido;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.Pessoa;

import java.time.LocalDate;
import java.util.List;

public class Phase4 extends bin.Phase {
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

        if (!NIF.matches("[0-9]+")){
            ChangeWarningMessage("Insira um NIF correto!\n");
            return null;
        }

        for(Pessoa p : Main.allPessoas){
            if(!(p instanceof FuncionarioBalcao) || (!p.getNome().equals(nomeFuncionario))){
                ChangeWarningMessage("O funcionario " + nomeFuncionario + "não existe no nosso sistema\n");
                return null;
            }
        }

        Pedido pdd = new Pedido();
        pdd.setId(nomeEquipamento);
        Main.allPedidos.put(LocalDate.now(),pdd);



        //Se foi feito com sucesso
        Phase p = new Phase1();
        return p;

    }


}