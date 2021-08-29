FROM openjdk:11

ARG WORK_DIR="/app/config"

USER root
RUN useradd -s /sbin/nologin user
ADD target/hackathon-1.0.jar /app/service.jar

# Add config files to work dir
ADD src/main/resources/application.yml /app/config/application.yml

USER user
CMD ["java", "-jar", "/app/service.jar"]

