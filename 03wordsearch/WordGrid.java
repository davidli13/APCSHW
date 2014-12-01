import java.io.*;
import java.util.*;
public class WordGrid{
    private char[][]data;
    private long seed;
    private ArrayList<String> words = new ArrayList<String>();
    Random r = new Random();

    /**Initialize the grid to the size specified and fill all of the positions
    *with spaces.
    *@param row is the starting height of the WordGrid
    *@param col is the starting width of the WordGrid
    */
    public WordGrid(int rows,int cols){
        data = new char[rows][cols];
        clear();
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
        for(int r = 0; r < data.length; r++){
            for (int c = 0; c < data[r].length; c++){
                data[r][c] = '-';
            }  
        }
    }
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
        String ret = "";
        for(int r = 0; r < data.length; r++){
            for (int c = 0; c < data[r].length; c++){
                ret += data[r][c] + " ";
            }
            ret += "\n";
        }
        return ret;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
        if (data[0].length - col >= word.length()){
            for (int i = 0; i < word.length(); i++){
                data[row][col+i] = word.charAt(i);
            }
            return true;
        }else if (col >= word.length()){
            for (int i = 0; i < word.length(); i++){
                if(data[row][col-i] != ' ' & data[row][col-i] != word.charAt(i)){
                    return false;
                }
                data[row][col-i] = word.charAt(i);
            }
            return true;
        }
        return false;
    }
    
    public boolean addWord(String word,int row, int col, int changeRow, int changeCol){
        int r = row;
        int c = col;
        try{
            for (int i = 0; i < word.length(); i++){
                if (data[r][c] != '-' && data[r][c] != word.charAt(i)){
                    return false;
                }   
                r += changeRow;
                c += changeCol;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        r = row;
        c = col;
        for (int i = 0; i < word.length(); i++){
            data[r][c] = word.charAt(i);
            r += changeRow;
            c += changeCol;
        }
        words.add(word);
        return true;
    }

    public void loadWordsFromFile(String fileName, boolean fillRandomLetters) throws FileNotFoundException{
        File text = new File(fileName);
        Scanner scan = new Scanner(text);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            words.add(line);
        }
    }


    public void setSeed(long seed){
        r.setSeed(seed);
    }
    
    public static void main(String[]args){
        WordGrid g = new WordGrid(9,9);
        System.out.println(g.toString());
        g.addWord("tesd",5,5,0,1);
        g.addWord("vegetablearegay",4,4,0,1);
        g.addWord("cat",8,6,0,1);
        System.out.println(g.toString());
    }
}
