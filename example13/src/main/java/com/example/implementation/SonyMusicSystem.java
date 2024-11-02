package com.example.implementation;

import com.example.interfaces.MusicSystem;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonyMusicSystem implements MusicSystem {
    @Override
    public void playMusic() {
        System.out.println("sony music system");
    }
}
