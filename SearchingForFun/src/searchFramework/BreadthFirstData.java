package searchFramework;

import java.util.ArrayList;
import java.util.Iterator;

public class BreadthFirstData<ItemT> implements Interfaces.Agenda<ItemT> {

	// This type is implemented using a queue
	ArrayList<ItemT> queue = new ArrayList<ItemT>();

	@Override
	public Iterator<ItemT> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(ItemT _item) {
		queue.add(_item);

	}

	@Override
	public ItemT pop() {
		ItemT x = queue.get(0);
		queue.remove(0);
		return x;
	}
	

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public boolean contains(ItemT _item) {
		return queue.contains(_item);
	}

}
