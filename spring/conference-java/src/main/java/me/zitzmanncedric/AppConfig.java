package me.zitzmanncedric;

import me.zitzmanncedric.repository.HibernateSpeakerRepositoryImpl;
import me.zitzmanncedric.repository.SpeakerRepository;
import me.zitzmanncedric.service.SpeakerService;
import me.zitzmanncedric.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * Because @Bean is a Singleton, only one instance of SpeakerServiceImpl is created.
     * Even when calling the method 50 times.
     */
    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        SpeakerServiceImpl service = new SpeakerServiceImpl();
        service.setRepository(getSpeakerRepository());
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }

}
