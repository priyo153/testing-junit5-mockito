package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.fauxspring.ModelAndView;
import guru.springframework.sfgpetclinic.fauxspring.ModelImpl;
import guru.springframework.sfgpetclinic.fauxspring.WebDataBinder;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	

	@Mock
	OwnerService ownerService;
	@Mock
	Owner owner;
	@Mock
	BindingResult result;
	@Mock
	ModelImpl model;
	@Mock
	WebDataBinder webDataBinder;
	
	@InjectMocks
	OwnerController ownerController;

	@Test
	void testSetAllowedFields() {
		
		ownerController.setAllowedFields(webDataBinder);
		verify(webDataBinder).setDisallowedFields(any(String.class));
	}

	@Test
	void testFindOwners() {
		
		String view=ownerController.findOwners(model);
		verify(model).addAttribute(eq("owner"),any(Owner.class));
		assertEquals(view,"owners/findOwners");
		
	}

	@Test
	void testProcessFindForm() {
		String view;
		List<Owner> results=new ArrayList<>();
		
		
		view=ownerController.processFindForm(owner, result, model);
		verify(result).rejectValue(anyString(), anyString(), anyString());
		assertTrue(results.isEmpty());
		assertEquals(view,"owners/findOwners");
		
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(results);
		
		results.add(new Owner(5L, null, null));
		view=ownerController.processFindForm(owner, result, model);
		assertEquals(results.size(),1);
		assertEquals(view,"redirect:/owners/5");
		
		
		results.add(new Owner(5L, null, null));
		view=ownerController.processFindForm(owner, result, model);
		verify(model).addAttribute(eq("selections"),any(List.class));
		assertEquals(view,"owners/ownersList");
		
		
		
		
		
	}

	@Test
	void testShowOwner() {
		ModelAndView mav=ownerController.showOwner(anyLong());
		assertNotNull(mav);
	}

	@Test
	void testInitCreationForm() {
		
		String view=ownerController.initCreationForm(model);
		verify(model).addAttribute(eq("owner"), any(Owner.class));
		assertEquals(view,"owners/createOrUpdateOwnerForm");
	}

	@Test
	void testProcessCreationForm() {
		String view;
				
		when(result.hasErrors()).thenReturn(true);
		view=ownerController.processCreationForm(owner, result);
		verify(result).hasErrors();
		assertEquals(view,"owners/createOrUpdateOwnerForm");
		
		when(result.hasErrors()).thenReturn(false);
		when(ownerService.save(any(Owner.class))).thenReturn(new Owner(5L,null,null));
		view=ownerController.processCreationForm(owner, result);
		assertEquals(view,"redirect:/owners/5");
		
	}

	@Test
	void testInitUpdateOwnerForm() {
		String view=ownerController.initUpdateOwnerForm(1L,model);
		verify(ownerService).findById(anyLong());
		assertEquals(view,"owners/createOrUpdateOwnerForm");
	}

	@Test
	void testProcessUpdateOwnerForm() {
		String view;
		
		when(result.hasErrors()).thenReturn(true);
		view=ownerController.processUpdateOwnerForm(owner, result,1L);
		verify(result).hasErrors();
		assertEquals(view,"owners/createOrUpdateOwnerForm");
		
		when(result.hasErrors()).thenReturn(false);
		when(ownerService.save(any(Owner.class))).thenReturn(new Owner(5L,null,null));
		view=ownerController.processUpdateOwnerForm(owner, result,5L);
		assertEquals(view,"redirect:/owners/5");
			}

}
