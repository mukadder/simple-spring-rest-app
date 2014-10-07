package simpleapp.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

@Service
public class PasteBinService {
    private static final Logger logger = LoggerFactory.getLogger(PasteBinService.class);

    @Autowired
    protected JmsTemplate jmsTemplate;

    @Autowired
    protected Queue pasteBinUploadQueue;

    public void upload(final String text) {
        this.jmsTemplate.send(this.pasteBinUploadQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }
}
