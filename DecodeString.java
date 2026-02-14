import java.util.*;

public class DecodeString {

    public static String decodeString(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> stringStack = new Stack<>();

        String temp = "";
        String result = "";

        for (int i = 0; i < str.length(); i++) {

            int count = 0;

            // Case 1: Digit
            if (Character.isDigit(str.charAt(i))) {
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    count = count * 10 + (str.charAt(i) - '0');
                    i++;
                }
                i--;
                integerStack.push(count);
            }

            // Case 2: Closing bracket
            else if (str.charAt(i) == ']') {
                temp = "";

                if (!integerStack.isEmpty()) {
                    count = integerStack.pop();
                }

                // Build string inside [...]
                while (!stringStack.isEmpty() && stringStack.peek() != '[') {
                    temp = stringStack.pop() + temp;
                }

                // Remove '['
                if (!stringStack.isEmpty() && stringStack.peek() == '[') {
                    stringStack.pop();
                }

                // Repeat temp 'count' times
                result = "";
                for (int j = 0; j < count; j++) {
                    result += temp;
                }

                // Push result back to stack
                for (char ch : result.toCharArray()) {
                    stringStack.push(ch);
                }
            }

            // Case 3: Opening bracket
            else if (str.charAt(i) == '[') {
                stringStack.push(str.charAt(i));
            }

            // Case 4: Character
            else {
                stringStack.push(str.charAt(i));
            }
        }

        // Final string build
        result = "";
        while (!stringStack.isEmpty()) {
            result = stringStack.pop() + result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[cv]"));      // cvcv
        System.out.println(decodeString("3[b2[v]]"));   // bvvbvvbvv
    }
}

