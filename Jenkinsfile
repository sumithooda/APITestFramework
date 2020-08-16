pipeline {
    agent any
    tools {
        maven 'Maven3.6.3'
    }
    stages {
        stage('Compile Stage') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Testing Stage') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Results') {
            steps{
                publishHTML([allowMissing: false,
                             alwaysLinkToLastBuild: true,
                             keepAll: true,
                             reportDir:
                                     'target/surefire-reports/',
                             reportFiles: 'index.html',
                             reportName: 'Test Results'
                ])
            }
        }
    }
}