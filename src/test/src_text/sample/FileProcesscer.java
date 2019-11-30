package sample;

import java.io.*;

public class FileProcesscer {
    private String[] nameList;
    private int[] scoreList;
    private String name;
    private int score;

    public FileProcesscer(int numOfElement){
        this.nameList = new String[numOfElement];
        this.scoreList = new int[numOfElement];
    }

    public boolean insertElement(String name, int score){
        String tempName;
        int tempScore;

        for(int iTemp = 0; iTemp < nameList.length; iTemp++){
            if(score > scoreList[iTemp]){
                tempScore = score;
                score = scoreList[iTemp];
                scoreList[iTemp] = tempScore;
                tempName = name;
                name = nameList[iTemp];
                nameList[iTemp] = tempName;
            }
        }
        return true;
    }

    public void readFile(String filePath) throws IOException {
//        int scoreNode;
//        String scoreString;

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for(int iTemp = 0; iTemp < nameList.length; iTemp++){
            nameList[iTemp] = bufferedReader.readLine();
            if(nameList[iTemp] != null){
//                System.out.println(nameList[iTemp]);
//                scoreString = bufferedReader.readLine();
                scoreList[iTemp] = Integer.valueOf(bufferedReader.readLine());
            }else{
                nameList[iTemp] = "Empty";
                scoreList[iTemp] = -1;
            }
        }

        bufferedReader.close();
        fileReader.close();
    }

    public void showLists(){
        for(int iTemp = 0; iTemp < nameList.length; iTemp++){
            System.out.println(nameList[iTemp] + " - " + scoreList[iTemp]);
        }
    }

    public void writeFile(String filePath) throws IOException{
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file, false);

        for(int iTemp = 0; iTemp < nameList.length; iTemp++){
            fileWriter.write(nameList[iTemp] + "\n");
            fileWriter.write(scoreList[iTemp] + "\n");
            fileWriter.flush();
        }

    }
}