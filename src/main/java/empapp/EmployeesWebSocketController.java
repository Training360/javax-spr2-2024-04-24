package empapp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@AllArgsConstructor
public class EmployeesWebSocketController {

    private SimpMessagingTemplate template;

    @MessageMapping("/messages")
    @SendTo("/topic/employees")
    public MessageResponse handleMessage(MessageRequest request) {
        log.info("Message has come: {}", request);
        return new MessageResponse("Hello " + request.getRequestText());
    }

    @EventListener
    public void handleEvent(MessageResponse messageResponse) {
        template.convertAndSend("/topic/employees", messageResponse);
    }
}
