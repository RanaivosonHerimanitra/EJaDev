package com.EWServlet.servlets;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/login")
public class LoginServletApp extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    protected String createForm(String errMsg)
    {
    	StringBuilder sb = new StringBuilder("<h2>Login</h2>");
    	if (errMsg!=null)
    	{
    		sb.append("<span style='color:red;'>")
    		  .append(errMsg)
    		  .append("</span>");
    	}
    	//create form:
    	sb.append("<form method='post'>\n")
    	  .append("User Name: <input type='text' name='userName'><br>\n")
    	  .append("Password: <input type='password' name='password'><br>\n")
    	  .append("<button type='submit' name='submit'>Submit</button>")
    	  .append("<button type='reset'>Reset</button>")
    	  .append("</form>");
    	return sb.toString();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletApp() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public boolean isValidAdmin(String userName,String password) {
		boolean cond1="admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password);
	    return cond1 ;
	}
	public boolean isValidUser(String userName,String password) {
		boolean cond2="user".equalsIgnoreCase(userName) && "user".equalsIgnoreCase(password);
	      return cond2;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//specify it is an html:
		response.setContentType("text/html");
		response.getWriter().write(createForm(null));
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		StringBuilder responseStr = new StringBuilder();
		boolean cond1 = isValidUser(userName,password);
		boolean cond2 = isValidAdmin(userName,password);
		if (cond1 | cond2)
		{
			if (cond1 )
			{
				responseStr.append("<h2>Welcome user</h2>");
			}
			if (cond2 )
			{
				responseStr.append("<h2>Welcome admin</h2>");
			}
		} else {
			responseStr.append(createForm("Invalid user id or password.Please try again"));
		}
		//specify it is an html:
		response.setContentType("text/html");
		response.getWriter().write(responseStr.toString());
	}
}
