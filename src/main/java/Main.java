import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// A simple calculator 4.0 / Final version
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String digit;
    static Map<String, Integer> roman_values = new HashMap<String, Integer>();
    static Map<Integer, String> roman_numerals = new HashMap<Integer, String>();
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

        roman_numerals.put(1, "I");
        roman_numerals.put(2, "II");
        roman_numerals.put(3, "III");
        roman_numerals.put(4, "IV");
        roman_numerals.put(5, "V");
        roman_numerals.put(6, "VI");
        roman_numerals.put(7, "VII");
        roman_numerals.put(8, "VIII");
        roman_numerals.put(9, "IX");
        roman_numerals.put(10, "X");
    }
    private static boolean isRomanNumeral(String input){
        return input.matches("[IVX]+");
    }
    private static String convertToRoman(int number) throws Exception {
        if (number < 1) {
            throw new Exception("Roman number cannot be negative.");
        } else if (number > 10) {
            throw new Exception("Result of a Roman number cannot be greater than 10.");
        }
        return roman_numerals.get(number);
    }
    public static String calc(String input) throws Exception {
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
            int result = 0;

            switch (expression[1]){
                case "+":
                    result = dig1 + dig2;
                    break;
                case "-":
                    result = dig1 - dig2;
                    break;
                case "/":
                    result = dig1 / dig2;
                    break;
                case "*":
                    result = dig1 * dig2;
                    break;
                default:
                    throw new Exception("Choose one of the signs: +, -, /, *");
            }
            if (isRomanNumeral(expression[0]) && isRomanNumeral(expression[2])){
                digit = convertToRoman(result);
            } else {
                digit = String.valueOf(result);
            }
        } else {
            throw new Exception("The number is not in the range from 1 to 10");
        }

        return digit;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(calc(sc.nextLine()));
    }
}