
public class Product
{
	private String name;
	private int stockLevel;
	private double price;
	
	
	public Product (String nameIn, Integer stockLevelIn, double priceIn)
	{
		name=nameIn;
		stockLevel=stockLevelIn;
		price=priceIn;
	}
		
		
	public boolean reStock(int stockLevelIn)	
	{
		if (stockLevelIn > 0)
		{
			stockLevel+=stockLevelIn;
			return true;
		}
		else return false;
	}
	
	public double sell(int sellIn)	
	{
		if (stockLevel - sellIn >= 0)
		{
			stockLevel -= sellIn;
			return stockLevel;
		}
		else return -1;
	}	
		
	public boolean setPrice(double priceSet)	
	{
		if (priceSet>0.00)
		{
			price=priceSet;
			return true;
		}
		else 
		{
			return false;
		}
	}	
	
	public String getName()
	{
		return name;
	}
	
	public Integer getStockLevel()
	{
		return stockLevel;
	}
	
	public double getPrice()
	{
		return price;
	}
	
		
}

