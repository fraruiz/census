package ar.edu.ungs.census.shared.infrastructure.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class JsonFileRepository<T> {
	private final Logger logger = LoggerFactory.getLogger(JsonFileRepository.class);

	private final ObjectMapper objectMapper;
	private final String fileName;

	public JsonFileRepository(ObjectMapper objectMapper, String fileName) {
		this.objectMapper = objectMapper;
		this.fileName = fileName;
	}

	private void write(String object) {
		try {
			String filePath = findFilePath();

			FileWriter file = new FileWriter(filePath);
			file.write(object);
			file.flush();

			logger.info(filePath + " written");
		} catch (Exception error) {
			error.printStackTrace();
			logger.error("error trying write a " + fileName + " file", error);
		}
	}

	protected void persist(T aggregate) throws JsonProcessingException {
		String object = objectMapper.writeValueAsString(this.parseToJson(aggregate));
		write(object);
	}

	public void clean() {
		write("");
	}

	protected void persist(List<T> aggregates) throws JsonProcessingException {
		String object = objectMapper.writeValueAsString(this.parseToJson(aggregates));

		write(object);
	}

	protected JsonNode read() throws IOException {
		try {
			String filePath = findFilePath();
			File fileToRead = new File(filePath);

			FileReader reader = new FileReader(fileToRead);
			BufferedReader bufferedReader = new BufferedReader(reader);

			logger.info(filePath + "read");

			return objectMapper.readTree(bufferedReader);
		} catch (Exception error) {
			logger.error("error trying read a " + fileName + " file", error);

			throw error;
		}
	}

	private String findFilePath() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			String path = Objects.requireNonNull(classLoader.getResource(fileName)).getPath();

			logger.info(path + " found");

			return path;
		} catch (Exception error) {
			logger.error(fileName + " not found", error);
			throw error;
		}
	}

	protected abstract Map<String, Object> parseToJson(T aggregate);

	private List<Map<String, Object>> parseToJson(List<T> aggregates) {
		return aggregates.stream().map(this::parseToJson).collect(Collectors.toList());
	}

	protected abstract T parseFromJson(JsonNode jsonNode);
}
