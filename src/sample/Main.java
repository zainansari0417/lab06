package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application {

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{
        canvas = new Canvas();
        canvas.setHeight(400);
        canvas.setWidth(650);
        Group root = new Group();
        draw(canvas);
        root.getChildren().add(canvas);

        primaryStage.setTitle("Lab 6");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
    }

    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        float runningAngle = 0;
        float currentAngle = 0;
        float runningTotal = 0;

        for(int i=0; i<purchasesByAgeGroup.length; i++) {
            runningTotal += purchasesByAgeGroup[i];
        }
        float total = runningTotal/360;

        for(int i=0; i<purchasesByAgeGroup.length; i++){
            gc.setFill(pieColours[i]);
            currentAngle = (float)(purchasesByAgeGroup[i])/total;
            gc.fillArc(300,60,300,300,runningAngle,currentAngle, ArcType.ROUND);
            runningAngle += currentAngle;
        }
        float maxHeight = 0;
        for (int i=0; i<avgHousingPricesByYear.length; ){

        }
    }


    public static void main(String[] args) {

        launch(args);
    }
}
