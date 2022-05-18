package ar.edu.ungs.app;

import ar.edu.ungs.app.swing.SwingConsoleCommand;
import ar.edu.ungs.census.shared.domain.ConsoleCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public final class Starter {
	private final static Map<String, Class<? extends ConsoleCommand>> commands = commands();

	public static void main(String[] args) {
		ensureCommandExists(args);

		String commandName = args[0];

		run(commandName, Arrays.copyOfRange(args, 1, args.length));
	}

	private static void run(String commandName, String[] args) {
		try {
			commands.get(commandName).getConstructor().newInstance().execute(args);
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException error) {
			throw new RuntimeException(String.format("can not run <%s> command", commandName));
		}
	}

	private static void ensureCommandExists(String[] args) {
		if (args[0] == null || args[0].isEmpty()) {
			throw new RuntimeException("the command not selected");
		}

		if (!commands.containsKey(args[0])) {
			throw new RuntimeException(String.format("the command <%s> not exists", args[0]));
		}
	}

	private static Map<String, Class<? extends ConsoleCommand>> commands() {
		return Map.of("swing", SwingConsoleCommand.class);
	}
}
