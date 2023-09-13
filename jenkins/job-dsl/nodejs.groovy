job('NodeJS example') {
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
        shell('npm install')
    }
}