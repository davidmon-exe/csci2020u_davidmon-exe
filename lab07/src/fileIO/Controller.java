package fileIO;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.util.*;

public class Controller {

    @FXML public Canvas chartCanvas;
    @FXML public GraphicsContext gcChart;
    @FXML public Canvas legendCanvas;
    @FXML public GraphicsContext gcLegend;
    public static TreeMap<String, Integer> warningCounts = new TreeMap<String, Integer>();
    private static final Color[] pieColours = { Color.BLUE, Color.RED,
            Color.GREEN, Color.YELLOW, Color.PURPLE, Color.TEAL};

    public static int totalCount = 0;

    @FXML
    public void initialize(){
        gcChart = chartCanvas.getGraphicsContext2D();
        gcLegend = legendCanvas.getGraphicsContext2D();
        FileLoader file = new FileLoader("resources/weatherwarnings-2015.csv");
        file.loadFile();
        for (Map.Entry<String, Integer> entry : warningCounts.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
        drawChart(150, 25);
    }

    private void drawChart(int x, int y) {
        Map<String, Double> slicePercentage = new TreeMap<String, Double>();
        for (Map.Entry<String, Integer> entry: warningCounts.entrySet()) {
            String warning = entry.getKey();
            Double val = Double.valueOf(entry.getValue());
            slicePercentage.put(warning, (val / totalCount));
        }
        int i = 0;
        int a = 50;
        double startAngle = 0.0;
        for (Map.Entry<String, Double> entry : slicePercentage.entrySet()){
            gcChart.setFill(pieColours[i]);
            gcLegend.setFill(pieColours[i]);
            i++;
            double endAng = startAngle + entry.getValue() * 360;
            gcChart.fillArc(x, y,200,200,startAngle,endAng - startAngle, ArcType.ROUND);
            startAngle = endAng;
            gcLegend.fillRect(x-150, a+10, 20, 10);
            gcLegend.setFill(Color.BLACK);
            gcLegend.fillText(entry.getKey(),x-125,a+20);
            a += 30;
        }

    }
}
