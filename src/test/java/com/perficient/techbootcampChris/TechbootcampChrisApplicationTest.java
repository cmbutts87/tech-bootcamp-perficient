package com.perficient.techbootcampChris;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TechbootcampChrisApplicationTest {
	
	@Test
	void assertTest() {
		int x = 1;
		assertEquals(x,1);
	}
	
	
	final Date dnow = Mockito.mock(Date.class);

	@Test
	void mockTest() {
		when(dnow.toString()).thenReturn("Testing");
	
		assertEquals(dnow.toString(), "Testing");
	}
	
	

}
