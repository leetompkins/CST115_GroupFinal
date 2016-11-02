
import java.text.DecimalFormat;
import java.util.*;

import javafx.animation.PathTransition; 
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Dispenser extends Application{
	@Override
	public void start(Stage primaryStage){
		
// Construct the MoneyManager 
		DecimalFormat df = new DecimalFormat("#.00");
		MoneyManager moneyManager = new MoneyManager();
		Product[] productList = new Product[29];
		
		Object[] drinksList = Product.getDrinks();
		
		Object[] snackList = Product.getSnacks();
	
		for(int i = 0; i < drinksList.length; i++){
			productList[i] = (Product) drinksList[i];
		}
		for(int i = drinksList.length; i < (productList.length); i++){
			productList[i] =  (Product) snackList[i - drinksList.length];
		}
		
		ArrayList<Product> purchasedItems = new ArrayList<Product>();
		ObservableList<Product> checkoutItems = FXCollections.observableArrayList(purchasedItems);
// Create Observable Lists 
		
		
		
		
//Create needed panes.
		
		BorderPane bpMain = new BorderPane();
		VBox vbCenter = new VBox();
		HBox hbCenterTop = new HBox();
		HBox hbCenterBottom = new HBox();
		HBox hbTop = new HBox();
		HBox hbBottom = new HBox();
		ListView<Product> lvCheckout = new ListView<Product>();
		lvCheckout.setCellFactory((list) -> {
			return new ListCell<Product>() {
				@Override
				protected void updateItem(Product item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty){
						setText(null);
					} else {
						if(item.toString() == "Drink") {
							setText(((Drink) item).getName());
						} else {
							setText(((Snack) item).getName());
						}
						
						
					} 
						
					
				}
			};
		});
		lvCheckout.setItems(checkoutItems);
		VBox vbBoss = new VBox();
		VBox vbCheckout = new VBox();
		
		//lvCheckout.getItems().add(checkoutItems);
		
		// Animation
		
		

//------------------------------------<Buttons, Labels, TextFields>--------------------------------------------\\
		
		
				Button btnCheckout = new Button("Checkout");
				btnCheckout.setPrefWidth(150);
				Button btnDrinks = new Button("Drinks");
				btnDrinks.setPrefWidth(490);
				btnDrinks.setPrefHeight(600);
				
				Button btnSnacks = new Button("Snacks");
				btnSnacks.setPrefWidth(490);
				btnSnacks.setPrefHeight(600);
				Button btnBoss = new Button("BOSS");
				btnBoss.setPrefWidth(150);
				Button btnCoke = new Button("Coke");
				btnCoke.setPrefSize(326.6667, 600);
				
				Button btnGatorade = new Button("Gatorade");
				btnGatorade.setPrefSize(326.6667, 600);
				Button btnWater = new Button("Water");
				btnWater.setPrefSize(326.6667, 600);
				Button btnRemove = new Button("Remove Selected");
				btnRemove.setPrefWidth(150);
				Button btnLifeSaver = new Button("LifeSavers");
				btnLifeSaver.setPrefSize(326.6667, 300);
				Button btnHershey = new Button("Hersheys");
				btnHershey.setPrefSize(326.6667, 300);
				Button btnLays = new Button("Lays");
				btnLays.setPrefSize(326.6667, 300);
				Button btnDoritos = new Button("Doritos");
				btnDoritos.setPrefSize(326.6667, 300);
				Button btnBubbleYum = new Button("BubbleYum");
				btnBubbleYum.setPrefSize(326.6667, 300);
				Button btnDentyne = new Button("Dentyne");
				btnDentyne.setPrefSize(326.6667, 300);
				Button btnHome = new Button("Home");
				btnHome.setPrefSize(1280, 100);
				
				// Money Buttons 
				Button btnDollar = new Button("Dollar");
				btnDollar.setPrefSize(300, 80);
				Button btnQuater = new Button("Quarter");
				btnQuater.setPrefSize(300, 80);
				Button btnDime = new Button("Dime");
				btnDime.setPrefSize(300, 80);
				Button btnNickel = new Button("Nickel");
				btnNickel.setPrefSize(300, 80);
				
				TextField tfTotal = new TextField();
				tfTotal.setText("");
				tfTotal.setEditable(false);
				tfTotal.setStyle("-fx-background-color: black;" + "-fx-text-fill: red;");
			
				
				Label lbTotal = new Label("Total");
				Label lbCredit = new Label("Credit");
				Label lbUsername = new Label("Username");
				Label lbPassword = new Label("Password");
				Label lbWrongPassword = new Label("INCORRECT USERNAME OR PASSWORD");
				TextField tfCredit = new TextField("0.00");
				tfCredit.setEditable(false);
				tfCredit.setStyle("-fx-background-color: black;"
						+ "-fx-text-fill: green;");
				
				TextField tfUsername = new TextField("Username");
				PasswordField pfPassword = new PasswordField();
				
//-----------------------------------<Set Pane Content>-------------------------------------------------------------------------------\\
				
				hbTop.getChildren().add(btnHome);
				bpMain.setTop(hbTop);
				
				vbBoss.setPrefWidth(150);
				vbBoss.getChildren().addAll(btnBoss,lbUsername,tfUsername,lbPassword,pfPassword);
				bpMain.setLeft(vbBoss);
				
				vbCheckout.setPrefWidth(150);
				vbCheckout.getChildren().addAll(lvCheckout,btnRemove,lbTotal,tfTotal,lbCredit,tfCredit,btnCheckout);
				bpMain.setRight(vbCheckout);
				
				hbCenterTop.getChildren().addAll(btnDrinks,btnSnacks);
				vbCenter.getChildren().add(hbCenterTop);
				vbCenter.getChildren().add(hbCenterBottom);
				hbBottom.setAlignment(Pos.CENTER);
				hbBottom.getChildren().addAll(btnDollar,btnQuater,btnDime,btnNickel);
				bpMain.setBottom(hbBottom);
				bpMain.setCenter(vbCenter);
				
				
				
		
//------------------------------------------<Product Images>---------------------------------------------------------------------------//
				
				ImageView imgDrink = new ImageView(
						"https://images.vat19.com/covers/large/soda-bottle-lip-balms.jpg");
						//"https://openclipart.org/image/2400px/svg_to_png/24123/Soft-drink-icon.png");
						imgDrink.setFitHeight(600);
						imgDrink.setFitWidth(480);
						imgDrink.setOpacity(50);
						btnDrinks.setGraphic(imgDrink);
						btnDrinks.setText("");
						
						
				ImageView imgSnacks = new ImageView(
						"http://images.mentalfloss.com/sites/default/files/styles/insert_main_wide_image/public/istock_000012710166_small.jpg");
						//"http://andrewsnuts.com/wp-content/uploads/2014/02/Flaticon_18240.png");
						imgSnacks.setFitHeight(600);
						imgSnacks.setFitWidth(480);
						btnSnacks.setGraphic(imgSnacks);
						btnSnacks.setText("");
						
				ImageView imgGatorade = new ImageView(
						"http://cdn.shopify.com/s/files/1/0286/5470/products/G_CoolBlue_20oz.png?v=1427213068");
						imgGatorade.setFitHeight(600);
						imgGatorade.setFitWidth(310);
						btnGatorade.setGraphic(imgGatorade);
						btnGatorade.setText("");
						
				ImageView imgCoke = new ImageView(
						"http://www.coca-colaproductfacts.com/content/dam/productfacts/us/productDetails/ProductImages/Coke_20oz.png");
						imgCoke.setFitHeight(600);
						imgCoke.setFitWidth(310);
						btnCoke.setGraphic(imgCoke);
						btnCoke.setText("");
						
						

						
				ImageView imgWater = new ImageView(
						"http://fijiwater.com.au/wp-content/uploads/2013/01/Bottle-3.png");
						imgWater.setFitHeight(600);
						imgWater.setFitWidth(310);
						btnWater.setGraphic(imgWater);
						btnWater.setText("");

						
				ImageView imgBubbleYum = new ImageView(
						"https://cdn.shopify.com/s/files/1/0972/7116/products/bubble-yum-original-bubble-gum-5-piece-pack.png?v=1459346042");
						imgBubbleYum.setFitHeight(290);
						imgBubbleYum.setFitWidth(290);
						btnBubbleYum.setGraphic(imgBubbleYum);
						btnBubbleYum.setText("");

								
				ImageView imgDentyne = new ImageView(
						"http://www.dentyne.com/img/products/ice-peppermint.png");
						imgDentyne.setFitHeight(290);
						imgDentyne.setFitWidth(290);
						btnDentyne.setGraphic(imgDentyne);
						btnDentyne.setText("");

						
				ImageView imgDoritos = new ImageView(
						"http://www.fritolay.com/images/default-source/blue-bag-image/doritos-nacho-cheese.png?sfvrsn=2");
						imgDoritos.setFitHeight(290);
						imgDoritos.setFitWidth(290);
						btnDoritos.setGraphic(imgDoritos);
						btnDoritos.setText("");

						
				ImageView imgHershey = new ImageView(
						"https://upload.wikimedia.org/wikipedia/commons/1/1b/Hershey's_Milk_Chocolate_wrapper_(2012-2015).png");
						imgHershey.setFitHeight(290);
						imgHershey.setFitWidth(290);
						btnHershey.setGraphic(imgHershey);
						btnHershey.setText("");

					
				ImageView imgLays = new ImageView(
						"http://www.fritolay.com/images/default-source/blue-bag-image/lays-classic.tmb-.png?sfvrsn=1");
						imgLays.setFitHeight(290);
						imgLays.setFitWidth(290);
						btnLays.setGraphic(imgLays);
						btnLays.setText("");

						
				ImageView imgLifeSavers = new ImageView(
						"http://www.life-savers.com/www/img/products_pic/hard_candies/5_flavors_roll.png");
						imgLifeSavers.setFitHeight(290);
						imgLifeSavers.setFitWidth(290);
						btnLifeSaver.setGraphic(imgLifeSavers);
						btnLifeSaver.setText("");
						
						
// ---------------------------------------------<BUTTON ACTIONS>------------------------------------------------------------------------\\
						
						// Drink Button
						btnDrinks.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e) {
								hbCenterTop.getChildren().removeAll(btnDrinks, btnSnacks);
								hbCenterTop.getChildren().addAll(btnCoke,btnGatorade,btnWater);
							}
						});
						
						// Snack Button
						btnSnacks.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e) {
								hbCenterTop.getChildren().removeAll(btnDrinks, btnSnacks);
								hbCenterTop.getChildren().addAll(btnLifeSaver,btnHershey,btnLays);
								hbCenterBottom.getChildren().addAll(btnDoritos,btnBubbleYum,btnDentyne);
							}
						});
						
						// Coke Button
						btnCoke.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent e) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Drink) productList[i]).getName().equals("Coke")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										System.out.println("Coke Button");
										i = productList.length + 1;

									
									} else {
										System.out.println("No Coke at index: " + i);
									}
									}
								}
								
							}
							
						});
						
						// Gatorade Button
						btnGatorade.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Drink) productList[i]).getName().equals("Gatorade")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										System.out.println("Gatorade Button");
										i = productList.length + 1;

									
									} else {
										System.out.println("No Gatorade at index: " + i);
									}
									}
								}
								
							}
							
						});
						
						// Water Button
						btnWater.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Drink) productList[i]).getName().equals("Water")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										System.out.println("Water Button");
										i = productList.length + 1;

									
									} else {
										System.out.println("No Water at index: " + i);
									}
									}
								}
								
							}
							
						});
						
						// BubbleYum Button
						btnBubbleYum.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Product) productList[i]).toString() == ("Snack")) {
										
										if(((Snack) productList[i]).getName().equals("Bubble Yum")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										
										i = productList.length + 1;
										} else {
											System.out.println("null");
										}

									
									} else {
										System.out.println("No BubbleYum at index: " + i);
									}
									
									}
								}
								
							}
							
						});
						// Dentyne Button
						btnDentyne.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Product) productList[i]).toString() == ("Snack")) {
										
										if(((Snack) productList[i]).getName().equals("Dentyne")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										
										i = productList.length + 1;
										} else {
											System.out.println("null");
										}

									
									} else {
										System.out.println("No Dentyne at index: " + i);
									}
									
									}
								}
								
							}
							
						});
						// Lays Button
						btnLays.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Product) productList[i]).toString() == ("Snack")) {
										
										if(((Snack) productList[i]).getName().equals("Lays")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										
										i = productList.length + 1;
										} else {
											System.out.println("null");
										}

									
									} else {
										System.out.println("No Lays at index: " + i);
									}
									
									}
								}
								
							}
							
						});
						// Doritos Button
						btnDoritos.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Product) productList[i]).toString() == ("Snack")) {
										
										if(((Snack) productList[i]).getName().equals("Doritos")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										
										i = productList.length + 1;
										} else {
											System.out.println("null");
										}

									
									} else {
										System.out.println("No Doritos at index: " + i);
									}
									
									}
								}
								
							}
							
						});
						// Hershey Button
						btnHershey.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Product) productList[i]).toString() == ("Snack")) {
										
										if(((Snack) productList[i]).getName().equals("Hershey")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										
										i = productList.length + 1;
										} else {
											System.out.println("null");
										}

									
									} else {
										System.out.println("No Hersheys at index: " + i);
									}
									
									}
								}
								
							}
							
						});
						// Lifesavers Button
						btnLifeSaver.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								for (int i = 0; i < productList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(productList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Product) productList[i]).toString() == ("Snack")) {
										
										if(((Snack) productList[i]).getName().equals("Lifesavers")) {
										purchasedItems.add((Product) productList[i]);
										tfTotal.setText("$" + ((((Product) productList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) productList[i]).getPrice());
										productList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										
										i = productList.length + 1;
										} else {
											System.out.println("null");
										}

									
									} else {
										System.out.println("No Lifesavers at index: " + i);
									}
									
									}
								}
								
							}
							
						});
						
						// Reset  View to Start-up View
						btnHome.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent e) {
								hbCenterTop.getChildren().clear();
								hbCenterBottom.getChildren().clear();
								hbCenterTop.getChildren().addAll(btnDrinks, btnSnacks);
								//bpMain.setCenter(null);
							
								
							}
							
						});
						
						btnDollar.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								moneyManager.setCredit((moneyManager.getCredit() + 1.00));
								tfCredit.setText("$" + df.format(moneyManager.getCredit()));
							}
							
						});
						btnQuater.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								moneyManager.setCredit((moneyManager.getCredit() + 0.25));
								tfCredit.setText("$" + df.format(moneyManager.getCredit()));
							}
							
						});
						btnDime.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								moneyManager.setCredit((moneyManager.getCredit() + 0.10));
								tfCredit.setText("$" + df.format(moneyManager.getCredit()));
							}
							
						});
						btnNickel.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								moneyManager.setCredit((moneyManager.getCredit() + 0.05));
								tfCredit.setText("$" + df.format(moneyManager.getCredit()));
							}
							
						});
						//Checkout Button
						btnCheckout.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								if(moneyManager.getCredit() >= moneyManager.getTotal()) {
									moneyManager.purchase();
									tfCredit.setText("$" + df.format(moneyManager.getCredit()));
									tfTotal.setText("$" + df.format(moneyManager.getTotal()));
									checkoutItems.removeAll(purchasedItems);
									purchasedItems.removeAll(purchasedItems);
									checkoutItems.addAll(purchasedItems);
									lvCheckout.setItems(checkoutItems);
									
								} else {
								  System.out.println("Need mas monies");
								}
								
							}
							
						});
						
						
						
//---------------------------------------------<ListView Listeners and Relevant Buttons>-----------------------------------------\\
						
						
						
						
						
						lvCheckout.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
							
							// Remove Item from checkout button
							
							btnRemove.setOnAction(new EventHandler<ActionEvent>(){

								@Override
								public void handle(ActionEvent arg0) {
									// Set the total price field 
									moneyManager.setTotal(moneyManager.getTotal() - ((Product) newValue).getPrice());
									tfTotal.setText("$" +  moneyManager.getTotal());
									
									// Reset the ListView and Re-Add the checkout item to productList
									
									checkoutItems.removeAll(purchasedItems);
									purchasedItems.remove(newValue);
									checkoutItems.addAll(purchasedItems);
									lvCheckout.setItems(checkoutItems);
									for(int i = 0; i < productList.length; i++) {
										if(productList[i] == (null)) {
											productList[i] = newValue;
											i = productList.length;
										} else {
											//Carry on 
										}
									}
									
								}
								
							});
							
							
						});
						
						// Reset GUI to Main view on startup
						
						
		

//Set scene and show.	
		Scene scene = new Scene(bpMain, 1280, 800);
		primaryStage.setTitle("Vending machine GUI");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args){
		Application.launch(args);
		
	
}
}