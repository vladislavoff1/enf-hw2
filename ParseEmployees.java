import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class ParseEmployees {

    /*
    * Returns List of Employee from source considering that
    * each line of source looks like `some name, some job, 123` 
    * Removes excess white spaces. Skips empty lines.
    */

    public static List<Employee> parse(Scanner source) throws ParseException {
        List<Employee> list = new LinkedList<Employee>();

        while (source.hasNextLine()) {
            String eStr = source.nextLine();
            if (eStr.replaceAll("\\s", "").equals("")) {
                continue;
            }
            Employee e = parseEmployee(eStr);
            list.add(e);
        }

        return list;
    }
    /*
    * Convert strings like `some name, some job, 123` to Employee.
    * Removes excess white spaces.
    */

    private static Employee parseEmployee(String str) throws ParseException {
        
        String[] info = str.split(",");
        if (info.length != 3) {
            throw new ParseException(str);
        }

        int salary;
        try {
            salary = Integer.parseInt(info[2].trim());
        } catch (NumberFormatException e) {
            throw new ParseException(str);
        }

        return new Employee(info[0].trim(), info[1].trim(), salary);
    }
}