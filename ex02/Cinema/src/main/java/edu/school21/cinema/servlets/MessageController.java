package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Message;
import edu.school21.cinema.models.OutputMessage;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.MovieService;
import edu.school21.cinema.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Controller
public class MessageController {

//    private final SessionService sessionService;
//    private final MovieService movieService;
//    private final HallService hallService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public OutputMessage send(@Payload Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
