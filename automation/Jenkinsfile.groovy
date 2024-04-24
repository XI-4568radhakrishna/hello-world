pipeline {
    agent any;

    environment {
        GITHUB_REPO = "MohamedHamdy404/devops"
        DOCKER_REGISTRY = ""
        DOCKER_IMAGE = ""
        imageTag = ""
        imageName = ""
    }

    stages {
        stage("checkout") {
            steps {
                git url: "https://github.com/${GITHUB_REPO}.git", branch: 'develop'
                sh 'cat flag.txt'
            }
        }

        stage("tagging") {
            steps {
                script {
                    sh 'echo "autotag started"'
                    sh "git config --global --add safe.directory ${env.WORKSPACE}"
                    env.MY_BRANCH= "dev"
                    sh 'echo "TAG IS STARTED" '
                    sh 'echo ${MY_BRANCH}'
                    
                }
            }
        }
    }
}