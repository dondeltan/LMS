package com.myapp.lms.LibraryManagementSystem.controller;
/*
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.lms.controller.LmsController;
import com.myapp.lms.model.Book;
import com.myapp.lms.service.BookService;

@WebMvcTest(value = LmsController.class)
public class lmsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	List mockBook = Arrays
			.asList(new Book(1, "The Monk Who Sold His Ferrari", "Inspiration", "Jaico", "Robin Sharma", 120));

	String exampleBookJson = "{\"bookID\":\"1\",\"bookName\":\"The Monk Who Sold His Ferrari\",\"bookcategory\":\"Inspiration\",\"publisher\":\"Jaico\",\"author\":\"Robin Sharma\",\"price\":\"120\"}";

	@Test
	public void getBooks() throws Exception {

		Mockito.when(bookService.getAllBooks()).thenReturn(mockBook);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getBooks").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{\"bookID\":\"1\",\"bookName\":\"The Monk Who Sold His Ferrari\",\"bookcategory\":\"Inspiration\",\"publisher\":\"Jaico\",\"author\":\"Robin Sharma\",\"price\":\"120\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
*/

public class lmsControllerTest {
	
}