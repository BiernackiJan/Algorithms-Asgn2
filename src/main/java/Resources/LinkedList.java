package Resources;

public class LinkedList<E> {
    //public int numNodes;
    private Node head = null;

    private int nodes = 0;



    public void add(E data) {
        //creating a node head if not present yet
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node temp = new Node(data);
            Node current = head;
            //checking for a null pointer exception
            if (current != null) {
                //scrolling through list to add a node at the end
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                //setting last node to reference new node
                current.setNext(temp);
            }
        }
        addNodes();
    }

//    public void sortList()
//    {
//
//        // Node current will point to head
//        Node current = head, index = null;
//
//        int temp;
//
//        if (head == null) {
//            return;
//        }
//        else {
//            while (current != null) {
//                // Node index will point to node next to
//                // current
//                index = current.next;
//
//                while (index != null) {
//                    // If current node's data is greater
//                    // than index's node data, swap the data
//                    // between them
//                    char str = String.valueOf(current.data);
//                    int first = str[0];
//                    String str1 = String.valueOf(index);
//                    if (str > str1) {
//                        temp = current.data;
//                        current.data = index.data;
//                        index.data = temp;
//                    }
//
//                    index = index.next;
//                }
//                current = current.next;
//            }
//        }
//    }


    public Object get(int index)
    {
        // index must be 1 or higher
        if (index == 0)
            return head.getData();
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 1; i < index; i++) {
                if (current.getNext() == null)
                    return null;
                current = current.getNext();
            }
            return current.getData();
        }
        else {
            return null;
        }
    }

    public String listAll() {
        if (head == null) {
            return "There are no items";
        } else {
            Node temp = head;
            String allItems = "";
            while (temp != null) {
                allItems += temp.getData();
                temp = temp.next;
            }
            return allItems;
        }
    }

    public String listOne() {
        if (head == null) {
            return "";
        } else {
            Node temp = head;
            String singleItem = "";
            while (temp != null) {
                singleItem = String.valueOf(temp.getData());
                temp = temp.next;
            }
            return singleItem;
        }
    }

    public void delAll(){
        if(head!=null){
            head = null;
        }
    }

    public void deleteNode(int index) {
        if (head != null) {
            if (index == 0) {
                if (head.getNext() == null) {
                    head = null;
                } else {
                    head = head.getNext();
                }
            } else {
                index--;
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.getNext();
                }
                Node temp = current.getNext().getNext();
                if(temp != null) {
                    current.setNext(temp);
                }else {
                    current.setNext(null);
                }
            }
            nodes --;
        }
    }

    public void addNodes(){
        nodes ++;
    }

    public int numNodes(){
        return nodes;
    }

    public Node getHead(){
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }



    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", nodes=" + nodes +
                '}';
    }
}
