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
                prevNode = nextNode;
                cursor++;
                nextNode = nextNode.next;
                return prevNode.element;
            }

            public void remove() {

                if (prevNode == null)
                    throw new IllegalStateException();

                dLList.removeNode(prevNode);
                if (prevNode == nextNode) {
                    nextNode = nextNode.next;
                } else {
                    cursor--;
                }
                prevNode = null;
            }

            public boolean hasPrevious() {
                return cursor > 0;
            }

            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                nextNode = prevNode = nextNode == null ? dLList.last : nextNode.prev;
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
                if (prevNode == null)
                    throw new IllegalStateException();
                prevNode.element = e;
            }

            public void add(E e) {
                if (nextNode == null) {
                    dLList.linkedLast(e);
                }else {
                    dLList.linkedbBefore(nextNode,e);
                }
                cursor ++;
                prevNode = null;
            }
        }
        ;
        return new LinkedListIterator<E>(index);
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return nodeOf(index).element;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = nodeOf(index).element;
        nodeOf(index).element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        checkAddIndex(index);
        if (index == size || size == 0) {
            linkedLast(element);
        } else {
            linkedbBefore(nodeOf(index), element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(size, c);
    }

    public void addFirst(E e) {
        add(0, e);
    }


    @Override
    public E remove(int index) {
        checkRemoveIndex(index);
        Node<E> oldNole = nodeOf(index);
        return removeNode(oldNole);
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

    private void checkRemoveIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new NoSuchElementException();
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

    private void linkedLast(E element) {
        if (size == 0) {
            first = last = new Node<E>(element);
        } else {
            Node node = new Node<E>(element, null, last);
            last.next = node;
            last = node;
        }
        size++;
    }

    private void linkedbBefore(Node<E> node, E newelement) {
        if (node == null) {
            throw new NoSuchElementException();
        }
        final Node<E> pred = node.prev;
        final Node newNode = new Node<E>(newelement, node, pred);
        node.prev = newNode;
        if (node == first) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private E removeNode(Node<E> node) {

        final E element = node.element;
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;

        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }

        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }

        node.element = null;
        size--;

//        if(size == 1){
//            first = last = null;
//        }else if(node == first){
//            node.next.prev = null;
//            first = node.next;
//            node.next = null;
//        }else if(node == last){
//            node.prev.next = null;
//            last = node.prev;
//            node.prev = null;
//        }else{
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//            node.prev = node.next = null;
//        }
        return element;
    }


}
