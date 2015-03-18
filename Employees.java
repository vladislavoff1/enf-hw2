import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employees {

    /*
    * Returns the maximum salary of all employees.
    */
    public static int maxSalary(List<Employee> employee) {
        return employee.parallelStream()
                       .mapToInt(Employee::getSalary)
                       .max()
                       .getAsInt();
    }

    /*
    * Returns the minimum salary of all employees.
    */
    public static int minSalary(List<Employee> employee) {
        return employee.parallelStream()
                       .mapToInt(Employee::getSalary)
                       .min()
                       .getAsInt();
    }

    /*
    * Returns the average salary of all employees.
    */
    public static double averageSalary(List<Employee> employee) {
        return employee.parallelStream()
                       .mapToInt(Employee::getSalary)
                       .average()
                       .getAsDouble();
    }

    /*
    * Returns the number of employees that have the same job.
    */
    public static Map<String, Long> jobCount(List<Employee> employee)
    {
        return employee.parallelStream()
                       .collect(
                            Collectors.groupingBy(
                                e -> e.job, Collectors.counting()
                            )
                       );
    }
    
    /*
    * Returns the number of employees that have the same first letter 
    * in the the name.
    */
    public static Map<Character, Long> abc(List<Employee> employee)
    {
        return employee.parallelStream()
                       .collect(
                            Collectors.groupingBy(
                                e -> e.name.charAt(0), Collectors.counting()
                            )
                       );
    }

}