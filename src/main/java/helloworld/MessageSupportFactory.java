package helloworld;

import java.io.FileInputStream;
import java.util.Properties;

public class MessageSupportFactory {

    private static MessageSupportFactory instance;
    private Properties props;
    private MessageRender render;
    private MessageProvider provider;

    private MessageSupportFactory(){
        props = new Properties();
        try {
            props.load(new FileInputStream("C:\\Users\\dbond\\IdeaProjects\\spring\\src\\main\\resources\\message.properties"));
            String renderClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            render = (MessageRender) Class.forName(renderClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageRender getRender() {
        return render;
    }

    public MessageProvider getProvider() {
        return provider;
    }
}
