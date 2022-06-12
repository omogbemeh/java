package Regex;

public class Regex {
    public static void main(String[] args) {
        boolean isMatch = parsePhoneNumber("4222.334.5675");
        System.out.println(isMatch);
    }

    public static boolean parsePhoneNumber (String str) {
//        This method should detect if a string matches a US number; 1.233.453.2343 or 233.453.5674
        String finalStr = str;
        String regexStr = "(\\d[\\s-.,]*)?(\\d{3}[\\s-.,]*){1,2}\\d{4}";
        return finalStr.matches(regexStr);
    }
}
