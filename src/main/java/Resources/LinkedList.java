package Resources;

public class LinkedList<E> {
    //public int numNodes;
    private Node head = null;

    private int nodes = 0;


    public void add(E data) {
        //creating a node head if not present yet
        if (head == null) {
            head = new Node(data);
        } else {
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


    public Object get(int index) {
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
        } else {
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
                temp = temp.getNext();
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

    public void delAll() {
        if (head != null) {
            head = null;
            nodes = 0;
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
                if (temp != null) {
                    current.setNext(temp);
                } else {
                    current.setNext(null);
                }
            }
            nodes--;
        }
    }

    public void add(int index, E data) {
        if (head != null) {
            if (index == 0) {//TODO add to front
                Node temp = new Node(data);
                temp.setNext(head);
                head = temp;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                Node temp = new Node(data);
                temp.setNext(current.getNext());
                current.setNext(temp);
            }
        }
        nodes++;
    }

    public void addNodes() {
        nodes++;
    }

    public int numNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public boolean isEmpty(){
        return numNodes() == 0;
    }

    public void set(int index, E data) {
        if (head != null) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.setData(data);
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", nodes=" + nodes +
                '}';
    }
}
