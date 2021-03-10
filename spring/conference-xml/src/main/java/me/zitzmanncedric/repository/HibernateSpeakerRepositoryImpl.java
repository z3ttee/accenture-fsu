package me.zitzmanncedric.repository;

import me.zitzmanncedric.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Override
    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Cedric");
        speaker.setLastName("Zitzmann");

        speakers.add(speaker);
        return speakers;
    }

}
