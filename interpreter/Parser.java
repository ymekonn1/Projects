import java.io.*;
import java.util.HashMap;



public class Parser {

    HashMap<String,Variables> vars;
    FileReader fr;

    public Parser(FileReader fr) {
        this.fr = fr;
        this.vars = new HashMap<String,Variables>();
    }

    public void setVars()  {
        BufferedReader input = new BufferedReader(this.fr);
        try{
            while(input.ready()) {
                String line = input.readLine();

                if (line.matches("^Variable ")) {

                    line = line.replaceFirst("^Variable", "");
                    String [] ele = line.split("\\s");

                    if (ele[0].equals("Integer")) {

                        Variables toAdd = new Variables('I',Integer.parseInt(ele[3]),"");
                        this.vars.put(ele[1], toAdd);

                    } else if (ele[0].equals("String")) {

                        Variables toAdd = new Variables('S',0,ele[3]);
                        this.vars.put(ele[1], toAdd);
                    }
                }
            }
            input.close();
        } catch(IOException e) {
            System.out.println("error at setVars");
        }
    }
    
    public HashMap<String,Variables> getVars() {
        return this.vars;
    }
}