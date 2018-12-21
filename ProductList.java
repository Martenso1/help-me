
import java.util.List;
import java.util.ArrayList;

class ProductList {
	
	private List<Product> list = new ArrayList<Product>();
	
	
	public ProductList()
	{
		list.add(new Product("Chicken",4,3.59));
		list.add(new Product("Carrots",2,4.20));
		list.add(new Product("Thing",4,3.57));
		list.add(new Product("Light Saber",23,3.23));
		list.add(new Product("Book",86,4.20));
		list.add(new Product("Real Skeleton",420,3.23));
	}
	
	public Product getItem(int i)
	{
		return list.get(i);
	}
	
	public int getSize()
	{
		return list.size();
	}
	
	public void addItem(Product item)
	{
		list.add(item);
	}
}
