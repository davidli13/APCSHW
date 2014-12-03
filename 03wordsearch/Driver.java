public class Driver{
    public static void main(String[]args){
        if (args.length == 2){            
            WordGrid w = new WordGrid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            w.loadWordsFromFile("WordList.txt",0);
            return;
        }
        if (args.length == 3){            
            WordGrid w = new WordGrid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            w.setSeed(Integer.parseInt(args[2]));
            w.loadWordsFromFile("WordList.txt",0);
            return;
        }
        if (args.length == 4){            
            WordGrid w = new WordGrid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            w.setSeed(Integer.parseInt(args[2]));
            w.loadWordsFromFile("WordList.txt",Integer.parseInt(args[3]));
            return;
        }

        System.out.println("\nIncorrect Syntax, default values were used");
        System.out.println("Correct Syntax:");
        System.out.println("java WordGrid <rows> <cols> <filename> <filled> [seed]\n");
        WordGrid w = new WordGrid();
        w.loadWordsFromFile("WordList.txt",0);

    }
}