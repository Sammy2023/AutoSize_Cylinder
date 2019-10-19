package sample.Chapter_15;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
public class AutoSize_Cylider extends Application{

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Ellipse el = new Ellipse(150, 50, 50, 20);
        el.centerXProperty().bind(pane.widthProperty().divide(2));
        el.centerYProperty().bind(pane.heightProperty().divide(4));
        el.radiusXProperty().bind(pane.widthProperty().divide(4));
        el.radiusYProperty().bind(pane.heightProperty().divide(8));
        el.setFill(Color.WHITE);
        el.setStroke(Color.BLACK);

        Arc arc1 = new Arc(150, 150, 50, 20, 190, 170); // Create an arc
        arc1.centerXProperty().bind(pane.widthProperty().divide(2));
        arc1.centerYProperty().bind(pane.heightProperty().subtract(100));
        arc1.radiusXProperty().bind(pane.widthProperty().divide(4));
        arc1.radiusYProperty().bind(pane.heightProperty().divide(8));
        arc1.setType(ArcType.OPEN); // Set arc type
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);

        Arc arc2 = new Arc(150, 150, 50, 20, 9, 170);
        arc2.getStrokeDashArray().addAll(6.0, 21.0);
        arc2.centerXProperty().bind(pane.widthProperty().divide(2));
        arc2.centerYProperty().bind(pane.heightProperty().subtract(100));
        arc2.radiusXProperty().bind(pane.widthProperty().divide(4));
        arc2.radiusYProperty().bind(pane.heightProperty().divide(8));
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BLACK);
        pane.getChildren().add(arc2);
        pane.getChildren().add(arc1); // Add arc to pane
        pane.getChildren().add(el);

        Line line = new Line(100, 50, 100, 153);
        line.startXProperty().bind(pane.widthProperty().divide(4));
        line.startYProperty().bind(pane.heightProperty().divide(4));
        line.endXProperty().bind(pane.widthProperty().divide(4));
        line.endYProperty().bind(pane.heightProperty().subtract(93));
        pane.getChildren().add(line);

        Line line2 = new Line(200, 50, 200, 153);
        pane.getChildren().add(line2);

        line2.startXProperty().bind(pane.widthProperty().subtract(pane.widthProperty().divide(4)));
        line2.startYProperty().bind(pane.heightProperty().divide(4));
        line2.endXProperty().bind(pane.widthProperty().subtract(pane.widthProperty().divide(4)));
        line2.endYProperty().bind(pane.heightProperty().subtract(93));

        Scene scene = new Scene(pane,300, 200);
        primaryStage.setTitle("ShowArc"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        final double height = pane.getHeight();

    }
}
