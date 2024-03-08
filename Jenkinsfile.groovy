def currentDate = new Date()
def startOfDay = currentDate.clearTime()

def totalJobsTriggered = 0

Jenkins.instance.getAllItems().each { job ->
    job.builds.each { build ->
        if (build.getTime().after(startOfDay)) {
            totalJobsTriggered++
        }
    }
}

println "Total number of jobs triggered today: ${totalJobsTriggered}"
