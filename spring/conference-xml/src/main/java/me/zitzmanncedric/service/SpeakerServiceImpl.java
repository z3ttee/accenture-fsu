package me.zitzmanncedric.service;

import me.zitzmanncedric.model.Speaker;
import me.zitzmanncedric.repository.HibernateSpeakerRepositoryImpl;
import me.zitzmanncedric.repository.SpeakerRepository;

import javax.annotation.PostConstruct;
import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    public SpeakerServiceImpl() {

    }

    public SpeakerServiceImpl(SpeakerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    public void setSpeakerRepository(SpeakerRepository repository) {
        this.repository = repository;
    }
}
