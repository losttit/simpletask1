import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// A simple calculator 3.0
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String digit;
    static Map<String, Integer> roman_values = new HashMap<String, Integer>();
    static {
        roman_values.put("I", 1);
        roman_values.put("II", 2);
        roman_values.put("III", 3);
        roman_values.put("IV", 4);
        roman_values.put("V", 5);
        roman_values.put("VI", 6);
        roman_values.put("VII", 7);
        roman_values.put("VIII", 8);
        roman_values.put("IX", 9);
        roman_values.put("X", 10);
    }
    private static boolean isRomanNumeral(String input){
        return input.matches("[IVX]+");
    }
    public static String calc(String input) {
        String[] expression = input.split(" ");
        int dig1 = 0;
        int dig2 = 0;

        if (isRomanNumeral(expression[0]) && isRomanNumeral(expression[2])){
            dig1 = roman_values.get(expression[0]);
            dig2 = roman_values.get(expression[2]);
        } else {
            dig1 = Integer.parseInt(expression[0]);
            dig2 = Integer.parseInt(expression[2]);
        }

        if (dig1 >= 1 && dig1 <= 10 && dig2 >= 1 && dig2 <= 10){
            switch (expression[1]){
                case "+":
                    digit = String.valueOf(dig1 + dig2);
                    break;
                case "-":
                    digit = String.valueOf(dig1 - dig2);
                    break;
                case "/":
                    digit = String.valueOf(dig1 / dig2);
                    break;
                case "*":
                    digit = String.valueOf(dig1 * dig2);
                    break;
                default:
                    digit = "Choose one of the signs: +, -, /, *";
            }
        } else {
            digit = "The number is not in the range from 1 to 10";
        }

        return digit;
    }

    public static void main(String[] args){
        System.out.println(calc(sc.nextLine()));
    }
}