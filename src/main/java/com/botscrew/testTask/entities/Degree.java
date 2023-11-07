package com.botscrew.testTask.entities;

public enum Degree { // converter is in /util
    ASSISTANT(1),
    ASSOCIATE_PROFESSOR(2),
    PROFESSOR(3);
    private final Integer code;

    Degree(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
