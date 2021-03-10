package me.zitzmanncedric;

import me.zitzmanncedric.repository.HibernateSpeakerRepositoryImpl;
import me.zitzmanncedric.repository.SpeakerRepository;
import me.zitzmanncedric.service.SpeakerService;
import me.zitzmanncedric.service.SpeakerServiceImpl;
import me.zitzmanncedric.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

/*
 * @ComponentScan now scans starting at specified package for autowiring
 * @Repository - Declare classes as Repository
 * @Service - Declare classes as Service
 * @Scope is now defined on class level of Service classes
 */
@Configuration
@ComponentScan({"me.zitzmanncedric"})
public class AppConfig {

    @Bean(name = "cal")
    public CalendarFactory calendarFactory() {
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        return calendarFactory().getObject();
    }

    /*
     * Because @Bean is a Singleton, only one instance of SpeakerServiceImpl is created.
     * Even when calling the method 50 times.
     */
    //@Bean(name = "speakerService")

    /*
     * Set scope manually. Defaults to SCOPE_SINGLETON if not defined
     */
    //@Scope(value = BeanDefinition.SCOPE_SINGLETON)

    /*
     * SCOPE_PROTOTYPE is the opposite of SCOPE_SINGLETON
     * So the Object address is changed per request
     */
    //@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    /*public SpeakerService getSpeakerService() {
        // SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
        SpeakerServiceImpl service = new SpeakerServiceImpl();
        // Before: SETTER INJECTION -> service.setRepository(getSpeakerRepository());
        // Now: CONSTRUCTOR INJECTION
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }*/

}
