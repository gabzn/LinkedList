public class Node
{
    private int data;
    private Node next;

    public Node()
    {
        this.next = null;
    }

    public Node(int data)
    {
        this.data = data;
        this.next = next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public Node getNext()
    {
        return this.next;
    }

    public int getData()
    {
        return this.data;
    }
}
