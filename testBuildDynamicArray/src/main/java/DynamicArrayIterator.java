import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayIterator<E> implements Iterator<E> {
    private DynamicArray<E> darr;
    private int cursor;
    private int lastRet = -1;
    public DynamicArrayIterator(DynamicArray<E> darr){
        this.darr = darr;
    }

    @Override
    public boolean hasNext() {
        return cursor != darr.size();
    }

    @Override
    public E next() {
        if(cursor >= darr.size()){
            throw new NoSuchElementException();
        }
        lastRet = cursor;
        cursor++;
        return darr.get(lastRet);
    }

    @Override
    public void remove() {
        darr.remove(lastRet);
        cursor = lastRet;
        lastRet = -1;
    }
}
