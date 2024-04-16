pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/aitnacer-nabil/Happoy.git'
            }
        }

        stage('Clean and Test Category-Service') {
            steps {
                dir('Category-Service') {
                    bat 'mvn clean'
                    bat 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo 'Test succeeded!'
        }

        failure {
            echo 'Test failed!'
        }
    }
}