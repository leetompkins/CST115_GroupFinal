public class Candy extends Snack{

	private String candyName;
	private double cPrice;
	
	public Candy(){
	}
	public Candy(String candyName, double cPrice){
		this.candyName = candyName;
		this.cPrice = cPrice;
	}
	public int compareTo(Candy other){
		if(!this.candyName.equalsIgnoreCase(other.candyName))
		return this.candyName.compareTo(other.candyName);
		else{
			return this.candyName.compareTo(other.candyName);
				}
	}
	@Override
	public String toString(){
		return "Snack";
	}

	@Override
	public String getName(){
		return this.candyName;
	}
	
	@Override
	public double getPrice(){
		return this.cPrice;
	}
}
