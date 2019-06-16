import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;

public class MyList<E> extends AbstractList<E> {
    private DynamicArray<E> darr;

    public MyList() {
        darr = new DynamicArray<E>();
    }

    public MyList(Collection<? extends E> c) {
        this();
        super.addAll(c);
    }

    @Override
    public E get(int index) {
        return darr.get(index);
    }

    @Override
    public int size() {
        return darr.size();
    }

    @Override
    public void add(int index, E element) {
        darr.add(index,element);
    }

    @Override
    public boolean add(E e) {
        darr.add(e);
        return true;
    }

    @Override
    public E set(int index, E element) {
        return darr.set(index,element);
    }

    @Override
    public E remove(int index) {
        return darr.remove(index);
    }
}
