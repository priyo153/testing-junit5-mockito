package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.repositories.VetRepository;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
	
	@Mock
	VetRepository vet;
	
	@InjectMocks
	VetSDJpaService vetService;

	@Test
	void testDeleteById() {
		
		vetService.deleteById(1L);
		
		verify(vet,times(1)).deleteById(1L);
		
		
		
	}

}
