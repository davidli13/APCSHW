import java.io.*;
import java.util.*;
public class WordGrid{
    private char[][]data;
    private int row;
    private int col;
    private long seed;
    private ArrayList<String> words = new ArrayList<String>();
    Random r = new Random();

    /**Initialize the grid to the size specified and fill all of the positions
    *with spaces.
    *@param row is the starting height of the WordGrid
    *@param col is the starting width of the WordGrid
    */
    public WordGrid(int row, int col, long seed){
        data = new char[row][col];
        this.row = row;
        this.col = col;
        this.seed = seed;
        r = new Random(seed);
        clear();
    }

    public WordGrid(int row, int col){
        this(row,col,(long) 0);
    }

    public WordGrid(){
        this(15,15,(long) 0);
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

    public boolean addWords(ArrayList<String> list){
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            int dx = r.nextInt(3) - 1;
            int dy = r.nextInt(3) - 1;
            if (count >= row * col / 10){
                return true;
            }
            if (addWord(list.get(i),r.nextInt(row),r.nextInt(col),dx,dy)){
                count++;
            }            
        }
        return false;
    }

    public void fillRandomLetters(){
        for (int row = 0; row < data.length; row++){
            for (int col = 0; col < data[row].length; col++){
                if (data[row][col] == '-'){
                    data[row][col] = (char)('A' + r.nextInt(26));
                }
            }
        }
    }
    public void loadWordsFromFile(String filename, boolean fillRandomLetters){
        try{
            ArrayList<String> wordBank = new ArrayList<String>();
            File f = new File(filename);
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                wordBank.add(s.nextLine());
            }
            addWords(wordBank);
            if(fillRandomLetters){
                fillRandomLetters();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }
    }

    public String wordsInPuzzle(){
        String w = "";
        try{
            int counter = 0;
            for (int i = 0; i < words.size(); i++){
                if (counter < 4){
                    w += words.get(i) + " ";
                    counter++;
                }else{
                    w += "\n" + words.get(i) + " ";
                    counter = 0;
                }
            }
        }
        catch (IndexOutOfBoundsException e){
        }
        return w;
    }

    public void setSeed(long seed){
        r.setSeed(seed);
    }
    
    public static void main(String[]args){
        WordGrid g = new WordGrid();
        System.out.println(g.wordsInPuzzle());
        g.loadWordsFromFile("WordList.txt",true);
        System.out.println(g.toString());
        System.out.println(g.wordsInPuzzle());
    }
}
