package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class Controller {
    private GardenPlanner planner = new GardenPlanner();
    public static final double METRE = 100.0;  // pixels per metre

    @FXML
    private Button submit_final;

    @FXML
    private TextField bedTopValue;

    @FXML
    private Pane garden;

    @FXML
    public void initialize() {
        planner.createBasicDesign();

        updateGUI();
        bedTopValue.setText(Double.toString(planner.getBeds().get(0).getTop()));

        System.out.println("Starting the initialization ...");

        bedTopValue.textProperty().addListener( e -> {
           System.out.println(bedTopValue.getText());
           double new_top = Double.parseDouble(bedTopValue.getText());
           System.out.println("new top is: " + Double.toString(new_top));
           planner.getBeds().get(0).setTop(new_top);

           updateGUI();
        });

        submit_final.setOnAction(e -> {
            do_something();
            submit_final.setText("Clicked");
        });
    }

    private void do_something() {
        System.out.println("Something happened!");
    }

    public void updateGUI() {
        garden.getChildren().clear();
        // example of how to show rectangular garden beds in Pane
        for (RectBed bed : planner.getBeds()) {
            double left = bed.getLeft() * METRE;
            double top = bed.getTop() * METRE;
            double width = bed.getWidth() * METRE;
            double height = bed.getHeight() * METRE;
            Paint color = Paint.valueOf("saddlebrown");
            Rectangle r = new Rectangle(left, top, width, height);
            r.setFill(color);
            garden.getChildren().add(r);
        }
    }

}
