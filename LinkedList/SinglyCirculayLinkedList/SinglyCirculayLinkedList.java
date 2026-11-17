package Chapter3.LinkedList.SinglyCirculayLinkedList;

class CircularNode<T> {

    T data;
    CircularNode<T> next;

    public CircularNode(T data) {
        this.data = data;
        this.next = null;
    }

}

public class SinglyCirculayLinkedList<T> {

    private CircularNode<T> head;

    public void InsertAtBeginning(T data) {
        CircularNode<T> newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            CircularNode<T> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void InsertAtEnd(T data) {
        CircularNode<T> newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            CircularNode<T> temp = head;
            while (temp.next != head) { // في حال هناك اكثر من عنصر 
                temp = temp.next;  // عشان يمشي ع غيرو 
            }
            temp.next = newNode; // يؤشرون على بعضهم البعض
            newNode.next = head;// يؤشرون على بعضهم البعض

        }
    }

    public void deleteFromBeginning() {
        if (head != null) {
            if (head.next == head) {
                head = null;
              
                ///head حذف العنصر 
            }else{
                 CircularNode<T> temp = head;
                while (temp.next != head) { // عشان اصل لاخر عنصر 
                    temp = temp.next; // ضل امشي لما تصل للعنصر الاخير 
                }
                head = head.next;
                temp.next = head; // المؤشر الاخير يؤشر على العنصر الاول

            }

        } else {
            System.out.println(" List IS Empty ..! ");
        }
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println(" List Is Empty");
        } else {
            if (head.next == head) {
                head = null;
            } else {
                CircularNode<T> temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }

                CircularNode<T> prev = head;
                while (prev.next != temp) {
                    prev = prev.next;
                }
                prev.next = head;
            }
        }
    }

    public void display() {
        if (head != null) {
            CircularNode<T> temp = head;
            do {
                System.out.println("Data :" + temp.data);
                temp = temp.next;
            } while (temp != head);
            System.out.println("Back To Head...");
        } else {
            System.out.println(" List IS Empty ..! ");
        }

    }

    public static void main(String[] args) {
        SinglyCirculayLinkedList<String> names = new SinglyCirculayLinkedList();
        names.InsertAtBeginning("Usefull.pro");
        names.InsertAtBeginning("Is");
        names.InsertAtBeginning("Prai");
        names.InsertAtEnd("Please Be active..");
        names.deleteFromBeginning();
        names.deleteFromBeginning();
        names.deleteFromEnd();
        names.display();

    }
}
