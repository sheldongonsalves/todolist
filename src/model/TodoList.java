package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TODO_LIST database table.
 * 
 */
@Entity
@Table(name="TODO_LIST")
@NamedQuery(name="TodoList.findAll", query="SELECT t FROM TodoList t")
public class TodoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long listid;

	private String item;

	@Temporal(TemporalType.DATE)
	private Date tododate;

	//bi-directional many-to-one association to TodoStatus
	@ManyToOne
	@JoinColumn(name="STATUSID")
	private TodoStatus todoStatus;

	//bi-directional many-to-one association to TodoUser
	@ManyToOne
	@JoinColumn(name="USERID")
	private TodoUser todoUser;

	public TodoList() {
	}

	public long getListid() {
		return this.listid;
	}

	public void setListid(long listid) {
		this.listid = listid;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getTododate() {
		return this.tododate;
	}

	public void setTododate(Date tododate) {
		this.tododate = tododate;
	}

	public TodoStatus getTodoStatus() {
		return this.todoStatus;
	}

	public void setTodoStatus(TodoStatus todoStatus) {
		this.todoStatus = todoStatus;
	}

	public TodoUser getTodoUser() {
		return this.todoUser;
	}

	public void setTodoUser(TodoUser todoUser) {
		this.todoUser = todoUser;
	}

}