import java.util.ArrayList;

import javax.swing.ButtonGroup;


public class Bagel 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price;
	
	Bagel()
	{
		string = new ArrayList<String>();
		price = new ArrayList<Integer>();
	}

	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		string.add("Bagel");
		String product = group.getSelection().getActionCommand();
		string.add(product);
		if(group2.getSelection() != null)
		{
			product = group2.getSelection().getActionCommand();
			string.add(product);
		}
	}
	
	public void clear()
	{
		string.clear();
		price.clear();
	}
	
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).startsWith("White"))
			{
				price.add(300);
			}
			else if(string.get(x).equals("Wheat"))
			{
				price.add(350);
			}
			else if(string.get(x).equals("Salt"))
			{
				price.add(350);
			}
			else if(string.get(x).equals("Seseme"))
			{
				price.add(400);
			}
			else if(string.get(x).equals("Popy"))
			{
				price.add(350);
			}
			else if(string.get(x).endsWith(" "))
			{
				price.add(50);
			}
			else if(string.get(x).equals("Lox Topping")||string.get(x).equals("Nova Lox Topping"))
			{
				price.add(100);
			}
		}
	}
	
	public ArrayList<String> getString() {
		return string;
	}
	public void setString(ArrayList<String> string) {
		this.string = string;
	}
	public ArrayList<Integer> getPrice() {
		return price;
	}
	public void setPrice(ArrayList<Integer> price) {
		this.price = price;
	}
}
