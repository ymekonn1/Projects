import java.util.*;
import java.io.*;

public class Runner{
    public static void main (String [] args) {
        try{
            FileReader fr = new FileReader("/mnt/c/Users/yonas/Desktop/CMSC/Personal-Projects/interpreter/test.txt");
            Parser p = new Parser(fr);
            p.setVars();
            HashMap<String,Variables> test = p.getVars();
            for (String s : test.keySet()) {
                Variables curr = test.get(s);
                System.out.println("Name: " + s + 
                " Type: " + curr.getType()+
                " IValue: " + curr.getInt() + 
                " Svalue: " + curr.getString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found!!");
        }
    }

}