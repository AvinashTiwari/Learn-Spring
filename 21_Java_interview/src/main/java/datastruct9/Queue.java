package datastruct9;

public interface Queue<E> 
{
	void enqueue(E value);
	E dequeue();
	E peek();
}
