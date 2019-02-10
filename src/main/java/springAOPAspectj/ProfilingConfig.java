package springAOPAspectj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ProfilingConfig {
	@Bean
	public CustomerBoImpl customerBo() {
		return new CustomerBoImpl();
	}
	@Bean
	public LoggingAspect logAspect() {
		return new LoggingAspect();
	}

}
