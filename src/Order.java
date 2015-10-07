import java.util.ArrayList;

public class Order 
{
	private final double memberdiscount = 0.9;
	private final double tax = 0.08;
	private int subtotal;
	private int total;
	private ArrayList<Integer> orderprice = new ArrayList<Integer>();
	private ArrayList<String> order = new ArrayList<String>();
	
	Order()
	{
		subtotal = 0;
		total = 0;
	}
	
	public void getOrder(ArrayList<Integer> list, ArrayList<String> list2)
	{
		for(int x = 0; x < list2.size(); x++)
		{
			order.add(list2.get(x));
		}
		for(int x = 0; x < list.size(); x++)
		{
			orderprice.add(list.get(x));
		}
	}
	
	public int calculateSubtotal()
	{
		for(int x = 0; x < orderprice.size(); x++)
		{
			subtotal += orderprice.get(x);
		}
		return subtotal;
	}
	
	public void clear()
	{
		total = 0;
		subtotal = 0;
		orderprice.clear();
		order.clear();
	}
	
	public ArrayList<Integer> getOrderprice() {
		return orderprice;
	}
	public ArrayList<String> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Integer> order) {
		this.orderprice = orderprice;
	}

	public int calculateTotal(boolean x)
	{
		total = subtotal+(int)(subtotal*tax);
		if(x)
		{
			total = (int)(total*memberdiscount);
		}
		return total;
	}	
}
