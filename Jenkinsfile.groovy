import jenkins.model.Jenkins

def listPipelinesWithInlineScript() {
    def pipelinesWithInlineScript = []

    Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each { job ->
        def definition = job.getDefinition()
        if (definition instanceof org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition) {
            // Check if the definition is an inline script
            if (definition.scriptPath == null || definition.scriptPath.trim() == "") {
                pipelinesWithInlineScript << job.fullName
            }
        }
    }

    return pipelinesWithInlineScript
}

def result = listPipelinesWithInlineScript()
println("Pipelines using inline scripts: $result")
