import hudson.model.*
import jenkins.model.Jenkins

configureSecurity()

Jenkins.instance.save()

buildJob('seed')

private void configureSecurity() {
    Jenkins.getInstance().disableSecurity()
}

private def buildJob(String jobName) {
    def job = Jenkins.instance.getJob(jobName)
    Jenkins.instance.queue.schedule(job, 0, new CauseAction(new Cause() {
        @Override
        String getShortDescription() {
            'Jenkins startup script'
        }
    }))
}