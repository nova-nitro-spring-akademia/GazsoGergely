package nnakademia.spring;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// SPRING BOOT APP BELÉPÉSI PONTJA
// - közönséges class + annotáció
// - SpringBootApplication: több másik annotáció gyűjtője
//   - SpringBootConfiguration: egyéni bean regisztráció és konfiguráció engedélyezése
//     - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.using-the-springbootapplication-annotation
//   - EnableAutoConfiguration: automatikus konfiguráció engedélyezése
//     - dependenciák alapján automatikus default konfigok és beanek
//     - pl. web starter behúzta a Tomcatet és a Spring MVC-t, úgyhogy úgy lesz konfigurálva app, hogy
//       lesz egy beépített Tomcat servlet container (webszerver) és a szükséges spring bean apparátus
//     - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.auto-configuration
//   - ComponentScan: @Component annotációval jelölt osztályok szkennelése
//     - beanek automatikus létrehozása és dependency injection
//     - spring belépési pont packagen belül
//       - tipp: a spring boot app indítása egy mindenek felett álló root packageben legyen, hogy a default
//         komponens szkennelés működjön
//
@SpringBootApplication
public class Application implements ApplicationContextAware, CommandLineRunner {

	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		// - tetszőleges előkészítő és lezáró logikát írhatunk
		// - pl. argumentumok előfeldolgozása
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beanDefinitionNames = this.applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}
}

