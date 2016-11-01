
public class Drink extends Product{

	private String drinkName;
	private double dPrice;
	Product[] allItems = new Product[9];
	
	public String getName() {
		return this.drinkName;
	}
	public double getPrice() {
		return dPrice;
	}
	
	public Drink(){
	}
	public Drink(String drinkName, double dPrice){
		this.drinkName = drinkName;
		this.dPrice = dPrice;
	}
	public int compareTo(Drink other){
		if(!this.drinkName.equalsIgnoreCase(other.drinkName))
			return this.drinkName.compareTo(other.drinkName);
			else{
				return this.drinkName.compareTo(other.drinkName);
			}
		}
	@Override
	public String toString(){
		return drinkName + " " + dPrice;
	}

}
