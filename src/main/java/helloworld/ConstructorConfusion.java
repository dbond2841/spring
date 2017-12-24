package helloworld;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue){
        System.out.println("ConsytructorConfucion(String) called");
        this.someValue = someValue;
    }

    public ConstructorConfusion(int someValue){
        System.out.println("ConsytructorConfucion(int) called");
        this.someValue = String.valueOf(someValue);
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF\\spring\\app-contex-confusiont.xml");
        context.refresh();
        ConstructorConfusion confusion = (ConstructorConfusion) context.getBean("constructorConfusion");
    }


}
