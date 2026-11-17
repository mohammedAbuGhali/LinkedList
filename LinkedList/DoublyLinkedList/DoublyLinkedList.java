package Chapter3.LinkedList.DoublyLinkedList;

class Node<T> {

    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList<T> {

    Node<T> head;
    int size = 0;

    public void InsertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void InsertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head; // نود مؤقت وماسك مؤشر الهيد عامل زي الهيد  
            while (temp.next != null) {// هيضل يلف عبال يلقى  الفارغ الغير موجود طبعاكل ما يلقى عنصر راح يخزنو في التيمب
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;

        }
        size++;
    }

    public void deleteFromBeginning() {
        if (head != null) {  // head  عبارة عنصر الاول 
            if (head.next != null) {  // head.next عبارة عن العنصر الثاني 
                head.next.prev = null;  // اصبح العنصر الثاني عبارة عن العنصر الاول 
                head = head.next; // اصبح العنصر الاول هو العنصر الثاني 
            }
            size--;
        } else {
            System.out.println("DoublyLinkedList Is Empty");
        }
    }

    public void deleteFromEnd() {
        if (head == null){
            System.out.println("DoublyLinkedList Is Empty");

        } else if (head.next == null){
            head = null;
            size--;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            size--;
        }

    }

    public boolean search(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void reverse() {
        Node<T> temp = null;
        Node<T> current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
    }

    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(" Data :" + temp.data);
            temp = temp.next;// يؤشر على العنصر الى بعدو  
        }
        System.out.println(" null");
    }

    public void displayreverse() {
        Node<T> temp = head;
        if (isEmpty()) {
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.println(" Data :" + temp.data);
            temp = temp.prev;
        }
        System.out.println(" Null");
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
