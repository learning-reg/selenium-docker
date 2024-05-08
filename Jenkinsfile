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
                sh "docker build -t=dmitrysavin/selenium:latest ."
            }
        }

        stage('Push image') {
            environment {
                DOCKER_HUB = credentials('docker_hub_credentials')
            }
            steps {
                sh 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin '
                sh "docker push dmitrysavin/selenium:latest"
                sh "docker tag dmitrysavin/selenium:latest docker dmitrysavin/selenium:${evn.BUILD_NUMBER}"
                sh "docker push dmitrysavin/selenium:${evn.BUILD_NUMBER}"
            }
        }
    }

    post {
        always {
            sh "docker logout"
        }
    }
}
