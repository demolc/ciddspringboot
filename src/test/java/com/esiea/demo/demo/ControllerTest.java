package com.esiea.demo.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(ShowController.class) 
@ExtendWith(MockitoExtension.class)
public class ControllerTest {


	    @Autowired
	    private MockMvc mockMvc;

	    @MockitoBean
		private ShowService service;

	    @Test
	    void testGetOne() throws Exception {
	        // Simuler la réponse du service
	    	Show mockedShow = new Show(1,"Shameless", 2011);
	        when(service.get(1)).thenReturn(mockedShow);

	        // Exécuter la requête GET
	        mockMvc.perform(get("/shows/1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.id").value(mockedShow.getId()))
	                .andExpect(jsonPath("$.name").value(mockedShow.getName()));

	        // Vérifier que la méthode du service a été appelée une fois
	        verify(service, times(1)).get(1);
	    }

}
