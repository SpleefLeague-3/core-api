pipeline {
    agent any

    environment {
        IMAGE = readMavenPom().getArtifactId()
        VERSION = readMavenPom().getVersion()
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                sh "echo ${IMAGE} ${VERSION}"
                sh "scp -i ~/.ssh/id_rsa ./target/${IMAGE}.jar"
            }
        }
    }

}