public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
    *with spaces.
    *@param row is the starting height of the WordGrid
    *@param col is the starting width of the WordGrid
    */
    public void WordGrid(int rows,int cols){
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
        int r = 0;
        int c = 0;
        for (int i = 0; i < word.length(); i++){
            data[row+r][col+c] = word.charAt(i);
            r += changeRow;
            c += changeCol;
        }
        return true;
    }
    
    public static void main(String[]args){
        WordGrid g = new WordGrid();
        g.WordGrid(9,9);
        System.out.println(g.toString());
        g.addWord("test",8,8,-1,-1);
        System.out.println(g.toString());
    }
}
