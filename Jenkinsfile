pipeline {

    agent any

    stages {
        stage('Build jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        stage('Build image') {
            steps {
                sh "docker build -t=dmitrysavin/selenium ."
            }
        }

        stage('Push image') {
            steps {
                sh "docker push dmitrysavin/selenium"
            }
        }
    }
}
