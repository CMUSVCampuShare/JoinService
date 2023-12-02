package com.campushare.join.service;
import com.campushare.join.manager.GeoLocationManager;
import com.campushare.join.manager.NotificationManger;
import com.campushare.join.manager.UserManager;
import com.campushare.join.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class JoinServiceTests {
    @Mock
    private UserManager userManager;

    @Mock
    private GeoLocationManager geoLocationManager;

    @Mock
    private NotificationManger notificationManger;

    @InjectMocks
    private JoinService joinService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void manageJoinRequest_createsRequestWithGeolocationData() {
        User passenger = new User();
        String mockPassengerUserId = "passengerId";
        String address = "address";
        passenger.setUserId(mockPassengerUserId);
        passenger.setAddress(address);


        when(userManager.getUserDetails(mockPassengerUserId)).thenReturn(passenger);

        GeoLocationData mockGeoLocationData = new GeoLocationData();
        Coordinates coordinates = new Coordinates();
        coordinates.setLongitude(33.5);
        coordinates.setLatitude(33.5);
        mockGeoLocationData.setPin(coordinates);
        mockGeoLocationData.setAddedTime(8L);

        String from = "from";
        String to = "to";
        when(geoLocationManager.getGeoLocationInfo(any(String.class), any(String.class), any(String.class))).thenReturn(mockGeoLocationData);

        String driverId = "driverId";

        doNothing().when(notificationManger).notifyDriver(any(), any());

        JoinRequest mockJoinRequest = new JoinRequest();
        mockJoinRequest.setDriverID(driverId);
        mockJoinRequest.setPassengerID(mockPassengerUserId);
        mockJoinRequest.setFrom(from);
        mockJoinRequest.setTo(to);

        joinService.manageJoinRequest("mockPost", mockJoinRequest);

        verify(userManager, times(1)).getUserDetails(mockPassengerUserId);
        verify(geoLocationManager, times(1)).getGeoLocationInfo(any(String.class), any(String.class), any(String.class));
        verify(notificationManger, times(1)).notifyDriver(any(), any());
    }

    @Test
    void manageLunchAndFood_sendsFoodNotification() {
        User passenger = new User();
        String mockPassengerUserId = "passengerId";
        String mockUsername = "username";
        passenger.setUserId(mockPassengerUserId);
        passenger.setUsername(mockUsername);

        when(userManager.getUserDetails(mockPassengerUserId)).thenReturn(passenger);

        String mockPost = "post";

        String expectedMessage = passenger.getUsername() + " wants to join " + mockPost + "!";

        String driverId = "driverId";
        FoodRequest mockFoodRequest = new FoodRequest();
        mockFoodRequest.setDriverID(driverId);
        mockFoodRequest.setPassengerID(mockPassengerUserId);

        doNothing().when(notificationManger).notifyDriver(driverId, expectedMessage);

        joinService.manageLunchAndFood(mockPost, mockFoodRequest);

        verify(userManager, times(1)).getUserDetails(mockPassengerUserId);
        verify(notificationManger, times(1)).notifyDriver(driverId, expectedMessage);
    }
}
