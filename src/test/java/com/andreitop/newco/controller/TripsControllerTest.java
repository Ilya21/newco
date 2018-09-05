package com.andreitop.newco.controller;

import com.andreitop.newco.BaseTest;
import com.andreitop.newco.service.TripService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TripsController.class)
public class TripsControllerTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    @Test
    public void whenPostTrip_thenCreateTrip() throws Exception {
        mockMvc.perform(post(API_URL)
                .contentType(CONTENT_TYPE)
                .content(TRIP_JSON))
                .andExpect(status().isCreated());

        verify(tripService, times(WANTED_NUMBER_OF_INVOCATIONS)).save(tripDtoFromJson);
    }

    @Test
    public void givenTrips_whenGetTrips_thenReturnJsonArray() throws Exception {
        given(tripService.findAll()).willReturn(allTrips);

        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].origin", is("MOW")))
                .andExpect(jsonPath("$[0].destination", is("LED")))
                .andExpect(jsonPath("$[0].price", is(4232)));
    }

    @Test
    public void givenTrips_whenGetTripsById_thenReturnJsonArray() throws Exception {
        given(tripService.findById(TRIP_DTO_ID)).willReturn(tripDto);

        mockMvc.perform(get(API_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("origin", is("MOW")))
                .andExpect(jsonPath("destination", is("LED")))
                .andExpect(jsonPath("price", is(4232)));
    }

    @Test
    public void givenTrips_whenDeleteTripsById_thenDeleteTrip() throws Exception {
        mockMvc.perform(delete(API_URL + "/1")
                .contentType(CONTENT_TYPE))
                .andExpect(status().isNoContent());

        verify(tripService, times(WANTED_NUMBER_OF_INVOCATIONS)).delete(TRIP_DTO_ID);
    }

    @Test
    public void givenTrips_whenUpdateTrips_thenUpdateTrip() throws Exception {
        mockMvc.perform(put(API_URL)
                .contentType(CONTENT_TYPE)
                .content(NEW_TRIP_JSON))
                .andExpect(status().isOk());

        verify(tripService, times(WANTED_NUMBER_OF_INVOCATIONS)).update(tripDtoForUpdate);
    }
}