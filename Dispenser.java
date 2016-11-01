
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
		
		MoneyManager moneyManager = new MoneyManager();
		
		Object[] drinksList = Product.getDrinks();
		Object[] snackList = Product.getSnacks();
		ArrayList<Product> purchasedItems = new ArrayList<Product>();
		ObservableList<Product> checkoutItems = FXCollections.observableArrayList(purchasedItems);
// Create Observable Lists 
		
		
		
		
//Create needed panes.
		
		BorderPane bpMain = new BorderPane();
		VBox vbCenter = new VBox();
		HBox hbCenterTop = new HBox();
		HBox hbCenterBottom = new HBox();
		HBox hbTop = new HBox();
		ListView<Product> lvCheckout = new ListView<Product>();
		lvCheckout.setCellFactory((list) -> {
			return new ListCell<Product>() {
				@Override
				protected void updateItem(Product item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty){
						setText(null);
					} else {
						setText(((Drink) item).getName());
					}
				}
			};
		});
		lvCheckout.setItems(checkoutItems);
		VBox vbBoss = new VBox();
		VBox vbCheckout = new VBox();
		
		//lvCheckout.getItems().add(checkoutItems);
		
		// Animation
		
		

//Buttons
		
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
				Button btnRefresh = new Button("Refresh");
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
				
				hbTop.getChildren().add(btnHome);
				bpMain.setTop(hbTop);
				
				vbBoss.setPrefWidth(150);
				vbBoss.getChildren().addAll(btnBoss,lbUsername,tfUsername,lbPassword,pfPassword);
				bpMain.setLeft(vbBoss);
				
				vbCheckout.setPrefWidth(150);
				vbCheckout.getChildren().addAll(lvCheckout,btnRemove,btnRefresh,lbTotal,tfTotal,lbCredit,tfCredit,btnCheckout);
				bpMain.setRight(vbCheckout);
				
				hbCenterTop.getChildren().addAll(btnDrinks,btnSnacks);
				vbCenter.getChildren().add(hbCenterTop);
				vbCenter.getChildren().add(hbCenterBottom);
				bpMain.setCenter(vbCenter);
				
				
				
		
//Product images
				
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
						
				ImageView gatorImage1 = new ImageView(
						"http://www.bluedaring.com/BlueDaring/wp-content/uploads/2014/04/gatorade-blue-raspberry_1.png");
						gatorImage1.setFitHeight(50);
						gatorImage1.setFitWidth(50);

						
				ImageView imgCoke = new ImageView(
						"http://www.coca-colaproductfacts.com/content/dam/productfacts/us/productDetails/ProductImages/Coke_20oz.png");
						imgCoke.setFitHeight(50);
						imgCoke.setFitWidth(50);
						StackPane spAnimationCoke = new StackPane();
						

						
				ImageView waterImage1 = new ImageView(
						"http://www.underconsideration.com/brandnew/archives/aquafina_packaging.jpg");
						waterImage1.setFitHeight(50);
						waterImage1.setFitWidth(50);

						
				ImageView bubbleImage1 = new ImageView(
						"https://s3.amazonaws.com/static.caloriecount.about.com/images/medium/bubble-yum-gum-balls-36614.jpg");
						bubbleImage1.setFitHeight(50);
						bubbleImage1.setFitWidth(50);

								
				ImageView dentyneImage1 = new ImageView(
						"http://www.dentyne.com/img/products/ice-peppermint.png");
						dentyneImage1.setFitHeight(50);
						dentyneImage1.setFitWidth(50);

						
				ImageView doritoImage1 = new ImageView(
						"http://www.fritolay.com/images/default-source/blue-bag-image/doritos-nacho-cheese.png?sfvrsn=2");
						doritoImage1.setFitHeight(50);
						doritoImage1.setFitWidth(50);

						
				ImageView hersheyImage1 = new ImageView(
						"https://images-na.ssl-images-amazon.com/images/I/71dZCgM7vOL._SL1500_.jpg");
						hersheyImage1.setFitHeight(50);
						hersheyImage1.setFitWidth(50);

					
				ImageView laysImage1 = new ImageView(
						"http://www.fritolay.com/images/default-source/blue-bag-image/lays-classic.tmb-.png?sfvrsn=1");
						laysImage1.setFitHeight(50);
						laysImage1.setFitWidth(50);

						
				ImageView lifesaversImage1 = new ImageView(
						"http://www.life-savers.com/www/img/products_pic/hard_candies/5_flavors_roll.png");
						lifesaversImage1.setFitHeight(50);
						lifesaversImage1.setFitWidth(50);
						
						
						btnDrinks.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e) {
								hbCenterTop.getChildren().removeAll(btnDrinks, btnSnacks);
								hbCenterTop.getChildren().addAll(btnCoke,btnGatorade,btnWater);
							}
						});
						
						btnSnacks.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e) {
								hbCenterTop.getChildren().removeAll(btnDrinks, btnSnacks);
								hbCenterTop.getChildren().addAll(btnLifeSaver,btnHershey,btnLays);
								hbCenterBottom.getChildren().addAll(btnDoritos,btnBubbleYum,btnDentyne);
							}
						});
						
						btnCoke.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent e) {
								for (int i = 0; i < drinksList.length; i++) {
									lvCheckout.setItems(checkoutItems);
									if(drinksList[i] == null) {
										System.out.println("");
									} else {
									
									if(((Drink) drinksList[i]).getName().equals("Coke")) {
										purchasedItems.add((Product) drinksList[i]);
										tfTotal.setText("$" + ((((Product) drinksList[i]).getPrice()) + moneyManager.getTotal()));
										moneyManager.setTotal(moneyManager.getTotal() + ((Product) drinksList[i]).getPrice());
										drinksList[i] = null;
										checkoutItems.removeAll(purchasedItems);
										checkoutItems.addAll(purchasedItems);
										lvCheckout.setItems(checkoutItems);
										lvCheckout.refresh();
										System.out.println("Coke Button");
										i = drinksList.length + 1;

									
									} else {
										System.out.println("No Coke at index: " + i);
									}
									}
								}
								
							}
							
						});
						
						lvCheckout.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
							
							btnRefresh.setOnAction(new EventHandler<ActionEvent>(){

								@Override
								public void handle(ActionEvent event) {
									lvCheckout.setItems(checkoutItems);
									
								}
								
								
							});
							
						});
						
						btnHome.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent e) {
								hbCenterTop.getChildren().clear();
								hbCenterBottom.getChildren().clear();
								hbCenterTop.getChildren().addAll(btnDrinks, btnSnacks);
								//bpMain.setCenter(null);
							
								
							}
							
						});
		

					    /*
					    lifesavers3.setOnAction(new EventHandler<ActionEvent>() {
				            @Override
				            public void handle(ActionEvent event) {
				            	PathTransition pt = new PathTransition();
				            	pt.setDuration(Duration.millis(2500)); 
				         		pt.setPath(line6); 
				         		pt.setNode(lifesavers3); 
				         		pt.setOrientation(PathTransition.OrientationType.NONE); 
				         		pt.setCycleCount(1);  // 
				         		pt.setAutoReverse(false); 
				         		pt.play();
				            	lifesaversItem.getChildren().removeAll(lifesavers1, lifesavers2, lifesavers3);
				            	purchasedItems[28] = snackList[19];
				            	purchased.add(lifesavers3, 1, 8);
				            }
				        });
				        */
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