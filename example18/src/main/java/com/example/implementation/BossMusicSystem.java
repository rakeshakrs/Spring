package com.example.implementation;

import com.example.interfaces.MusicSystem;
import org.springframework.stereotype.Component;

@Component
public class BossMusicSystem implements MusicSystem {
    @Override
    public String playMusic(String title,String singerName) {

        return "Boss Music system "+title+" by "+singerName;
    }
}
