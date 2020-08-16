pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sumithooda/APITestFramework.git'
            }
        }

        stage('Integration Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}