package com.botscrew.testTask.commands;

public interface CommandsGenerator {
    String getCommandRegex();
    void sendAnswer(String command);
}
