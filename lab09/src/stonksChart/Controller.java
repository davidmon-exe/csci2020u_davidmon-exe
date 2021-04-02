package stonksChart;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.*;

public class Controller {

    @FXML public Canvas canvasChart;
    @FXML public GraphicsContext gcChart;
    public static ArrayList<String> close = new ArrayList<>();
    public static ArrayList<String> date = new ArrayList<String>();
    public static ArrayList<String> open = new ArrayList<String>();
    public static ArrayList<String> high = new ArrayList<String>();
    public static ArrayList<String> low = new ArrayList<String>();
    public static ArrayList<String> adjClose = new ArrayList<String>();
    public static ArrayList<String> volume = new ArrayList<String>();
    @FXML public Canvas canvasLegend;
    @FXML public GraphicsContext gcLegend;

    public void initialize() throws IOException {
        gcChart = canvasChart.getGraphicsContext2D();
        gcLegend = canvasLegend.getGraphicsContext2D();
        drawLinePlot(Color.BLACK);
    }

    private void drawLinePlot(Color colour) {
        gcChart.setStroke(colour);
        //y axis black line
        gcChart.strokeLine(50,850, 50,  50);
        //x axis black line
        gcChart.strokeLine(50,850, 950,  850);

        //Load Data for first stock then plot its line
        GetFile.getFile("https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
        plotLine(close, Color.RED);
        gcLegend.setFill(Color.RED);
        gcLegend.fillRect(150, 50, 20, 20);
        gcLegend.setFill(Color.BLACK);
        gcLegend.fillText("GOOG", 180, 60);
        // Clear data currently loaded into each arraylist
        GetFile.clearData();

        //Load data for second stock then plot its line
        GetFile.getFile("https://query1.finance.yahoo.com/v7/finance/download/AMZN?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
        plotLine(close, Color.BLUE);
        gcLegend.setFill(Color.BLUE);
        gcLegend.fillRect(600, 50, 20, 20);
        gcLegend.setFill(Color.BLACK);
        gcLegend.fillText("AMZN", 630, 60);
    }

    public void plotLine(ArrayList<String> data, Color colour){
        gcChart.setStroke(colour);
        for(int i = 1; i < data.size()-1; i++){
            gcChart.strokeLine(40+(i*10),850 - Double.parseDouble(data.get(i)),40+((i+1)*10),850 - Double.parseDouble(data.get(i+1)));

        }
    }
}
