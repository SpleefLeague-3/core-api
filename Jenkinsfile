pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                sh "scp -i ~/.ssh/id_rsa ./target/${env.POM_ARTIFACTID}.jar"
            }
        }
    }

}