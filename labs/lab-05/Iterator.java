public interface Iterator<E> {

    public E getCurrent();
    public E next();
    public boolean hasNext();
    public void reset();

}
