public abstract class ExamplerOfAbstraction {
	int empId;
	String name;
	Double salary;
	String type;

	public Double generalSalaryCalculator( ){

		// logic for salary calculator

		return salary;
	}

	public abstract Double getStaffSalary(String type);
}
