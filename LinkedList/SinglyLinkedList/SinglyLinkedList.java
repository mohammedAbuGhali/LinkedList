package Chapter3.LinkedList.SinglyLinkedList;

public class SinglyLinkedList<T> { // خلتها من النوع  العام عشان اقدر اخزن فيها انواع البيانات المختلفة 

    class Node<T> { // خليتها من النوع العام 

        T data;
        Node<T> next;

        /// لحتى الان جهزت اللبنة الاساسية
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }
    // ملاحظة : النود الاول في السينجل لينقيد ليست عبارة عن الهيد  
    int size; // بعرف من خلاله اكم عنصر موجود في المتتالية 
    Node<T> head; // الي يشير الى النود الاول 

    public SinglyLinkedList() { // لاحظ انه المتتالية اول ما انشأها بتكون فارغةتماما وقيمها فارغة 
        this.head = null;
        this.size = 0;
    }

    public void InsertAtBeginning(T data) {
        Node<T> newNode = new Node(data);
        // اساسا الهيد قيمته الاساسية نول فعدما عملت نود جديد خليته يؤشر على هذا الهيد فأصبح الهيد الجديد يؤشر على النود الجديد
        newNode.next = head; // يؤشر على الهيد الفارغة 
        head = newNode; // هناك هيد جديدة تؤشر على هاد النود الجديد 
        size++;

    }

    public void InsertAtEnd(T data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()) { // فارغة لايوجد عناصر 
            InsertAtBeginning(data);
        } else if (head.next == null) { // الحالة الثانيةتحوي عنصر والاخر الي بدي ااشر علية غير موجود   
            head.next = newNode;
            size++;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next; // امشي خطوة للامام 
            }
            current.next = newNode;
            size++;

        }
    }

    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("List Is Empty");
        } else {
            head = head.next;
            size--;
        }
    }

    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("List Is Empty .... ");
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            Node<T> current = head;
            while (current.next.next!= null) {
                current = current.next; // امشي خطوة للامام 
            }
            current.next = null;
            size--;
        }
    }

    public void display() { // دالة وظيفتها تلف على كل العناصر وتطبع البيانات الي فيها 
        Node<T> current = head;
        if (isEmpty()) {
            System.out.println("list is empty.....");
        } else {
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("");

        }
    }

    public boolean isEmpty() { //   فارغ ام ممتلئSinglyLinkedList كيف بدي اعرف انو 
        return head == null;
    }

    public int size() {//SinglyLinkedList كيف بدي اعرف اكم عنصر موجود في المتتالية 
        return this.size;
    }

    public void clear() { //SinglyLinkedList في حال افرغ 
        this.head = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> stdName = new SinglyLinkedList();
        stdName.InsertAtBeginning("Huda");
        stdName.InsertAtBeginning("Mohammed");
        stdName.InsertAtEnd("Fadi");
        stdName.InsertAtEnd("Baker");
        System.out.println("List is Empty : " + stdName.isEmpty());
        System.out.println("The Size Of List : " + stdName.size());

        stdName.display();

        stdName.deleteFromBeginning();
        stdName.display();
        stdName.deleteFromEnd();
        stdName.display();

    }

}
