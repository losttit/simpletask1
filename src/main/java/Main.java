import java.util.Scanner;
// A simple calculator 1.0
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String digit;
    public static String calc(String input) {
        String[] expression = input.split(" ");
        int dig1 = Integer.parseInt(expression[0]);
        int dig2 = Integer.parseInt(expression[2]);
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