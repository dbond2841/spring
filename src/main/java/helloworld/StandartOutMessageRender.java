package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("messageRender")
public class StandartOutMessageRender implements MessageRender {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null){
            throw new RuntimeException();
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Resource(name = "configMessageProvider")
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
