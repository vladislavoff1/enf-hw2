public class Employee {
	
	public String name;
	public String job;
	public int salary;

	public Employee(String name, String job, int salary) {
		this.name = name;
		this.job = job;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public int getSalary() {
		return salary;
	}
}