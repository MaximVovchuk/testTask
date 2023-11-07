package com.botscrew.testTask;

import com.botscrew.testTask.commands.CommandsGenerator;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Component
public class EntryPoint implements CommandLineRunner {

    private final List<CommandsGenerator> commands;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("Exit")) {
                break;
            } else {
                for (CommandsGenerator commandsGenerator : commands) {
                    if (command.matches(commandsGenerator.getCommandRegex())) {
                        String content = command.replaceAll(commandsGenerator.getCommandRegex(), "$1");
                        commandsGenerator.sendAnswer(content);
                        break;
                    }
                }
            }
        }
    }
}