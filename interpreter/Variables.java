public class Variables {
    
    private char type;
    private int intVal;
    private String stringval;

    public Variables (char type, int intVal, String stringVal ) {
        this.type = type;
        this.intVal = intVal;
        this.stringval = stringVal;
    }

    public char getType() {
        return this.type;
    }

    public int getInt() {
        return this.intVal;
    }

    public String getString() {
        return this.stringval;
    }
}