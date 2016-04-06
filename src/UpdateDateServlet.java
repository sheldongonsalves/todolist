

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBConnect;


@WebServlet("/UpdateDateServlet")
public class UpdateDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Date date = null;
			DBConnect dbc= new DBConnect();
			HttpSession session=request.getSession();
			long user_id = (long) session.getAttribute("user_ID");
			int item_id =Integer.parseInt(request.getParameter("itemid")); 
			String item_date =request.getParameter("itemdatechange") ;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(item_date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbc.updatedate(user_id,date ,item_id);
	}

}
