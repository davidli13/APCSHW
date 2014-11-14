import java.util.*;
public class ArrayListMethods{
        public static void collapseDuplicates(ArrayList<Integer> L){
                for(int i=0; i < L.size()-1; i++){
                        if(L.get(i).equals(L.get(i+1))){
                                L.remove(i);
                                i--;
                        }
                }
        }      
        public static void randomize(ArrayList<Integer> L){
                ArrayList<Integer> copy = new ArrayList<Integer>();
                for(int i = 0; i < L.size(); i++){
                        copy.add(L.get(i));
                }
                L.clear();
                while(copy.size() != 0){
                        Random r = new Random();
                        L.add(copy.remove(r.nextInt(copy.size())));
                }
        }
        public static void main(String[]args){
                ArrayList<Integer> L = new ArrayList<Integer>();
                for (int i = 0; i < 20;i++){
                        L.add(i);
                        L.add(i);
                }
                collapseDuplicates(L);
                System.out.println(L);
                randomize(L);
                System.out.println(L);
        }
}