class LinkedList {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head = null;
    public LinkedList() {

    }

    public int get(int index) {
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) return -1;
        return current.data;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node tempHead = head;
        head = newNode;
        newNode.next = tempHead;
    }

    public void insertTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val);
    }

    public boolean remove(int index) {
        if (head == null) return false;
        if (index == 0) {
            head = head.next;
            return true;
        }
        Node current = head;
        Node previous = null;
        int currentNodeIndex = 0;
        while (current != null) {
            if (currentNodeIndex == index) {
                previous.next = current.next;
                return true;
            }
            currentNodeIndex++;
            previous = current;
            current = current.next;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> listValue = new ArrayList<>();
        Node current = head;
        while (current != null) {
            listValue.add(current.data);
            current = current.next;
        }
        return listValue;
    }
}
