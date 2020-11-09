public class SinglyLinkedList
{
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(size == 0)
        {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(size == 0)
        {
            head = tail = newNode;
            size++;
            return;
        }

        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void addBefore(int data,int before)
    {
        Node beforeNode = findNode(before);
        if(beforeNode == null)
        {
            addLast(data);
            return;
        }
        if(beforeNode == head)
        {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node tempHead = head;
        while(tempHead.getNext().getData() != beforeNode.getData())
        {
            tempHead = tempHead.getNext();
        }
        newNode.setNext(beforeNode);
        tempHead.setNext(newNode);
        size++;
    }

    public void addAfter(int data,int after)
    {
        Node afterNode = findNode(after);
        if(afterNode == null || afterNode == tail)
        {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.setNext(afterNode.getNext());
        afterNode.setNext(newNode);
        size++;
    }

//    public void addAfter(int data, int after){
//        Node afterNode = findNode(after);
//
//        if(afterNode == null) {
//            System.out.println("After node does not exist, defaulting insertion at rear");
//            addLast(data);
//            return;
//        }
//
//        Node newNode = new Node(data);
//        newNode.setNext(afterNode.getNext());
//        afterNode.setNext(newNode);
//        size++;
//    }

    public void removeHead()
    {
        if(size == 0)
        {
            System.out.println("Nothing in the list to be removed.");
            return;
        }
        if (size == 1)
        {
            head = tail = null;
            size--;
            return;
        }

        head = head.getNext();
        size--;
    }

    public int get(int index) throws Exception
    {
        if((size == 0) || (size <= index) || (index < 0))
        {
            throw new IndexOutOfBoundsException("Invalid index.");
        }

        Node targetNode = head;
        int counter = 0;
        while(counter != index)
        {
            targetNode = targetNode.getNext();
            counter++;
        }
        return targetNode.getData();
    }

    public boolean contains(int data)
    {
        return findNode(data) != null;
    }

    private Node findNode(int data)
    {
        Node targetNode = head;

        //Precautional check to see if the node is empty first, then see if the node contains the looking-for data.
        while(targetNode != null && targetNode.getData() != data)
        {
            targetNode = targetNode.getNext();
        }

        return targetNode;
    }

    public int getSize()
    {
        return this.size;
    }

    public void printList()
    {
        if(this.size == 0)
        {
            System.out.println("Nothing in the list.");
            return;
        }

        Node tempHead = head;
        while(tempHead != null)
        {
            System.out.print(tempHead.getData() + " ");
            tempHead = tempHead.getNext();
        }
        System.out.println();
    }
}
