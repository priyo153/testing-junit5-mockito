package guru.springframework.sfgpetclinic.services.springdatajpa;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {
	
	Speciality s=new Speciality();
	
	@Mock
	SpecialtyRepository specialtyRepository;
	
	@InjectMocks
	SpecialitySDJpaService service;
	
	@Test
	void findByIdTest() {
		
		
		
		when(specialtyRepository.findById(1L)).thenReturn(Optional.of(s));
		Speciality foundSpeciality=service.findById(1L);
		
		assertThat(foundSpeciality).isNotNull();
		verify(specialtyRepository).findById(1L);
		
		
		
	}

	@Test
	void deleteById() {
		service.deleteById(1L);
		service.deleteById(1L);
		
		verify(specialtyRepository,times(2)).deleteById(1L);
		
	}
	
	@Test
	void testDelete() {
		service.delete(new Speciality() );
	}

}
