package com.campushare.join.manager;
import com.campushare.join.model.Coordinates;
import com.campushare.join.model.GeoLocationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GeoLocationManagerTests {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GeoLocationManager geoLocationManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getGeoLocationInfo_returnGeoLocationData() {
        Coordinates mockCoordinates = new Coordinates();
        mockCoordinates.setLatitude(33.5);
        mockCoordinates.setLongitude(33.5);

        GeoLocationData mockGeoLocationData = new GeoLocationData();
        mockGeoLocationData.setAddedTime(8L);
        mockGeoLocationData.setPin(mockCoordinates);

        when(restTemplate.getForObject(any(String.class), any(Class.class)))
                .thenReturn(mockGeoLocationData);

        GeoLocationData actualData = geoLocationManager.getGeoLocationInfo("origin", "destination", "stop");

        assertEquals(mockGeoLocationData, actualData);
        verify(restTemplate, times(1)).getForObject(any(String.class), any(Class.class));
    }
}
