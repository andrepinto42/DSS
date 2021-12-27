package bin.Menu.Phases;

import bin.Controller;
import bin.Pedido.Pedido;
import bin.Pedido.Plano;
import bin.Pedido.PlanoExpress;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.Pessoa;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Phase8 extends Phase {
    public Phase8() {

        Messages = new String[]{"Novo pedido EXPRESS", " "};
        TipForInput = "Insira o NIF do Cliente";
        InputForStages = new String[]{"Nome do Funcionario",
                "Nome do equipamento"};
        numberStages = InputForStages.length + 1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String NIF = s.get(0);
        String nomeFuncionario = s.get(1);
        String nomeEquipamento = s.get(2);

        if (!NIF.matches("[0-9]+")) {
            ChangeWarningMessage("Insira um NIF correto!\n");
            return null;
        }

        for (Pessoa p : Controller.allPessoas) {
            //Funcionario do balcao foi encontrado com sucesso
            if ((p.getNome().equals(nomeFuncionario)) && (p instanceof FuncionarioBalcao)) {

                int pddPorFinalizar = 0;
                for (Pedido pdd : Controller.allPedidos) {
                    if (LocalDate.now().compareTo(pdd.getFim()) < 0) {
                        pddPorFinalizar++;
                    }
                }
                //pedido express pode ser realizado?????
                if (pddPorFinalizar < 4) {

                    Pedido pdd = new Pedido();
                    pdd.setNIF(NIF);
                    pdd.setId(nomeEquipamento);
                    pdd.setDataRegisto(LocalDate.now());

                    Plano pll = new PlanoExpress();
                    pdd.setPl(pll);
                    pdd.setOrcamento(pll.getCusto()+10);//mao de obra + custo

                    Controller.allPedidos.add(pdd);

                    //Se foi feito com sucesso
                    return new Phase1();
                }else{

                    ChangeWarningMessage("O pedido EXPRESS não pode ser efetuado devido a sobrecarga de pedidos\n");
                    return null;
                }
            }else {
                //Funcionário nao existe na base de dados
                ChangeWarningMessage("O funcionario " + nomeFuncionario + " não existe no nosso sistema\n");
                return null;
            }
        }
    }
}