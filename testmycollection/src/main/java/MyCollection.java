import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MyCollection<E> extends AbstractCollection<E> {
    private DynamicArray<E> darr;

    public MyCollection(){
        darr = new DynamicArray<E>();
    }
    public MyCollection(Collection<? extends E> c){
        this();
        super.addAll(c);
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator<E>(darr);
    }

    @Override
    public int size() {
        return darr.size();
    }

    @Override
    public boolean add(E e) {
        darr.add(e);
        return true;
    }

    public E get(int index){
        return darr.get(index);
    }
}
