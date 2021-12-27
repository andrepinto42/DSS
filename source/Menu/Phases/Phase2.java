package bin;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import bin.Phase;
import bin.Phase1;
import bin.Pessoas.Cliente;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.FuncionarioReparacao;
import bin.Pessoas.Gestor;
import bin.Pessoas.Pessoa;
import bin.Controller;
import bin.Pessoas.ReadLoadPessoas;

public class Phase2 extends Phase{
    
    public Phase2()
    {
        Messages =  new String[]{
            "Autenticação do Funcionario",
            "",
        };
        TipForInput = "Username";

        InputForStages = new String[]{
            "Tipo de Empregado",
            "Password",
        };
        numberStages = InputForStages.length +1;
    }



    @Override
    public Phase HandleCommand(List<String> s) {
        
        String username = s.get(0);
        String tipoFuncionario = s.get(1);
        String password = s.get(2);

        if (!ReadLoadPessoas.stringPessoas.containsKey(tipoFuncionario) )
        {
            String temp = "Esse tipo de Funcionário não existe, só temos ";
            for (String string : ReadLoadPessoas.stringPessoas.keySet()) {
                temp += string + " ";
            }
            temp += "\n";
            ChangeWarningMessage(temp);
            return null;
        }
 
        for (Pessoa p : Controller.allPessoas) {
            //Found the person we were looking after
            if (p.getClass().equals(ReadLoadPessoas.stringPessoas.get(tipoFuncionario)) && 
                p.getNome().equals(username))
            {
                if(!p.getPassword().equals(password))
                { 
                    ChangeWarningMessage("O usuario "+ username +  " existe\nmas a password é incorreta :(\n");
                    return null;
                }

                Phase1.currentPessoa = p;
                return new Phase1();
            }
        } 
        //Se nao existir esse usuario na base de dados
        ChangeWarningMessage("Não existe o usuário "+  username + " por favor insira algo de jeito\n");
        return null;
    }
}
