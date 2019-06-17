import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E> {
    private int size = 0;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.element = element;
        }

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
            private Node<E> prevNode;
            private int lastRet = -1;
            private DoubleLinkedList<E> dLList = (DoubleLinkedList<E>) DoubleLinkedList.this;

            public LinkedListIterator(int index) {
                this.cursor = index;
                this.nextNode = (dLList.size == 0) ? null : dLList.nodeOf(cursor);
            }

            public boolean hasNext() {
                return cursor < dLList.size;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> l = nextNode;
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
                prevNode = nextNode == null ? dLList.last : nextNode.prev;
                nextNode = prevNode;
                cursor--;
                return prevNode.element;
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
        }
        ;

        return null;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return nodeOf(index).element;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        return super.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        checkAddIndex(index);
        if (size == 0) {
            first = last = new Node<E>(element);
        }
        else if (index == 0) {
            Node<E> oldFirst = first;
            first = new Node<E>(element, oldFirst, null);
            oldFirst.prev = first;
        }
        else if (index == size) {
            Node<E> oldlast = last;
            last = new Node<E>(element, null, oldlast);
            oldlast.next = last;
        }
        else{
            Node<E> newNode = new Node<E>(element);
            Node<E> nextOfnewNode = nodeOf(index);
            newNode.next = nextOfnewNode;
            newNode.prev = nextOfnewNode.prev;
            nextOfnewNode.prev = newNode;
            nextOfnewNode.prev.next = newNode;
        }
        size++;
    }

    public void addFirst(E e) {
        add(0,e);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> oldNole = nodeOf(index);


        return oldNole.element;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
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
