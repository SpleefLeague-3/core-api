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
                sh "echo ${env.POM_ARTIFACTID}"
                sh "echo ${POM_ARTIFACTID}"
                sh "scp -i ~/.ssh/id_rsa ./target/${IMAGE}.jar"
            }
        }
    }

}