// Get the Jenkins instance
def jenkinsInstance = Jenkins.getInstance()

// Get the Plugin Manager
def pluginManager = jenkinsInstance.getPluginManager()

// Get the list of all installed plugins
def plugins = pluginManager.getPlugins()

// Iterate through the list and print plugin name and version
plugins.each { plugin ->
    println("${plugin.getShortName()}: ${plugin.getVersion()}")
}
