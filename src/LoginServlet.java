

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBConnect;
import model.TodoList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName =request.getParameter("username");
		DBConnect dbc= new DBConnect();
		long userID=dbc.checkUser(userName);
		System.out.println("---------------------------->"+userID);
		if(userID<1)
		{
			System.out.println("------------inside if---------------->"+userID);
			request.setAttribute("message", "Enter a valid name");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else
		{
			HttpSession session=request.getSession(); 
			System.out.println("------------inside else---------------->"+userID);
			session.setAttribute("user_Name",userName);//anything set in a session is with a underscore
			session.setAttribute("user_ID",userID);
			System.out.println("session---------------"+session.getAttribute("user_Name"));
			@SuppressWarnings("unchecked")
			List<TodoList> todo_list = dbc.getNameFromUser(userID).getResultList();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>"+todo_list);
			request.setAttribute("todolist", todo_list);
			request.getRequestDispatcher("/landing.jsp").forward(request, response);
		}
	}

}
