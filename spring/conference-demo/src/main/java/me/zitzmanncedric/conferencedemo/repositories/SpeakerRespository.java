package me.zitzmanncedric.conferencedemo.repositories;

import me.zitzmanncedric.conferencedemo.models.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRespository extends JpaRepository<Speaker, Long> {


}
