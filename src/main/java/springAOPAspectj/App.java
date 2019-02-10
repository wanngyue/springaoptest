package springAOPAspectj;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {

		//ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(ProfilingConfig.class);
		CustomerBoImpl customer = (CustomerBoImpl) appContext.getBean("customerBo");

		// Create the Proxy Factory
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(customer);

		// Add Aspect class to the factory
		proxyFactory.addAspect(LoggingAspect.class);
		proxyFactory.setProxyTargetClass(true);
		// Get the proxy object
		CustomerBoImpl proxyStudent = proxyFactory.getProxy();

		customer.addCustomer();

		customer.addCustomerReturnValue();

		// customer.addCustomerThrowException();

		//customer.addCustomerAround("mkyong");

	}
}
