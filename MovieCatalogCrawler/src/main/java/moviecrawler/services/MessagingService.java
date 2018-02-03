package moviecrawler.services;

import moviecrawler.constants.MessageBrokerConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MessagingService {

    private final RabbitTemplate rabbitTemplate;

    public MessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(List<String> movieTitles) {
        String message = Arrays.toString(movieTitles.toArray());
        rabbitTemplate.convertAndSend(MessageBrokerConstants.TITLES_QUEUE, message);
        System.out.println("MESSAGE SENT");
    }

}