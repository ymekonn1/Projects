import patterns;
import tokens;
import java.util.ArrayList;

public class Regexp{

    private String pattern;

    public Regexp(String pattern) {
        this.pattern = pattern;
    }

    public Pattern AST(){
        Pattern e = new Empty();

        return e;
    }
    public char[] alphabet(){
        ArrayList<Character> delta = new ArrayList<>();
        
        return delta.toArray();
    }
    

}