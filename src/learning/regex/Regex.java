package learning.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
//        boolean isMatch = parsePhoneNumber("4222.334.5675");
//        boolean isMatch2 = parseString("stark");
//        System.out.println(parseTranscript());
//        System.out.println(matchStrings());
//        System.out.println(isEmail("p9ise.@stu.mc.edu.ca"));
        System.out.println(parseAddress());
    }

    public static boolean parsePhoneNumber (String str) {
//        This method should detect if a string matches a US number; 1.233.453.2343 or 233.453.5674
//        String finalStr = str;
//        String regexStr = "(\\d[\\s-.,]*)?(\\d{3}[\\s-.,]*){1,2}\\d{4}";
//        return finalStr.matches(regexStr);

//        Parsing using named groups.
        String phoneNum = "1    234 567-8900";
        String regex = "((?<countryCode>1)[-.,\\s]*)?(\\(?(?<areaCode>\\d{3})\\)?[\\s-,.]*)((?<exchange>\\d{3})[\\s-,.]*)((?<lineNumber>\\d{4})\\s*)";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(phoneNum);

        if (mat.matches()) {
            System.out.printf("Country code: %s\n", mat.group("countryCode"));
            System.out.printf("Area code: %s\n", mat.group("areaCode"));
            System.out.printf("Exchange code: %s\n", mat.group("exchange"));
            System.out.printf("LineNumber code: %s\n", mat.group("lineNumber"));
        }

        return mat.matches();
    }

     public static boolean parseString(String str) {
//         Write a regex that would match the following words: Dark, bark, Lark
//         1. For extra challenge, could you additionally make it match: stark
        String finalStr = str;
        String regexStr = "[LDb]?(st)?ark";
        return finalStr.matches(regexStr);
     }

     public static boolean miscParse() {
        String testStr = "the boys";
        String regex = "\\b....\\s....";
        Pattern pat = Pattern.compile(regex);
        Matcher mat= pat.matcher(testStr);

        if (mat.matches()) return true;

        return false;
     }

     public static String parseTranscript() {
        String text = """
                    Student Number:	1234598872			Grade:		11
                    Birthdate:		01/02/2000			Gender:	M
                    State ID:		8923827123
                    
                    Cumulative GPA (Weighted)		3.82
                    Cumulative GPA (Unweighted)	3.46
                """.strip();
        String transcript = text;
        String studentId, grade, birthDay, birthMonth, birthYear, gender, stateID, weightedGPA, unweightedGPA;
        String regex = """
            ^Student\\s*Number:\\s*(?<studentID>\\d{10}) #Gets the student Number
            \\s*Grade:\\s*(?<grade>\\d{1,2}) #Gets the students grade
            \\s*Birthdate\\s*:\\s*(?<birthMonth>\\d{2})/(?<birthDay>\\d{2})/(?<birthYear>\\d{4}) #Get's birthdate info
            \\s*Gender:\\s*(?<gender>[MmFf]) #Get's the gender
            \\s*State\\s*ID:\\s*(?<stateID>\\d{10}) #Get's stateID
            \\s*Cumulative\\s*GPA\\s*\\(Weighted\\)\\s*(?<weightedGPA>\\d.\\d{2}) #Get's the weighted GPA
            \\s*Cumulative\\s*GPA\\s*\\(Unweighted\\)\\s*(?<unweightedGPA>\\d.\\d{2})\\s* #Get's the unweighted GPA
        """;
        Pattern transcriptPat = Pattern.compile(regex, Pattern.COMMENTS);
        Matcher transcriptMatcher = transcriptPat.matcher(transcript);

        if (transcriptMatcher.matches()) {
            StringBuilder finalStrBuilder = new StringBuilder();
            studentId = transcriptMatcher.group("studentID");
            grade = transcriptMatcher.group("grade");
            birthDay = transcriptMatcher.group("birthDay");
            birthMonth = transcriptMatcher.group("birthMonth");
            birthYear = transcriptMatcher.group("birthYear");
            gender = transcriptMatcher.group("gender");
            stateID = transcriptMatcher.group("stateID");
            weightedGPA = transcriptMatcher.group("weightedGPA");
            unweightedGPA = transcriptMatcher.group("unweightedGPA");

            finalStrBuilder
                    .append("Student Number: ").append(studentId).append("\n")
                    .append("Grade: ").append(grade).append("\n")
                    .append("Birthday: ").append(birthDay).append("\n")
                    .append("BirthMonth: ").append(birthMonth).append("\n")
                    .append("BirthYear: ").append(birthYear).append("\n")
                    .append("Gender: ").append(gender).append("\n")
                    .append("State ID: ").append(stateID).append("\n")
                    .append("Weighted GPA: ").append(weightedGPA).append("\n")
                    .append("Unweighted GPA: ").append(unweightedGPA).append("\n");

            return finalStrBuilder.toString();
        }
        return "Doesn't match bro";
    }

    public static boolean matchStrings() {
        String text = "Abracadabra or Agracadagra";
        String regex = "(?<abracadabra>Abracadabra) or (?<agracadagra>Agracadagra)";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(text);
        if (mat.matches()) return true;
        return false;
    }

    public static boolean isEmail(String str) {
//        Parse school email address
//        Example: praise.omogbemeh@stu.mc.edu.ca true
//                 -er@stu.mc.edu.ca false
        String email = str;
        String regex = "\\w+\\.\\w+@stu.mc.edu.ca";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(email);
        if (mat.matches()) return true;
        return false;
    }

    public static String parseAddress() {
        String address = """
                Country: Canada    Province: Ontario
                City: Stoney Creek      Street Address: King Street W.
                House Number: 49    Unit: 67 
                """.strip();

        String regex = """
                Country:\\s*(?<country>\\w{2,})\\b.*
                Province:\\s*(?<province>\\w{2,})\\b.*
                City:\\s*(?<city>(\\w+\\s*)(\\w+\\s*)?(\\w+\\s*)?)\\b.* #Gets the city.
                Street\\s*Address:\\s*(?<streetAddress>(\\w+\\s*)(\\w+\\s*)?(\\w+\\s*)?(\\w+\\s*)?)\\b.* #Gets the street address.
                House\\sNumber:\\s*(?<houseNumber>\\d+)\\b.*
                Unit:\\s*(?<unitNumber>\\d+)
                """;

//        System.out.printf("'%s'\n",address);

        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS | Pattern.DOTALL);
        Matcher mat = pat.matcher(address);

        if (mat.matches()) {
            StringBuilder finalStr = new StringBuilder()
                    .append("Country: ").append(mat.group("country")).append("\n")
                    .append("Province: ").append(mat.group("province")).append("\n")
                    .append("City: ").append(mat.group("city")).append("\n")
                    .append("Street Address: ").append(mat.group("streetAddress")).append("\n")
                    .append("House Number: ").append(mat.group("houseNumber")).append("\n")
                    .append("Unit: ").append(mat.group("unitNumber")).append("\n");

            return finalStr.toString();
        }
        return "Didn't match";
    }
}
