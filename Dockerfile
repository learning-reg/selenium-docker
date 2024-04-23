# Set base container
FROM bellsoft/liberica-openjdk-alpine:17.0.10

# Install utilities (curl and jq)
RUN apk add curl jq

# Create a working directory inside the container
WORKDIR /home/selenium-docker

# Copy all the files and resources
ADD target/docker-resources      ./
ADD runner.sh                    runner.sh

# Start the runner.sh
ENTRYPOINT sh runner.sh
