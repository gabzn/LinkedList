public class DNode
{
    private int data;
    private DNode previous;
    private DNode next;

    public DNode()
    {
        this.previous = null;
        this.next = null;
    }

    public DNode(int data)
    {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public int getData()
    {
        return this.data;
    }

    public void setPrevious(DNode previous)
    {
        this.previous = previous;
    }

    public void setNext(DNode next)
    {
        this.next = next;
    }

    public DNode getPrevious()
    {
        return this.previous;
    }

    public DNode getNext()
    {
        return this.next;
    }
}
