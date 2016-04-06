package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TODO_USER database table.
 * 
 */
@Entity
@Table(name="TODO_USER")
@NamedQuery(name="TodoUser.findAll", query="SELECT t FROM TodoUser t")
public class TodoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;

	private String uname;

	private String upassword;

	//bi-directional many-to-one association to TodoList
	@OneToMany(mappedBy="todoUser")
	private List<TodoList> todoLists;

	public TodoUser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid; 
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public List<TodoList> getTodoLists() {
		return this.todoLists;
	}

	public void setTodoLists(List<TodoList> todoLists) {
		this.todoLists = todoLists;
	}

	public TodoList addTodoList(TodoList todoList) {
		getTodoLists().add(todoList);
		todoList.setTodoUser(this);

		return todoList;
	}

	public TodoList removeTodoList(TodoList todoList) {
		getTodoLists().remove(todoList);
		todoList.setTodoUser(null);

		return todoList;
	}

}