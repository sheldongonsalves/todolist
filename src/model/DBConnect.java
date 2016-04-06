package model;
import model.DBUtil;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

public class DBConnect {
	HttpSession session; 
	public long checkUser(String userName){
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery query =em1.createQuery(
				"Select tu.userid from TodoUser tu where tu.uname like :user_name",TodoUser.class)
				.setParameter("user_name",userName);
		long userID =(long) query.getSingleResult();

		return userID;
	}
	@SuppressWarnings("unchecked")
	public TypedQuery<TodoList> getNameFromUser(long userid)
	{


		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		System.out.println("here 3");
		TypedQuery<TodoList> query=em1.createQuery(
				"Select tdl from TodoList tdl where tdl.todoUser.userid = :userid",TodoList.class)
				.setParameter("userid",userid);


		return query;


	}
	public int AddTask(int item_id , String item_name ,Date date ,String item_status , long userid)
	{
		int count=0;
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		
		TodoList tdl = new TodoList();
		TodoStatus ts = new TodoStatus();
		TodoUser tu = new TodoUser();
		tu.setUserid(userid);//set the user id got from session on line 38 of landingpageservlet.java
		if(item_status.equalsIgnoreCase("done"))
		{
			ts.setStatusid(1);
		}
		else if(item_status.equalsIgnoreCase("pending"))
		{
			ts.setStatusid(2);
		}
		tdl.setListid(item_id);
		tdl.setItem(item_name);
		tdl.setTododate(date);
		tdl.setTodoStatus(ts);//parse object that is set in line 50 0r 54
		tdl.setTodoUser(tu);
		try
		{
			trans.begin();
		    em1.persist(tdl);
		    em1.flush();
			trans.commit();

		}
		catch (Exception e)
		{
			trans.rollback();

		}
		finally
		{
			em1.close();
		}
		return count;
	}
	public TypedQuery<TodoList> getreportofdone(long userid)
	{


		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		System.out.println("here 4");
		TypedQuery<TodoList> query=em1.createQuery(
				"Select tdl from TodoList tdl where tdl.todoUser.userid = :userid and tdl.todoStatus.statusid = :statusid",TodoList.class)
				.setParameter("userid",userid)
				.setParameter("statusid", 2);


		return query;


	}
	public TypedQuery<TodoList> getreportofpending(long userid)
	{


		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		System.out.println("here 5");
		TypedQuery<TodoList> query=em1.createQuery(
				"Select tdl from TodoList tdl where tdl.todoUser.userid = :userid and tdl.todoStatus.statusid = :statusid",TodoList.class)
				.setParameter("userid",userid)
				.setParameter("statusid", 1);


		return query;


	}
	public void updatedate(long userid ,Date date ,int itemid)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		
		TypedQuery<TodoList> query=em1.createQuery(
				"Update TodoList tdl set tdl.tododate=:date where tdl.todoUser.userid = :userid and tdl.listid=:listid",TodoList.class)
				.setParameter("date", date)
				.setParameter("userid",userid)
				.setParameter("listid", itemid);
		trans.begin();
		try
		{   
			query.executeUpdate();
			trans.commit();
		}
		catch(Exception e)
		{
			trans.rollback();
		}
		finally
		{
			em1.close();
		}
		
	}


}
