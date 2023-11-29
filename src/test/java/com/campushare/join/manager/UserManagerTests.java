package com.campushare.join.manager;
import com.campushare.join.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserManagerTests {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserDetails_getsUser(){
        String userId = "userId";
        User mockUser = new User();
        mockUser.setUserId(userId);

        when(restTemplate.getForObject(any(String.class), any(Class.class)))
                .thenReturn(mockUser);

        User actualUser = userManager.getUserDetails(userId);

        assertEquals(mockUser, actualUser);
        verify(restTemplate, times(1)).getForObject(any(String.class), any(Class.class));
    }
}
