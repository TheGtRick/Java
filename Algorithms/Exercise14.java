public class Exercise14{
    public static void main(String[] args){
        Employee[] employees = new Employee[]{new Employee("A", 100), new Employee("D", 500), new Employee("B", 300), new Employee("C", 900), new Employee("E", 600), new Employee("H", 200), new Employee("G", 300), new Employee("U", 100)};
        mergesort(employees);
        for(int i = 0; i < employees.length; i++){
            System.out.println(employees[i].name + ": " + String.valueOf(employees[i].salary));
        }
    }
    public static void mergesort(Employee[] employees){
        if(employees == null || employees.length <= 1){
            return;
        }
        else{
            int mid = employees.length / 2;
            Employee[] left = new Employee[mid];
            Employee[] right = new Employee[employees.length - mid];
            for(int i = 0; i < mid; i++){
                left[i] = employees[i];
            }
            for(int j = 0; j < employees.length - mid; j++){
                right[j] = employees[mid + j];
            }
            mergesort(left);
            mergesort(right);
            int leftindex = 0;
            int rightindex = 0;
            int employeeindex = 0;
            while(leftindex < left.length && rightindex < right.length){
                if(left[leftindex].salary <= right[rightindex].salary){
                    employees[employeeindex] = left[leftindex];
                    leftindex++;
                }
                else{
                    employees[employeeindex] = right[rightindex];
                    rightindex++;
                }
                employeeindex++;
            }
            while(leftindex < left.length){
                employees[employeeindex] = left[leftindex];
                leftindex++;
                employeeindex++;
            }
            while(rightindex < right.length){
                employees[employeeindex] = right[rightindex];
                rightindex++;
                employeeindex++;
            }
        }
    }
}
class Employee{
    String name;
    int salary;
    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}