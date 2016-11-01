public abstract class Snack extends Product{
	
	private String snackName;
	private double sPrice;
	
	public Snack(){
	}
	public Snack(String snackName, double sPrice){
		this.snackName = snackName;
		this.sPrice = sPrice;
	}
	public int compareTo(Snack other){
		if(!this.snackName.equalsIgnoreCase(other.snackName))
			return this.snackName.compareTo(other.snackName);
			else{
				return this.snackName.compareTo(other.snackName);
			}
	}
		@Override
	public String toString(){
		return snackName + " " + sPrice;
	}

}
