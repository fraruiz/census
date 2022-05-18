.PHONY: all
all: build

.PHONY: build
build:
	@./gradlew build --warning-mode all

.PHONY: test
test:
	@./gradlew test --warning-mode all

# Start the app
.PHONY: start-swing
start-swing:
	@./gradlew :run --args='swing'