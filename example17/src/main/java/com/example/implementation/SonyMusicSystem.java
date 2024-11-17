package com.example.implementation;

import com.example.interfaces.MusicSystem;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonyMusicSystem implements MusicSystem {
    @Override
    public String playMusic(String title,String singerName) {
        return "sony music system "+title+" by "+singerName;
    }
}
