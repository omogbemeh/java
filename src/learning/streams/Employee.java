package learning.streams;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int empID;
    private final int salary;
    private final String gender;
    private final String email;

    public Employee(String firstName, String lastName, int empID, int salary, String gender, String email, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empID = empID;
        this.salary = salary;
        this.gender = gender;
        this.email = email;
    }

    public static Employee createEmployee (String str) {
        String[] empInfoArr = str.split(",");
        int empID = Integer.parseInt(empInfoArr[0]);
        String firstName = empInfoArr[1];
        String lastName = empInfoArr[2];
        String gender = empInfoArr[5];
        String email = empInfoArr[6];
        String state = empInfoArr[32];
        int salary = Integer.parseInt(empInfoArr[25]);
        return new Employee(firstName, lastName, empID, salary, gender, email, state);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmpID() {
        return empID;
    }

    public int getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
}
