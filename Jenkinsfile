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
                sh "ssh -i ~/.ssh/id_rsa spleefleague@live.spleef.gg mkdir -p ./plugins/${BRANCH_NAME}"
                sh "rm ./target/original*"
                sh "scp -i ~/.ssh/id_rsa ./target/*.jar spleefleague@live.spleef.gg:~/plugins/${BRANCH_NAME}/"
            }
        }
    }

}
