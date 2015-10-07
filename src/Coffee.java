import java.util.ArrayList;
import javax.swing.ButtonGroup;


public class Coffee 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price;
	
	Coffee()
	{
		string = new ArrayList<String>();
		price = new ArrayList<Integer>();
	}

	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		String product = "";
		product = group.getSelection().getActionCommand()+" "+group2.getSelection().getActionCommand();
		
		string.add("Coffee");
		string.add(product);
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
			if(string.get(x).startsWith("Small"))
			{
				price.add(300);
			}
			else if(string.get(x).startsWith("Medium"))
			{
				price.add(400);
			}
			else if(string.get(x).startsWith("Large"))
			{
				price.add(700);
			}
			else if(string.get(x).equals("Extra Sugar"))
			{
				price.add(20);
			}
			else if(string.get(x).equals("Extra Cream"))
			{
				price.add(20);
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
