import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E> {
    private int size = 0;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> first;
    private Node<E> last;

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(Collection<? extends E> c) {
        this();
        addAll(0, c);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        class LinkedListIterator<E> implements ListIterator<E> {
            private int cursor;
            private Node<E> nextNode;
            private int lastRet = -1;
            private DoubleLinkedList<E> dLList = (DoubleLinkedList<E>) DoubleLinkedList.this;

            public LinkedListIterator(int index) {
                this.cursor = index;
                this.nextNode = ( dLList.size==0 )? null : dLList.nodeOf(cursor);
            }

            public boolean hasNext() {
                return cursor < dLList.size;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> l=  nextNode;
                lastRet = cursor;
                cursor++;
                nextNode = nextNode.next;
                return l.element;
            }

            public void remove() {

            }

            public boolean hasPrevious() {
                return cursor > 0;
            }

            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                nextNode = nextNode.prev;
                cursor --;
                return nextNode.element;
            }

            public int nextIndex() {
                return cursor;
            }

            public int previousIndex() {
                return cursor - 1;
            }


            public void set(E e) {

            }

            public void add(E e) {

            }
        } ;

        return null;
    }

    @Override
    public E get(int index) {
        checkindex(index);
        return nodeOf(index).element;
    }

    @Override
    public E set(int index, E element) {
        return super.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        super.add(index, element);
    }


    @Override
    public int size() {
        return size;
    }

    private void checkindex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Node<E> nodeOf(int index) {
        if (index < (size >> 1)) {
            int i = 0;
            Node<E> node = first;
            while (i != index) {
                node = node.next;
                i++;
            }
            return node;
        } else {
            int i = size - 1;
            Node<E> node = last;
            while (i != index) {
                node = node.prev;
                i--;
            }
            return node;
        }
    }

}
