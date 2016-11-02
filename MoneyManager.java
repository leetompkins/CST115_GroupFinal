


public class MoneyManager {
	private double credit = 0.00;
	private double total = 0.00;
	
	
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	MoneyManager() {
		
	}
	
	public void purchase(){
		if(this.total <= this.credit) {
			this.credit = this.credit - this.total;
			this.total = 0.00;
		} else if(this.total > this.credit){
			System.out.println("Not enough Money");
		}
	}
	
	
}