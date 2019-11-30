package guru.springframework.sfgpetclinic.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.fauxspring.BindingResultImpl;
import guru.springframework.sfgpetclinic.fauxspring.ModelImpl;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest1 {
	
	@Mock
	OwnerService ownerService;
	@Mock
	Owner owner;
	@Mock
	BindingResult result;
	@Mock
	ModelImpl model;
	
	@InjectMocks
	OwnerController ownerController;

	@Test
	void testProcessCreationFormNoErrors() {
		
		


	}
	
	@Test
	void testProcessCreationFormErrors() {
		
		
		when(result.hasErrors()).thenReturn(true);
		
		String view=ownerController.processFindForm(owner,result,model);
		
		verify(result).hasErrors();
		System.out.println("view is"+view);
		
		
		
		


	}

}
