public class Clothes {
    Size size;
    String id;
    public Clothes(String id,Size size){
        this.id = id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes: [ID:"+id+",SIZE:"+size.name()+"]";
    }
}
