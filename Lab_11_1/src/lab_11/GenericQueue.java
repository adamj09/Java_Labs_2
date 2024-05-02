package lab_11;

// Class provided by M.D Istiaque Shahriar
public class GenericQueue<E> {
  private java.util.LinkedList<E> list = new java.util.LinkedList<E>();

  public void enqueue(E e) {
    list.addLast(e);
  }

  public E dequeue() {
    return list.removeFirst();
  }

  public int getSize() {
    return list.size();
  }

  // Method added by Adam Johnston
  public int search(E e) {
    if(!list.contains(e)) {
      return -1;
    }
    return list.indexOf(e);
  }

  @Override
  public String toString() {
    return "Queue: " + list.toString();
  }
}
