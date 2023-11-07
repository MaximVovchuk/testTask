package com.botscrew.testTask;

import com.botscrew.testTask.commands.CommandsGenerator;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Component
public class CommandInterface implements CommandLineRunner {

    private final List<CommandsGenerator> commands;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) {
        while (true) {
            if (handleCommand()) break;
        }
    }

    private boolean handleCommand() {
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        if (command.equals("Exit")) {
            return true;
        } else {
            for (CommandsGenerator commandsGenerator : commands) {
                if (command.matches(commandsGenerator.getCommandRegex())) {
                    String content = command.replaceAll(commandsGenerator.getCommandRegex(), "$1");
                    commandsGenerator.sendAnswer(content);
                    return false;
                }
            }
            System.out.println("Command not found");
        }
        return false;
    }
}