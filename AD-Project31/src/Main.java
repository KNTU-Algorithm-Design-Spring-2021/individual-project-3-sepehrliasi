import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Dictionary myDictionary = new Dictionary();
        HashMap<String,String> dictionary = myDictionary.getDictionary();

        String str = inputReader();//Reads string from input

        ArrayList<Integer> answer = new ArrayList<>();
        recursive(answer,0,str,dictionary);
        answer.add(0);

        for (int i = answer.size()-1;i > 0;i--){
            System.out.print(str.substring(answer.get(i), answer.get(i-1)) + " ");
        }
    }

    public static int recursive(ArrayList<Integer> answers, int from, String str, HashMap<String,String> dictionary){
        for (int i = from+1;i <= str.length();i++){
            String s = str.substring(from,i);
            s = s.toLowerCase();
            if (dictionary.containsKey(s)){
                if (i == str.length()){
                    answers.add(i);
                    return 1;
                }else {
                    int j = recursive(answers, i, str, dictionary);
                    if (j == 1){
                        answers.add(i);
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    public static String inputReader(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
