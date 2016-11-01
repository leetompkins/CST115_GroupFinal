

 
 // Animation for the vending process by Robbie Evans III 
 
 
 import javafx.animation.PathTransition; 
 import javafx.animation.Timeline; 
 import javafx.application.Application; 
 import javafx.scene.Scene; 
 import javafx.scene.layout.Pane; 
 import javafx.scene.paint.Color; 
 import javafx.scene.shape.Ellipse; 
 import javafx.scene.shape.Line; 
 import javafx.scene.shape.Rectangle; 
 import javafx.stage.Stage; 
 import javafx.util.Duration; 
 
 
 public class Animation extends Application { 
 
 
 	public Animation() {}
 
 
 	@Override 
 	public void start(Stage primaryStage) throws Exception { 
 		 
 		Pane pane1 = new Pane(); 
 		Rectangle rect1 = new Rectangle(85, 20, 30, 45); 
 		rect1.setStroke(Color.STEELBLUE); 
 		rect1.setFill(Color.CORNFLOWERBLUE); 
 		 
 		/*colors can be changed, blue just seemed like a neutral color to me*/ 
 		 
 		Ellipse ell1 = new Ellipse(200,200, 60, 25); 
 	 
 		 
 		Line line1 = new Line(85, 20, 200, 200); 
 		line1.setStroke(Color.TRANSPARENT); 
 		 
 		 
 		pane1.getChildren().addAll(rect1, ell1, line1); 
 		 
 		 
 		 
 		PathTransition pt = new PathTransition(); 
 		pt.setDuration(Duration.millis(4500)); 
 		pt.setPath(line1); 
 		pt.setNode(rect1); 
 		pt.setOrientation(PathTransition.OrientationType.NONE); 
 		pt.setCycleCount(4);  // 
 		pt.setAutoReverse(false); 
 		pt.play(); 
 		 
 		/* 4 seemed like an appropriate number of cycles, also I set auto reverse to "false" as this causes the product comes out of the "hole" 
 		and it didn't look quite right to me */ 
 
 	
 		 
 		 
 Scene scene = new Scene(pane1, 400, 300); 
 		 
 		 
 		primaryStage.setTitle("Vend"); 
 		primaryStage.setScene(scene); 
 		primaryStage.show(); 
 		 
 		 
 	} 
 public static void main(String [] args){ 
 		 
 		Application.launch(args); 
 	} 
 	 
 
 
 } 
