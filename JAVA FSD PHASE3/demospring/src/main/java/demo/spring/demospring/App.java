package demo.spring.demospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.spring.custom.CustomEventPublisher;
public class App 
{
    public static void main( String[] args )
    {
    	//BeanFactory factory= new XmlBeanFactory(resources);
    	
    	ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
    	
    	HelloWorld h= (HelloWorld)context.getBean("obj");
    	h.print();
    	
    	Student s=(Student) context.getBean("s1");
    	
    	System.out.println("Id: "+s.getId());
    	System.out.println("Name: "+s.getName());
    	
    	
    	
    	Marks p=s.getMarks();
    	
    	System.out.println("Physics: "+p.getPhy());
    	System.out.println("Chemistry: "+p.getChem());
    	System.out.println("Mathematics: "+p.getMaths());
    	
    	//default event handling
    	ConfigurableApplicationContext context1= new ClassPathXmlApplicationContext("main-servlet.xml");
    	context1.start();
    	context1.stop();
    	
    	//custom event handling
    	
    	CustomEventPublisher c=(CustomEventPublisher)context1.getBean("cep");
    	c.publish();
    }
}
