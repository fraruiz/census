package ar.edu.ungs.app.web;

import ar.edu.ungs.census.shared.domain.ConsoleCommand;
import ar.edu.ungs.census.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                                                      classes = Service.class),
               value = { "ar.edu.ungs.census", "ar.edu.ungs.app" })
public class WebConsoleCommand implements ConsoleCommand {
	@Override
	public void execute(String[] args) {

	}
}
