package ar.edu.ungs.census.shared.infrastructure.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class JsonFileRepository<T> {
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
		} catch (Exception error) {
			error.printStackTrace();
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
		String filePath = findFilePath();
		File fileToRead = new File(filePath);

		FileReader reader = new FileReader(fileToRead);
		BufferedReader bufferedReader = new BufferedReader(reader);

		return objectMapper.readTree(bufferedReader);
	}

	private String findFilePath() {
		ClassLoader classLoader = getClass().getClassLoader();
		return Objects.requireNonNull(classLoader.getResource(fileName)).getPath();
	}

	protected abstract Map<String, Object> parseToJson(T aggregate);

	private List<Map<String, Object>> parseToJson(List<T> aggregates) {
		return aggregates.stream().map(this::parseToJson).collect(Collectors.toList());
	}

	protected abstract T parseFromJson(JsonNode jsonNode);
}
