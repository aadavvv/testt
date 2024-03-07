import jenkins.model.Jenkins
import hudson.security.AuthorizationMatrixProperty

// Get the Jenkins instance
def jenkins = Jenkins.instance

jenkins.items.each { item ->
    if (item instanceof hudson.model.ItemGroup) {
        // Check if the item is a folder
        if (item instanceof hudson.model.CompositeItem) {
            // Get the folder path
            def folderPath = item.fullName

            // Get the folder item
            def folderItem = jenkins.getItemByFullName(folderPath)

            if (folderItem instanceof hudson.model.Item) {
                // Check if the folder has AuthorizationMatrixProperty
                def property = folderItem.getProperty(AuthorizationMatrixProperty)

                if (property) {
                    // Get the permission list
                    def permissions = property.getGrantedPermissions()

                    // Print the users and their permissions
                    permissions.each { user ->
                        println("Folder: ${folderPath}, User: ${user.identity}, Permissions: ${user.permission}")
                    }
                } else {
                    println("Folder ${folderPath} doesn't have AuthorizationMatrixProperty.")
                }
            } else {
                println("Folder not found: ${folderPath}")
            }
        }
    }
}
