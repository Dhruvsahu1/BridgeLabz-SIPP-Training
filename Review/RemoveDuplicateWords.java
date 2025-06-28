import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateWords {

    public static String removeDuplicateWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        
        String[] words = sentence.split("\\s+");

        
        Set<String> uniqueWords = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (uniqueWords.add(word)) {  
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(word);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "this is is a test test sentence with duplicate duplicate words";
        String result = removeDuplicateWords(sentence);

        System.out.println(result);  
    }
}
