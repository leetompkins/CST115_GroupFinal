public class Gum extends Snack{
	
	private String gumName;
	private double gPrice;
	
	public Gum(){
	}
	public Gum(String gumName, double gPrice){
		this.gumName = gumName;
		this.gPrice = gPrice;
	}
	public int compareTo(Gum other){
		if(!this.gumName.equalsIgnoreCase(other.gumName))
		return this.gumName.compareTo(other.gumName);
		else{
			return this.gumName.compareTo(other.gumName);
				}
	}
	@Override
	public String toString(){
		return "Snack";
	}
	@Override
	public String getName(){
		return this.gumName;
	}
	@Override
	public double getPrice(){
		return this.gPrice;
	}

}
