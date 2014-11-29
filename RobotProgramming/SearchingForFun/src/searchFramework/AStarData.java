package searchFramework;

import java.util.ArrayList;
import java.util.Iterator;

import Interfaces.SortedAgenda;

public class AStarData<ItemT extends Comparable<ItemT>> implements SortedAgenda<ItemT>  {

	// This type is implemented using a queue
	ArrayList<ItemT> sorted = new ArrayList<ItemT>();

	@Override
	public Iterator<ItemT> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(ItemT _item) {
		sorted.add(_item);

	}

	public void sort() {
		Collections.sort(sorted);
	}

	@Override
	public ItemT pop() {
		ItemT x = sorted.get(0);
		sorted.remove(0);
		return x;
	}
	

	@Override
	public boolean isEmpty() {
		return sorted.isEmpty();
	}

	@Override
	public boolean contains(ItemT _item) {		sort();
		return sorted.contains(_item);
	}

}
