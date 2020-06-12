public class Union extends Patten{

    public Pattern left;
    public Pattern right;
    
    public Union(Pattern left, Pattern right){
        this.left = left;
        this.right = right;
    }

}