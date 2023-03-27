import java.util.HashMap;

public class second {
    public static void findSecondMostFrequentChar(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("String is empty or null");
            return;
        }
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if(ch != ' '){
                charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            }
        }
        int max = 0;
        int secondMax = 0;
        char result = 0;
        char preresult = 0;
        for (HashMap.Entry<Character, Integer> entry : charMap.entrySet()) {
            int value = entry.getValue();
            if (value > max) {
                secondMax = max;
                max = value;
                preresult = result;
                result = entry.getKey();
            } else if (value > secondMax && value < max) {
                preresult = entry.getKey();
                secondMax = value;
            }
        }
        if (secondMax == 0) {
            System.out.println("There is no second most frequent character");
        } else {
            System.out.println("The second most frequent character is " + result + " and it appears " + max + " times.");
            System.out.println("The second most frequent character is " + preresult + " and it appears " + secondMax + " times.");
        }
    }
    public static void main(String args[]){
        findSecondMostFrequentChar("ahihi khong biet co ra khong nua.");
    }
    
}
