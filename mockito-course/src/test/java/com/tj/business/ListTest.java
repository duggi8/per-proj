package com.tj.business;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test(expected = RuntimeException.class)
	public void test() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(RuntimeException.class);
		listMock.get(0);
		
		/*when(listMock.get(0)).thenReturn("teja").thenReturn("sai").thenReturn("srt");
		assertEquals("teja", listMock.get(0));
		assertEquals("sai", listMock.get(0));
		assertEquals("srt", listMock.get(0));*/
	
		/*when(listMock.get(anyInt())).thenReturn("teja").thenReturn("sai").thenReturn("srt");
		assertEquals("teja", listMock.get(0));
		assertEquals("sai", listMock.get(1));*/
	}

}
