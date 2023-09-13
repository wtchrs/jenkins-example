job('NodeJS docker example') {
    scm {
        git('https://github.com/wtchrs/simple-nodejs-app.git') { node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('node')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('wtchrs/docker-nodejs-example')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}