package datastruct.adt;

public class Counter {
    String name= null;
    Integer value = 0;

    public Counter(String name){
        this.name = name;
    }

    public void increment () {
        value++;
    }

    public int getCurrentValue(){
        return value;
    }

    @Override
    public String toString(){
        return name +". "  +value;
    }
}
