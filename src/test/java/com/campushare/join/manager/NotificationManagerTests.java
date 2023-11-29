package com.campushare.join.manager;
import com.campushare.join.dto.NotifyDriverEvent;
import com.campushare.join.kafka.NotifyDriverProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class NotificationManagerTests {

    @Mock
    private NotifyDriverProducer notifyDriverProducer;

    @InjectMocks
    private NotificationManger notificationManger;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void notifyDriver_sendsNotification() {
        String mockUserId = "userId";
        String mockMessage = "message";
        NotifyDriverEvent mockNotifyDriverEvent = new NotifyDriverEvent(mockUserId, mockMessage);

        doNothing().when(notifyDriverProducer).sendMessage(mockNotifyDriverEvent);

        notificationManger.notifyDriver(mockUserId, mockMessage);

        verify(notifyDriverProducer, times(1)).sendMessage(mockNotifyDriverEvent);
    }
}
