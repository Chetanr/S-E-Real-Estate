import java.util.ArrayList;

public class TestPayroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BranchAdministrator ba = new BranchAdministrator("BM001", "welcome123","Branch Manager", "FT", 5000, 0);
		BranchManager bm = new BranchManager("BM001", "welcome123","Branch Manager", "FT", 5000, 0);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new PropertyManager("PM003", "welcome123","Branch Manager", "FT", 5000, 0));
		employees.add(new PropertyManager("PM001", "welcome123@","James Isaac", "FT", 6000, 0));
		employees.add(new PropertyManager("PM002", "welcome123!","Mike Johnson", "PT", 0.0, 25.0));
		//PayRoll runs at end of every month.
		ba.currentDate();
		ba.payroll(employees);
		//Current Date is set to end of Month and salary is computed
		try
		{
			employees.get(0).enterHours(bm);
		}
		catch(HourException e)
		{
			System.out.println(e);
		}
		
		try
		{
			employees.get(1).enterHours(bm);
		}
		catch(HourException e)
		{
			System.out.println(e);
		}
		
		try
		{
			employees.get(2).enterHours(bm);
		}
		catch(HourException e)
		{
			System.out.println(e);
		}
		
		ba.advanceDate(18);
		ba.payroll(employees);
		employees.get(0).viewSalary();
		employees.get(1).viewSalary();
		employees.get(2).viewSalary();
	}

}
