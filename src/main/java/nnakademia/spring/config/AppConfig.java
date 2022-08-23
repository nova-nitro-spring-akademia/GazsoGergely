package nnakademia.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ThemeResolver;

import javax.sql.DataSource;

// DI KONTÉNER ÉS APP KONFIGURÁCIÓ
// - xml vagy java konfig alapon
// - java konfig preferált; xml legacy

// @Configuration
// - DI konténerbe regisztrált beaneket konfiguráló osztály jelölése
// - akárhány lehet: moduláris konfiguráció
// - metódusok egy-egy bean konfigurációt írnak le
//   - típusinformáció és metódus neve alapján azonosítja a beant a spring
// - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.configuration-classes

// AUTOKONFIG FELÜLÍRÁSA
// - convention over configuration (configuration by exception)
// - ha definiálunk egy saját beant, a default autokonfigolt beant ignorálja a spring
// - elég csak azt definiálni, ami eltér az alapoktól
// - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.auto-configuration.replacing

// AUTOKONFIG KIKAPCSOLÁSA EGY-EGY BEANRE
// - `@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })`
// - `@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })`
// - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.auto-configuration.disabling-specific


@Configuration
public class AppConfig {

    // ha felül akarunk definiálni egy beépített beant, egyszerűen definiáljuk mi magunk ugyanazzal a névvel
    // - név: alapból a metódus neve, vagy ami a @bean annotációnak megadunk
    /*
    @Bean
    public ThemeResolver themeResolver() {
        return null;
    }

    @Bean
    public DataSource dataSource() {
        return null;
    }
    */

}
