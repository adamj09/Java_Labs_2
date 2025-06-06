package lab_11;

// Class provided by M.D. Istiaque Shahriar
public class GenericStack<E> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();

  public int getSize() {
    return list.size();
  }

  public E peek() {
    return list.get(getSize() - 1);
  }

  public void push(E o) {
    list.add(o);
  }

  public E pop() {
    E o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  // Method added by Adam Johnston
  public int search(E o) {
    if(!list.contains(o)) {
      return -1;
    }
    return list.lastIndexOf(o);
  }
   
  @Override
  public String toString() {
    return "stack: " + list.toString();
  }
}
