package helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/app-context.xml");
        context.refresh();
        MessageRender render = context.getBean("messageRender", StandartOutMessageRender.class);
        render.render();

    }
}
