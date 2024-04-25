package empapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventLogger {

    @EventListener
    public void handleEvent(MessageResponse messageResponse) {
        log.info("Event: {}", messageResponse);
    }
}
