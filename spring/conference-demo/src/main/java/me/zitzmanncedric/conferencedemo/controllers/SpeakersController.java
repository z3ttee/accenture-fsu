package me.zitzmanncedric.conferencedemo.controllers;

import me.zitzmanncedric.conferencedemo.models.Speaker;
import me.zitzmanncedric.conferencedemo.repositories.SpeakerRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers/")
public class SpeakersController {

    @Autowired
    private SpeakerRespository speakerRespository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRespository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRespository.getOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker) {

        Speaker oldSpeaker = speakerRespository.getOne(id);
        BeanUtils.copyProperties(speaker, oldSpeaker, "speaker_id");
        return speakerRespository.saveAndFlush(oldSpeaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerRespository.deleteById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRespository.saveAndFlush(speaker);
    }
}
