// This script will list all active inline pipeline jobs in Jenkins

// Function to check if a job is an inline pipeline job
boolean isInlinePipelineJob(job) {
    return job instanceof org.jenkinsci.plugins.workflow.job.WorkflowJob && job.definition instanceof org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition
}

// Iterate over all jobs and print the names of active inline pipeline jobs
def jenkins = Jenkins.instance
jenkins.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each { job ->
    if (job.isBuildable() && isInlinePipelineJob(job)) {
        println "Active Inline Pipeline Job: ${job.fullName}"
    }
}
