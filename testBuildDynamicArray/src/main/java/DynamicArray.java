import java.util.ArrayList;
import java.util.Arrays;

public class DynamicArray<E> {
    /*Implement a simple dynamic array container*/
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    // Ensure the Capacity of the array no less than minCapacity
    public void ensureCapacity(int minCapacity) {
        int oldLength = elementData.length;
        if (oldLength >= minCapacity) {
            return;
        }
        int newCapacity = oldLength + (oldLength >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public void add(int index, E e) {
        checkIndex(index);
        ensureCapacity(size + 1);
        int nummoved = size - index;
        System.arraycopy(elementData, index, elementData, index+1, nummoved);
        elementData[index]=e;
        size++;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = get(index);
        elementData[index] = element;
        return oldElement;
    }

    public E remove(int index) {
        checkIndex(index);
        E oldElement = (E) elementData[index];
        int nummoved = size - index - 1;
        if (nummoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, nummoved);
        }

        elementData[--size] = null;
        return oldElement;
    }

    private void checkIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("out of this Arrays contains!");
        }
    }
}
