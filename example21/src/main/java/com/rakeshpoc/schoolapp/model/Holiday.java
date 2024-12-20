package com.rakeshpoc.schoolapp.model;

import lombok.*;

@Getter
@AllArgsConstructor
public class Holiday {

    private   String day;
    private   String reason;
    private   Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }


}
