package searchFramework;

import java.util.ArrayList;
import java.util.Iterator;

public class DepthFirstData<ItemT> implements Interfaces.Agenda<ItemT> {

	//This part is implemented using a stack
	ArrayList<ItemT> stack = new ArrayList<ItemT>();
	
	@Override
	public Iterator<ItemT> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(ItemT _item) {
		stack.add(_item);
	}

	@Override
	public ItemT pop() {
		ItemT x = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return x;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public boolean contains(ItemT _item) {
		return stack.contains(_item);
	}

}
