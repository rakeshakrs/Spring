package com.rakeshpoc.schoolapp.model;

import lombok.*;

@Data
public class Holiday extends BaseEntity{

    private   String day;
    private   String reason;
    private   Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }


}
