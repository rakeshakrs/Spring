package com.example.implementation;

import com.example.interfaces.MusicSystem;
import org.springframework.stereotype.Component;

@Component
public class BossMusicSystem implements MusicSystem {
    @Override
    public void playMusic() {
        System.out.println("Boss Music system");
    }
}
