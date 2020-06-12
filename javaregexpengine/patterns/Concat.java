public class Concat extends Pattern {
    public Pattern left;
    public Pattern right;

    public Concat(Pattern left, Pattern right){
        this.left = left;
        this.right = right;
    }
}