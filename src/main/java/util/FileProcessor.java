package util;

import java.io.*;

/**
 * <h1>FileProcessor</h1>
 *
 * <p>This class is a professional file processor which takes in
 * a file path and reads the data stores in the file. Also, it
 * could check whether a pair of name and score could be able to
 * store in the file.
 *
 * <p>It is applied in {@link gameApp.Main}, {@link controller.InputNameController} and {@link controller.HighScoreController}
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.3
 * @since 1.0
 * @see gameApp.Main
 * @see controller.InputNameController
 * @see controller.HighScoreController
 */
public class FileProcessor {
    /**
     * The list of player's names
     */
    private String[] nameList;
    /**
     * The list of players' scores
     */
    private int[] scoreList;
    /**
     * Number of the elements processor is going to handle
     */
    private int numOfElement;

    /**
     * Default constructor which could handle a list of 5 element
     */
    public FileProcessor(){
        this.numOfElement = 10;
        this.nameList = new String[numOfElement];
        this.scoreList = new int[numOfElement];
    }

    public FileProcessor(int numOfElement){
        this.numOfElement = numOfElement;
        this.nameList = new String[numOfElement];
        this.scoreList = new int[numOfElement];
    }

    /**
     * A method to check whether a score could be inserted into the function
     *
     * @param score: The target score user wants to insert into the file
     * @return  A boolean element indicates whether this the target score
     *          could be inserted into the file.
     */
    public boolean checkInsertable(int score){
        if(score > scoreList[numOfElement-1]){
            return true;
        }else{
            return false;
        }
    }

    /**
     * A method insert a pair of name and score into the file
     *
     * @param name: The target name user wants to insert into the file
     * @param score: The target score user wants to insert into the file
     */
    public void insertElement(String name, int score){
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
    }

    /**
     * This method reads in the file store in the filePath parameter
     *
     * @param filePath The absolute directory to access the txt file storing the
     *                  data of high score.
     * @throws IOException The exceptions always caused by invalid file path
     */
    public void readFile(String filePath) throws IOException {

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for(int iTemp = 0; iTemp < nameList.length; iTemp++){
            nameList[iTemp] = bufferedReader.readLine();
            if(nameList[iTemp] != null){
                scoreList[iTemp] = Integer.valueOf(bufferedReader.readLine());
            }else{
                nameList[iTemp] = "Empty";
                scoreList[iTemp] = -1;
            }
        }

        bufferedReader.close();
        fileReader.close();
    }

    /**
     * Print out the list which have already been read in
     */
    public void showLists(){
        for(int iTemp = 0; iTemp < nameList.length; iTemp++){
            System.out.println(nameList[iTemp] + " - " + scoreList[iTemp]);
        }
    }

    /**
     * This method writes in the file store in the filePath parameter
     *
     * @param filePath The absolute directory to access the txt file storing the
     *                  data of high score.
     * @throws IOException The exceptions always caused by invalid file path
     */
    public void writeFile(String filePath) throws IOException{
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file, false);

        for(int iTemp = 0; iTemp < nameList.length; iTemp++){
            fileWriter.write(nameList[iTemp] + "\n");
            fileWriter.write(scoreList[iTemp] + "\n");
            fileWriter.flush();
        }
    }

    public int getHighScore(){return this.scoreList[0];}

    public int[] getScore(){return this.scoreList;}

    public String[] getName(){return this.nameList;}
}