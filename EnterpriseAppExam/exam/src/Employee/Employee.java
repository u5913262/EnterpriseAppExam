package Employee;

public class Employee {

    private String name;
    private String lastName;
    private int employee_no;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = lastName;
    }

    public int getEmployee_no() {return employee_no;}

    public void setEmployee_no(int employee_no) {
        this.employee_no = employee_no;
    }

    public String getGender() {return gender;}

    public void setGender() {this.gender = gender;}
}
