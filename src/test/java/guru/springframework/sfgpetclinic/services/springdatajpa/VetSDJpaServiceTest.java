package guru.springframework.sfgpetclinic.services.springdatajpa;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
	
	@Mock
	VetRepository vet;
	@InjectMocks
	VetSDJpaService vetService;


	@Test
	void testFindAll() {

		Vet v=new Vet(1L, "john", "doe", null);
		Set<Vet> s=new HashSet<>();
		s.add(v);
		
		when(vetService.findAll()).thenReturn(s);
		
		Set<Vet> s2=vetService.findAll();
		
		verify(vet).findAll();
		assertThat(s2).isNotNull();
		
	}

	@Test
	void testFindById() {
		Vet v=new Vet(1L, "john", "doe", null);
		when(vet.findById(anyLong())).thenReturn(Optional.of(v));
		Vet v2=vetService.findById(anyLong());
		
		verify(vet).findById(anyLong());
		assertThat(v2).isNotNull();
		
	}

	@Test
	void testSave() {
		Vet v=new Vet(1L, "john", "doe", null);
		when(vetService.save(any(Vet.class))).thenReturn(v);
		Vet v2=vetService.save(new Vet(null, null, null, null));
		
		verify(vet).save(any(Vet.class));
		assertThat(v2).isNotNull();
		

	}

	@Test
	void testDelete() {
		Vet v=new Vet(1L, "john", "doe", null);
		vetService.delete(v);
		verify(vet).delete(any(Vet.class));
		
	}

	@Test
	void testDeleteById() {
		
		vetService.deleteById(1L);
		
		verify(vet).deleteById(anyLong());
	}
	
	@Test
	void testDeleteByIdExcdeption() {
	
		doThrow(new RuntimeException("error")).when(vet).deleteById(anyLong());
		
		assertThrows(RuntimeException.class, ()-> vetService.deleteById(1L) );
		verify(vet).deleteById(1L);
	}

}
