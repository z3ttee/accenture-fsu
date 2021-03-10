package me.zitzmanncedric.service;

import me.zitzmanncedric.model.Speaker;
import me.zitzmanncedric.repository.HibernateSpeakerRepositoryImpl;
import me.zitzmanncedric.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

}
