

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProjectNewone")
public class ProjectNewone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProjectNewone() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
		String a=request.getParameter("name");
		String b=request.getParameter("pass");
		try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/raja","root","");
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("Select * from login where name='"+a+"' and pass='"+b+"'");
		if(rs.next()) {
		PrintWriter p=response.getWriter();
		p.println("welcome");
		RequestDispatcher
		rd=request.getRequestDispatcher("index1.html");
		rd.forward(request, response);
		}
		else
		{
		PrintWriter p=response.getWriter();
		p.println(" invalied namd and pass");
		response.setContentType("text/html");
//		response.sendRedirect("index.html");
		RequestDispatcher rd=request.getRequestDispatcher("index.html");

		rd.include(request, response);
		}
	}catch(Exception e)
		{
			System.out.println(e);
		}
		
}

}
