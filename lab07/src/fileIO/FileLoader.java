package fileIO;

import java.io.*;

public class FileLoader {
    private final String filename;

    public FileLoader(String filename){
        this.filename = filename;
    }

    public void loadFile(){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            while ((line = br.readLine())!=null){
                String[] columns = line.split(",");

                if (Controller.warningCounts.containsKey(columns[5])){
                    int prev = Controller.warningCounts.get(columns[5]);
                    Controller.warningCounts.put(columns[5], prev + 1);
                } else{
                    Controller.warningCounts.put(columns[5], 1);
                }
                Controller.totalCount++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
