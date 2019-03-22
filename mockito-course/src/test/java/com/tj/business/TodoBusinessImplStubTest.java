package com.tj.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tj.data.api.TodoService;
import com.tj.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	 
	@Test
	public void test_usingStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
