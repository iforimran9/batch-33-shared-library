def call(Map config = [:]) {

    def repoUrl      = config.get('repoUrl')
    def jobName      = config.get('jobName')

    stage('PreBuild Checks') {
        preBuild(repoUrl)
    }

    stage('Sonar Analysis') {
        sonarCheck(jobName, jobName)
    }

    stage('Build') {
        mavenBuild()
    }

    stage('Deploy Locally') {
        deployLocally()
    }
}
