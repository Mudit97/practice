

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindInSalaryRangeServlet
 */
@WebServlet("/FindInSalaryRangeServlet")
public class FindInSalaryRangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private static EmployeeDataService eds = EmployeeDataService.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Float lower = Float.parseFloat(request.getParameter("salary_lower"));
		Float upper = Float.parseFloat(request.getParameter("salary_upper"));
		List<Employee> employeelist = eds.employeeInSalaryRange(lower, upper);
		PrintWriter pw = response.getWriter();
		for(Employee e: employeelist) {
			pw.println(e.toString());
		}
	}

}
