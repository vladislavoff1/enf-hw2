import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static String defaultFile = "salary.txt";

    /*
    * Read to list all files from args or deafult file if args is empty.
    * Displays result from all public methods in Employees.
    */
    public static void main(String[] args) {
        // Read default if args is empty
        if (args.length == 0) {
            args = new String[1];
            args[0] = defaultFile;
        }

        List<Employee> list = new LinkedList<Employee>();

        for (String file : args) {
            try {
                list.addAll(readFile(file));
            } catch (FileNotFoundException e) {
                System.err.println("File `" + file + "` is not found.");
            } catch (ParseException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Max salary:     " + Employees.maxSalary(list));
        System.out.println("Min salary:     " + Employees.minSalary(list));
        System.out.println("Average salary: " + Employees.averageSalary(list));
        System.out.println("Job count:      " + Employees.jobCount(list));
        System.out.println("ABC:            " + Employees.abc(list));


    }

    private static List<Employee> readFile(String file) throws FileNotFoundException, ParseException {
        Scanner source = new Scanner(new File(file));
        return ParseEmployees.parse(source);
    }
}