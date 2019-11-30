package guru.springframework.sfgpetclinic;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AnnotationMockTest {
	
	@Mock
	Map<String, Object> demo;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	void testMocks() {
		demo.put("key", "foo");
	}
	
	
	

}
