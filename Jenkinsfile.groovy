def currentDate = new Date()
def startOfDay = currentDate.clearTime()

def totalJobsTriggered = 0

Jenkins.instance.getAllItems().each { job ->
    job.getBuilds().each { build ->
        if (build.getTime().after(startOfDay)) {
            totalJobsTriggered++
        }
    }
}

Jenkins.instance.getAllItems(com.cloudbees.hudson.plugins.folder.Folder.class).each { folder ->
    folder.getItems().each { job ->
        job.getBuilds().each { build ->
            if (build.getTime().after(startOfDay)) {
                totalJobsTriggered++
            }
        }
    }
}

println "Total number of jobs triggered today: ${totalJobsTriggered}"
