pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/XI-4568radhakrishna/hello-world.git']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t javatechie/devops-integration .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'Dockercreds', variable: 'Dockercreds')]) {
                   sh 'docker login -u radhakrishnamopuru459 -p ${dockerhubpwd}'

        }
                   sh 'docker push javatechie/devops-integration'
                }
            }
        
            }
        }
    }
}
