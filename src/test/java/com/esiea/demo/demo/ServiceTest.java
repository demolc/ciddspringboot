package com.esiea.demo.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	
	@Mock
	private ShowRepository repo;
	
	@InjectMocks
	private ShowService service;
	
	@Test
	void testGetOne() {
		Show mockedShow = new Show(1,"Shamaless", 2011);
		
		// Simuler le comportement du repository
        when(repo.findById(1)).thenReturn(Optional.of(mockedShow));

        // Exécuter la méthode à tester
        Show show = service.get(1);

        // Vérifier que le résultat est correct
        assertNotNull(show);
        assertEquals(mockedShow.getName(), show.getName());

        // Vérifier que la méthode du repository a bien été appelée une fois
        verify(repo, times(1)).findById(1);
	}

}
