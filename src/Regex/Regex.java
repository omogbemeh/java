package Regex;

public class Regex {
    public static void main(String[] args) {
//        boolean isMatch = parsePhoneNumber("4222.334.5675");
        boolean isMatch2 = parseString("stark");
        System.out.println(isMatch2);
    }

    public static boolean parsePhoneNumber (String str) {
//        This method should detect if a string matches a US number; 1.233.453.2343 or 233.453.5674
        String finalStr = str;
        String regexStr = "(\\d[\\s-.,]*)?(\\d{3}[\\s-.,]*){1,2}\\d{4}";
        return finalStr.matches(regexStr);
    }

     public static boolean parseString(String str) {
//         Write a regex that would match the following words: Dark, bark, Lark
//         1. For extra challenge, could you additionally make it match: stark
        String finalStr = str;
        String regexStr = "[LDb]?(st)?ark";
        return finalStr.matches(regexStr);
     }
}
