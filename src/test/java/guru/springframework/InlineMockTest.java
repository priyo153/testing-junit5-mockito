package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Map;

import org.junit.jupiter.api.Test;
public class InlineMockTest {
	
	@Test
	void testInlineMock() {
		Map mockMap=mock(Map.class);
		
		assertEquals(mockMap.size(),0);
	}

}
