package com.campushare.join.controller;
import com.campushare.join.model.FoodRequest;
import com.campushare.join.model.JoinRequest;
import com.campushare.join.service.JoinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class JoinControllerTests {

    @Mock
    private JoinService joinService;

    @InjectMocks
    private JoinController joinController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void requestToJoin_sendsJoinRequest() {
        JoinRequest mockJoinRequest = new JoinRequest();
        String mockPost = "Post";
        doNothing().when(joinService).manageJoinRequest(mockPost, mockJoinRequest);

        ResponseEntity<String> response= joinController.requestToJoin(mockPost, mockJoinRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Driver has received your request!", response.getBody());
        verify(joinService, times(1)).manageJoinRequest(mockPost, mockJoinRequest);
    }

    @Test
    void requestFood_sendsFoodRequest() {
        FoodRequest mockFoodRequest = new FoodRequest();
        String mockPost = "Post";
        doNothing().when(joinService).manageLunchAndFood(mockPost, mockFoodRequest);

        ResponseEntity<String> response= joinController.requestFood(mockPost, mockFoodRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Driver has received your request!", response.getBody());
        verify(joinService, times(1)).manageLunchAndFood(mockPost, mockFoodRequest);
    }
}
