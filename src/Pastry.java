import java.util.ArrayList;


public class Pastry 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price = new ArrayList<Integer>();;
	
	Pastry()
	{
		string = new ArrayList<String>();
	}

	public void getSelectedButton(int[] i, String[] k)
	{
		string.add("Pastry");
		for(int x = 0; x < i.length; x++)
        {
        	string.add(k[i[x]]);
        }
	}
	
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).equals("Apricot Danish"))
			{
				price.add(400);
			}
			else if(string.get(x).equals("Prune Danish"))
			{
				price.add(350);
			}
			else if(string.get(x).equals("Crossant"))
			{
				price.add(250);
			}
			else if(string.get(x).equals("English Muffin"))
			{
				price.add(300);
			}
			else if(string.get(x).equals("Blueberry Muffin"))
			{
				price.add(300);
			}
		}
	}
	
	public void clear()
	{
		string.clear();
		price.clear();
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
