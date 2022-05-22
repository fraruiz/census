package ar.edu.ungs.app;

import ar.edu.ungs.app.swing.SwingConsoleCommand;
import ar.edu.ungs.app.web.WebConsoleCommand;
import ar.edu.ungs.census.shared.domain.ConsoleCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Starter {
	private final static Map<String, Class<? extends ConsoleCommand>> commands = commands();
	private final static Set<String> commandsServers = commandServers();

	public static void main(String[] args) {
		ensureCommandExists(args);

		String commandName = args[0];

		run(commandName, Arrays.copyOfRange(args, 1, args.length));
	}

	private static void run(String commandName, String[] args) {
		try {
			boolean isServerCommand = commandsServers.contains(commandName);

			Class<? extends ConsoleCommand> commandClass = commands.get(commandName);
			SpringApplication app = new SpringApplication(commandClass);

			if (!isServerCommand) {
				app.setWebApplicationType(WebApplicationType.NONE);
			}

			ConfigurableApplicationContext context = app.run(args);

			if (!isServerCommand) {
				ConsoleCommand bean = context.getBean(commands().get(commandName));

				bean.execute(Arrays.copyOfRange(args, 2, args.length));
			}

		} catch (Exception error) {
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

	private static Set<String> commandServers() {
		return Set.of("web");
	}

	private static Map<String, Class<? extends ConsoleCommand>> commands() {
		return Map.of("swing", SwingConsoleCommand.class, "web", WebConsoleCommand.class);
	}
}
