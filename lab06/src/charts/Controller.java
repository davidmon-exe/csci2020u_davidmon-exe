package charts;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {
    @FXML private Canvas barCanvas;
    @FXML public GraphicsContext bar;
    @FXML private Canvas pieCanvas;
    @FXML public GraphicsContext pie;
    private static final double[] avgHousingPricesByYear = {
        247381.0,264171.4,287715.3,294736.1,
                308431.4,322635.9,340253.0,363153.7
    };
    private static final double[] avgCommercialPricesByYear = {
        1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {"18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = {648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON , Color.LAWNGREEN  , Color.PLUM
    };

    @FXML
    public void initialize() {
        bar = barCanvas.getGraphicsContext2D();
        drawGraph(100,300,avgHousingPricesByYear,Color.RED,0);
        drawGraph(100, 300, avgCommercialPricesByYear, Color.BLUE,100/avgCommercialPricesByYear.length );

        pie = pieCanvas.getGraphicsContext2D();
        drawPie(300, 300);
    }

    public void drawGraph(int w, int h, double[] data, Color houseColor, int startX) {
        bar.setFill(houseColor);
        double width = (w / data.length);
        double x = startX;

        double maxVal = 1500000.0;
        double minVal = 0.0;


        for (double val : data) {
            double height = ((val - minVal) / (maxVal - minVal)) * h;

            bar.fillRect(x + 150, (h - height) + 150, width,  height+ 10);
            x += 2.5 * width;
        }
    }
    public void drawPie(int w, int h){
        int numPurchases = 0;
        for (int purchasesPerAgeGroup:purchasesByAgeGroup){
            numPurchases += purchasesPerAgeGroup;
        }
        double startAngle = 0.0;
        for(int i=0;i < ageGroups.length; i++){
            double slicePercentage = (double) purchasesByAgeGroup[i] / (double) numPurchases;
            double sweepAngle = slicePercentage * 360.0;

            pie.setFill(pieColours[i]);
            pie.fillArc(100,100, w, h,startAngle,sweepAngle, ArcType.ROUND);

            startAngle += sweepAngle;
        }
    }

}

