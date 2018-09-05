package com.andreitop.newco;

import com.andreitop.newco.common.ApiConstant;
import com.andreitop.newco.dto.TripDto;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
public abstract class BaseTest {

    protected static final String TRIP_JSON = "{\"origin\": \"LED\" , \"destination\":\"MOW\", \"price\" : 12256}";
    protected static final String NEW_TRIP_JSON = "{\"id\": 1, \"origin\": \"EDIN\" , \"destination\":\"LA\", \"price\" : 5555}";
    protected static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    protected static final String API_URL = ApiConstant.API_V_1 + "/trips";
    protected static final long TRIP_DTO_ID = 1;
    protected static final int WANTED_NUMBER_OF_INVOCATIONS = 1;


    protected List<TripDto> allTrips;
    protected TripDto tripDto;
    protected static TripDto tripDtoFromJson;
    protected static TripDto tripDtoForUpdate;

    @Before
    public void setUp() {
        tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        tripDtoFromJson = new TripDto();
        tripDtoFromJson.setId(null);
        tripDtoFromJson.setOrigin("LED");
        tripDtoFromJson.setDestination("MOW");
        tripDtoFromJson.setPrice(12256);

        tripDtoForUpdate = new TripDto();
        tripDtoForUpdate.setId(1L);
        tripDtoForUpdate.setOrigin("EDIN");
        tripDtoForUpdate.setDestination("LA");
        tripDtoForUpdate.setPrice(5555);

        allTrips = Collections.singletonList(tripDto);
    }
}
