

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBConnect;
import model.TodoList;


@WebServlet("/LandingPageServlet")
public class LandingPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LandingPageServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Date date = null;
		DBConnect dbc= new DBConnect();
		HttpSession session=request.getSession();
		System.out.println("session id-------------->"+request.getParameter("itemid"));
		long user_id = (long) session.getAttribute("user_ID");
		String userName=(String) session.getAttribute("user_Name");
		int item_id =Integer.parseInt(request.getParameter("itemid")); 
		String item_name =request.getParameter("itemname");
		String item_date =request.getParameter("itemdate") ;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(item_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user_id + item_id + userName + item_id + item_name + item_date );
		String item_status =request.getParameter("itemstatus");
		dbc.AddTask(item_id, item_name, date, item_status ,user_id);
		
		List<TodoList> todo_list_done = dbc.getreportofdone(user_id).getResultList();
		List<TodoList> todo_list_pending = dbc.getreportofpending(user_id).getResultList();
		request.setAttribute("todolistpending", todo_list_pending);
		request.setAttribute("todolistdone", todo_list_done);
		request.getRequestDispatcher("/report.jsp").forward(request, response);
		
		
	
	}

}
