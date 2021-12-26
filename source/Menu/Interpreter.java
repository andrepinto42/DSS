package bin;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bin.ShowMenu;
import bin.Phase;
import bin.Phase1;
import bin.Phase2;
import bin.Phase4;

public class Interpreter {
    Scanner sc;
    boolean alive = true;
    List<String> CommandsByUser = new ArrayList<String>();
    public Interpreter()
    {
        sc = new Scanner(System.in);
    }
    public void Initialize()
    {
        Phase phaseNow = new Phase4();
        
        String comandoInput = "";
        while(alive)
        {
            //Por enquanto deixar em comentario para ver o programa a dar debug
            // ShowMenu.ClearScreen();

            comandoInput = phaseNow.Show(sc);
            if (comandoInput.equalsIgnoreCase("quit")) break;

            CommandsByUser.add(comandoInput);
            
            for (int i = 0; i < phaseNow.numberStages-1 ; i++) {
               String comand =  phaseNow.Next(sc, i);
               CommandsByUser.add(comand);
            }
            
            Phase newPhase = phaseNow.HandleCommand(CommandsByUser);
            System.out.println(CommandsByUser +" \n\n");
            
            CommandsByUser.clear();

            if (newPhase == null) continue;
            phaseNow = newPhase;

        }
        sc.close();
    }
}
