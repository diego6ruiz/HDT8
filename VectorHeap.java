import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements MyPriorityQueue<E>
{

    /**
     * Vector con todos los pacientes, usado para MyPriorityQueue
     */
    private Vector<E> data;

    @Override
    public String toString() {
        return "VectorHeap{" + "data=" + data + '}';
    }

    public Vector<E> getData() {
        return data;
    }

    public void setData(Vector<E> data) {
        this.data = data;
    }

    /**
     * Constructor, llena data
     */
    public VectorHeap()
	{
		data = new Vector<E>();
	}

    /**
     *
     * @param Vector con todos los pacientes
     */
    public VectorHeap(Vector<E> v)
	{
		int i;
		data = new Vector<E>(v.size());
		for (i = 0; i < v.size(); i++)
		{
			add(v.get(i));
		}
	}

    /**
     *
     * @param int que indica la posicion
     * @return int que indica la posicion
     */
    protected static int parent(int i)
	{
		return (i-1)/2;
	}

    /**
     *
     * @param int de la posicion actual
     * @return int de la posicion del hijo izquierdo
     */
    protected static int left(int i)
	{
		return 2*i+1;
	}

    /**
     *
     * @param int de la posicion actual
     * @return int de la posicion del hijo derecho
     */
    protected static int right(int i)
	{
		return (2*i+1) + 1;
	}

    /**
     *
     * @param int leaf indica la posicion de la hoja
     */
    protected void percolateUp(int leaf)
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

    /**
     *
     * @param generico del valor que es ingresado para agregar en el heap
     */
    public void add(E value)
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

    /**
     *
     * @param int, la posicion de la raiz
     */
    protected void pushDownRoot(int root)
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos;
			} else {
				data.set(root,value);
				return;
			}
			} else {
				data.set(root,value);
				return;
			}
		}
	}

    /**
     *
     * @return devuelve el valor removido del heap
     */
    public E remove()
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

    @Override
    public E getFirst() {
       return data.get(0);
    }


    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
