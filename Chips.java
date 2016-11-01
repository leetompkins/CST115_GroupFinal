public class Chips extends Snack{
	
	private String chipsName;
	private double chPrice;
	
	public Chips(){
	}
	public Chips(String chipsName, double chPrice){
		this.chipsName = chipsName;
		this.chPrice = chPrice;
	}
	public int compareTo(Chips other){
		if(!this.chipsName.equalsIgnoreCase(other.chipsName))
		return this.chipsName.compareTo(other.chipsName);
		else{
			return this.chipsName.compareTo(other.chipsName);
				}
	}
	@Override
	public String toString(){
		return chipsName + " " + chPrice;
	}

}
