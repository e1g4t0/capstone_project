package com.ticketplatfotm.ticket_booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@AutoConfigureMockMvc
class TicketBookingApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testAuthorities() throws Exception {
		mockMvc.perform(get("/schedule").with(adminAuthority()))
				.andDo(log())
				.andExpect(status().isOk())
				.andReturn();

		mockMvc.perform(get("/movies/add").with(adminAuthority()))
				.andDo(log())
				.andExpect(status().isOk())
				.andReturn();

		mockMvc.perform(get("/schedule").with(userAuthority()))
				.andDo(log())
				.andExpect(status().isForbidden())
				.andReturn();
		mockMvc.perform(get("/movies/add").with(userAuthority()))
				.andDo(log())
				.andExpect(status().isForbidden())
				.andReturn();

	}

	private static RequestPostProcessor adminAuthority() {
		return user("admin").authorities(new SimpleGrantedAuthority("ADMIN"));
	}

	private static RequestPostProcessor userAuthority() {
		return user("user").authorities(new SimpleGrantedAuthority("USER"));
	}

}
