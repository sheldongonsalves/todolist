package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TODO_STATUS database table.
 * 
 */
@Entity
@Table(name="TODO_STATUS")
@NamedQuery(name="TodoStatus.findAll", query="SELECT t FROM TodoStatus t")
public class TodoStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long statusid;

	@Column(name="TODO_STATUS")
	private String todoStatus;

	//bi-directional many-to-one association to TodoList
	@OneToMany(mappedBy="todoStatus")
	private List<TodoList> todoLists;

	public TodoStatus() {
	}

	public long getStatusid() {
		return this.statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public String getTodoStatus() {
		return this.todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}

	public List<TodoList> getTodoLists() {
		return this.todoLists;
	}

	public void setTodoLists(List<TodoList> todoLists) {
		this.todoLists = todoLists;
	}

	public TodoList addTodoList(TodoList todoList) {
		getTodoLists().add(todoList);
		todoList.setTodoStatus(this);

		return todoList;
	}

	public TodoList removeTodoList(TodoList todoList) {
		getTodoLists().remove(todoList);
		todoList.setTodoStatus(null);

		return todoList;
	}

}