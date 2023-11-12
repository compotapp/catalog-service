#❶ Базовый образ OpenJDK для первого этапа
FROM eclipse-temurin:17 AS builder
WORKDIR workspace
#❷ Создает аргумент, указывающий расположение JAR-файла приложения в вашем проекте
ARG JAR_FILE=build/libs/*.jar
#❸ Копирует JAR-файл приложения с локального компьютера в изображение внутри папки «рабочая область»
COPY ${JAR_FILE} catalog-service.jar
#❹ Извлекает слои из архива, применяя режим слоя
RUN java -Djarmode=layertools -jar catalog-service.jar extract
#❺ Базовый образ OpenJDK для второго этапа
FROM eclipse-temurin:17
#❶ Создает «spring» пользователя стр231
RUN useradd spring
#❷ Настраивает «spring» как текущего пользователя
USER spring
WORKDIR workspace
#❻ Копирует каждый слой JAR с первого этапа на второй этап внутри папки «рабочая область»
COPY --from=builder workspace/dependencies/ ./
COPY --from=builder workspace/spring-boot-loader/ ./
COPY --from=builder workspace/snapshot-dependencies/ ./
COPY --from=builder workspace/application/ ./
#❼ Использует Spring Boot Launcher для запуска приложения из слоев, а не из uber-JAR
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]