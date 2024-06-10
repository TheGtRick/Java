public class Activity15A {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30, "123 Main St", "555-1234");
        System.out.println(person.toString());
        Student student = new Student("Jane Smith", 20, "456 Park Ave", "555-5678", 1234, "Computer Science");
        System.out.println(student.toString());
        Teacher teacher = new Teacher("Bob Johnson", 45, "789 Broadway", "555-9012", "Math");
        System.out.println(teacher.toString());
    }
}
class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    public Person(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address='" + address + ", phoneNumber='" + phoneNumber + "]";
    }
}
class Student extends Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private int studentID;
    private String major;
    public Student(String name, int age, String address, String phoneNumber, int studentID, String major) {
        super(name, age, address, phoneNumber);
        this.studentID = studentID;
        this.major = major;
    }
    public int getStudentID() {
        return studentID;
    }
    public String getMajor() {
        return major;
    }
    public void setId(int studentID) {
        this.studentID = studentID;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString() {
        return "Student [name=" + super.getName() + ", age=" + super.getAge() + ", address='" + super.getAddress() + ", phoneNumber='" + super.getPhoneNumber() + "', studentID=" + studentID + ", major='" + major + "']";
    }
}
class Teacher extends Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String subject;
    public Teacher(String name, int age, String address, String phoneNumber, String subject) {
            super(name, age, address, phoneNumber);
            this.subject = subject;
    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public String toString() {
        return "Teacher [name=" + super.getName() + ", age=" + super.getAge() + ", address='" + super.getAddress() + ", phoneNumber='" + super.getPhoneNumber() + "', subject='" + subject + "']";
    }
}