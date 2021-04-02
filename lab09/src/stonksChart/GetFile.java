package stonksChart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class GetFile {

    public static void getFile(String url){
        try {
            InputStream input = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreElements()){
                    Controller.date.add(st.nextToken());
                    Controller.open.add(st.nextToken());
                    Controller.high.add(st.nextToken());
                    Controller.low.add(st.nextToken());
                    Controller.close.add(st.nextToken());
                    Controller.adjClose.add(st.nextToken());
                    Controller.volume.add(st.nextToken());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Function That Clears All Current Data
    public static void clearData(){
        Controller.date.clear();
        Controller.open.clear();
        Controller.high.clear();
        Controller.low.clear();
        Controller.close.clear();
        Controller.adjClose.clear();
        Controller.volume.clear();
    }
}
