import java.util.Scanner;

class Person {
    private String name;
    private String contactNum;
    
    public void setName(String n) {
        this.name = n;
    }
    
    public String getName() {
        return name;
    }
    
    public void setContactNum(String c) {
        this.contactNum = c;
    }
    
    public String getContactNum() {
        return contactNum;
    }
}

class Employee extends Person {
    private double salary;
    private String department;
    
    public void setSalary(double s) {
        this.salary = s;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setDepartment(String d) {
        this.department = d;
    }
    
    public String getDepartment() {
        return department;
    }
}

class Faculty extends Employee {
    private boolean isRegular;
    
    public void setRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }
    
    public boolean isRegular() {
        return isRegular;
    }
}


class Student extends Person {
    private String program;
    private int yearLevel;
    
    public void setProgram(String p) {
        this.program = p;
    }
    
    public String getProgram() {
        return program;
    }
    
    public void setYearLevel(int y) {
        this.yearLevel = y;
    }
    
    public int getYearLevel() {
        return yearLevel;
    }
}


public class CollegeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Press E for Employee, F for Faculty, or S for Student: ");
        String category = sc.nextLine();
        
        // Common for all types
        System.out.println("Type " + (category.equalsIgnoreCase("E") ? "employee's" : category.equalsIgnoreCase("F") ? "faculty's" : "student's") + " name:");
        String name = sc.nextLine();
        
        System.out.println("Type contact number:");
        String contact = sc.nextLine();
        
        if (category.equalsIgnoreCase("E")) {
            Employee emp = new Employee();
            emp.setName(name);
            emp.setContactNum(contact);
            
            System.out.println("Type employee's monthly salary:");
            while (!sc.hasNextDouble()) {
                System.out.println("Please enter a valid number for salary.");
                sc.next();
            }
            double salary = sc.nextDouble();
            emp.setSalary(salary);
            
            sc.nextLine();  
            System.out.println("Type department where employee belongs (Ex. Registrar):");
            String dept = sc.nextLine();
            emp.setDepartment(dept);
            
            System.out.println("-------------------------------");
            System.out.println("Name: " + emp.getName());
            System.out.println("Contact Number: " + emp.getContactNum());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("Department: " + emp.getDepartment());
        } 
        else if (category.equalsIgnoreCase("F")) {
            Faculty faculty = new Faculty();
            faculty.setName(name);
            faculty.setContactNum(contact);
            
            System.out.println("Type faculty's monthly salary:");
            while (!sc.hasNextDouble()) {
                System.out.println("Please enter a valid number for salary.");
                sc.next();
            }
            double salary = sc.nextDouble();
            faculty.setSalary(salary);
            
            sc.nextLine();  
            System.out.println("Type department where faculty belongs (Ex. Registrar):");
            String dept = sc.nextLine();
            faculty.setDepartment(dept);
            
            System.out.println("Press Y if the faculty member is regular/tenured, N if not:");
            String regular = sc.nextLine();
            faculty.setRegular(regular.equalsIgnoreCase("Y"));
            
            System.out.println("-------------------------------");
            System.out.println("Name: " + faculty.getName());
            System.out.println("Contact Number: " + faculty.getContactNum());
            System.out.println("Salary: " + faculty.getSalary());
            System.out.println("Department: " + faculty.getDepartment());
            System.out.println("Status: " + (faculty.isRegular() ? "Regular" : "Not Regular"));
        } 
        else if (category.equalsIgnoreCase("S")) {
            Student student = new Student();
            student.setName(name);
            student.setContactNum(contact);
            
            System.out.println("Type student's enrolled program (Ex. BSIT, BSTM, BSHM):");
            String program = sc.nextLine();
            student.setProgram(program);
            
            System.out.println("Type student's year level (1-4):");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid integer for year level (1-4).");
                sc.next();
            }
            int yearLevel = sc.nextInt();
            student.setYearLevel(yearLevel);
            
            System.out.println("-------------------------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Contact Number: " + student.getContactNum());
            System.out.println("Program: " + student.getProgram());
            System.out.println("Year Level: " + student.getYearLevel());
        } else {
            System.out.println("Invalid category selected!");
        }
        
        sc.close();
    }
}
