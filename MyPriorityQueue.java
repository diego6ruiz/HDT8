public interface MyPriorityQueue<E extends Comparable<E>>
{

    /**
     *
     * @return primer valor del queue
     */
    public E getFirst();
	
    /**
     *
     * @return primer valor en ser atendido
     */
    public E remove();
    /**
     *
     * @param atiende al paciente 
     */
    public void add(E value);
	
    /**
     *
     * @return booleano que indica si esta vacio o no
     */
    public boolean isEmpty();
	
    /**
     *
     * @return int del tamano
     */
    public int size();
	
    public void clear();
}