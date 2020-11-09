public class DoublyLinkedList
{
    private DNode head;
    private DNode tail;
    private int size;

    public DoublyLinkedList()
    {
        head = new DNode();
        tail = new DNode();
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }

    public void addFirst(int data)
    {
        DNode newNode = new DNode(data);
        addAfter(newNode,head);
        size++;
    }

    //  ^^^helper method for addFirst^^^
    private void addAfter(DNode newNode,DNode after)
    {
        after.getNext().setPrevious(newNode);
        newNode.setNext(after.getNext());
        after.setNext(newNode);
        newNode.setPrevious(after);
    }

    public void addLast(int data)
    {
        DNode newNode = new DNode(data);
        addBefore(newNode,tail);
        size++;
    }

    //  ^^^helper method for addLast^^^
    private void addBefore(DNode newNode,DNode before)
    {
        newNode.setNext(before);
        newNode.setPrevious(before.getPrevious());
        before.getPrevious().setNext(newNode);
        before.setPrevious(newNode);
    }

    public void addBefore(int data,int before)
    {
        DNode targetNode = findNode(before);
        DNode newNode = new DNode(data);
        if(size == 0 || targetNode == tail)
        {
            System.out.println("Before node does not exist. Default to the last.");
            addBefore(newNode,tail);
            size++;
            return;
        }

        addBefore(newNode,targetNode);
        size++;
    }

    public void addAfter(int data,int after)
    {
        DNode newNode = new DNode(data);
        DNode afterNode = findNode(after);
        if(afterNode == tail)
        {
            System.out.println("After node does not exist. Default to the last.");
            addBefore(newNode,tail);
            size++;
            return;
        }

        addAfter(newNode,afterNode);
        size++;
    }

    private DNode findNode(int target)
    {
        DNode targetNode = head.getNext();

        while(targetNode != tail && targetNode.getData() != target)
        {
            targetNode = targetNode.getNext();
        }

        return targetNode;
    }

    public boolean contains(int target)
    {
        return (findNode(target) != tail);
    }

    public int get(int index) throws Exception
    {
        if((size == 0 && index == 0) || (index >= size) || (index < 0))
            throw new IndexOutOfBoundsException("Invalid index number.");

        int half = size/2;
        if(index<half)
        {
            DNode tempHead = head;
            for(int i=0;i<=index;i++)
            {
                tempHead = tempHead.getNext();
            }
            return tempHead.getData();
        }
        else
        {
            DNode tempTail = tail;
            for(int i=size-1;i>=index;i--)
            {
                tempTail = tempTail.getPrevious();
            }
            return tempTail.getData();
        }
    }

    public void removeHead()
    {
        if(size == 0)
        {
            System.out.println("There's nothing in the list.");
            return;
        }

        head.getNext().getNext().setPrevious(head);
        head.setNext(head.getNext().getNext());
        size--;
    }

    public void printList()
    {
        if(size == 0)
        {
            System.out.println("Nothing in the list.");
            return;
        }

        DNode temp = head.getNext();
        while(temp != tail)
        {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }
}
