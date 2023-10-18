package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
        size = 0;
        header = trailer = null;
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullPointerException {
        ListNode node = new ListNode();
        if (isEmpty()){
            header = node;
        }else{
            trailer.setNext(node);
        }

        trailer = node;
        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        T result = header.getElement();
        header = header.getNext();
        size--;

        if (isEmpty()) {
            trailer = null;
        }
        return result;
    }

    @Override
    public T front() throws QueueEmptyException {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(header == trailer){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        header = trailer = null;
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode() {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
    }
}
