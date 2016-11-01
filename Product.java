import java.util.*;

public abstract class Product implements Comparable<Product>{

private String productName;
private double pPrice;
public double count = 0.00;

static Drink coke1 = new Drink("Coke", 1.75);
static Drink coke2 = new Drink("Coke", 1.75);
static Drink coke3 = new Drink("Coke", 1.75);
static Drink gatorade1 = new Drink("Gatorade", 1.75);
static Drink gatorade2 = new Drink("Gatorade", 1.75);
static Drink water1 = new Drink("Water", 1.75);
static Drink water2 = new Drink("Water", 1.75);
static Drink water3 = new Drink("Water", 1.75);
static Drink water4 = new Drink("Water", 1.75);
static Candy lifesavers1 = new Candy("Lifesavers", 1.50);
static Candy lifesavers2 = new Candy("Lifesavers", 1.50);
static Candy lifesavers3 = new Candy("Lifesavers", 1.50);
static Candy hershey1 = new Candy("Hershey", 1.50);
static Candy hershey2 = new Candy("Hershey", 1.50);
static Candy hershey3 = new Candy("Hershey", 1.50);
static Candy hershey4 = new Candy("Hershey", 1.50);
static Chips lays1 = new Chips("Lays", 1.50);
static Chips lays2 = new Chips("Lays", 1.50);
static Chips lays3 = new Chips("Lays", 1.50);
static Chips lays4 = new Chips("Lays", 1.50);
static Chips doritos1 = new Chips("Doritos", 1.50);
static Chips doritos2 = new Chips("Doritos", 1.50);
static Gum bubbleYum1 = new Gum("Bubble Yum", 1.50);
static Gum bubbleYum2 = new Gum("Bubble Yum", 1.50);
static Gum bubbleYum3 = new Gum("Bubble Yum", 1.50);
static Gum dentyne1 = new Gum("Dentyne", 1.50);
static Gum dentyne2 = new Gum("Dentyne", 1.50);
static Gum dentyne3 = new Gum("Dentyne", 1.50);
static Gum dentyne4 = new Gum("Dentyne", 1.50);

public Product(){
}
public Product(String productName, double pPrice){
	this.productName = productName;
	this.pPrice = pPrice;
}
public double getPrice(){
	return pPrice;
}
public double getCount(){
	count += pPrice;
	return count;
}



public static Object[] getDrinks(){
	Drink[] drinks = new Drink[] {coke1, coke2, coke3,  gatorade1, gatorade2, water1, water2, water3, water4};
	return drinks;
}
public static Object[] getSnacks(){
	Snack[] snacks = new Snack[] {bubbleYum1, bubbleYum2, bubbleYum3, dentyne1, dentyne2, dentyne3, dentyne4,
			 doritos1, doritos2, hershey1, hershey2, hershey3, hershey4, lays1, lays2, lays3, lays4, lifesavers1,
			lifesavers2, lifesavers3};
	return snacks;
}
public int compareTo(Product other){
	if(!this.productName.equalsIgnoreCase(other.productName))
	return this.productName.compareTo(other.productName);
	else{
		return this.productName.compareTo(other.productName);
	}
}

@Override
public String toString(){
	return productName + " " + pPrice;
}
}

