package bin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public abstract class Phase {
    protected  String[] Messages;
    protected  String TipForInput;
    public  int numberStages = 1;
    protected  String[] InputForStages;
    protected String warningMessageTop = "";
    protected HashMap<String,Class<? extends Phase>> CommandsMap = new HashMap<String,Class<? extends Phase>>();

    public String Show(Scanner sc)
    {
        if (!warningMessageTop.isEmpty())
            System.out.print(warningMessageTop);
        
        ShowMenu.Print(Messages,TipForInput);
        System.out.print("$:");  
        return sc.nextLine();
    }

    public String Next(Scanner sc,int i)
    {
        System.out.print(InputForStages[i] + ":");            
        return sc.nextLine();
    }

    public Phase HandleCommand(List<String> s)
    {   
        if (!CommandsMap.containsKey(s.get(0))) return null;

        Phase p= null;
        try {
            p = CommandsMap.get(s.get(0)).getDeclaredConstructor().newInstance();
            
        } catch (Exception ignored) { }     
        return p;
    }

    protected void ChangeWarningMessage(String s) {
        warningMessageTop = s;
    }
  
}
