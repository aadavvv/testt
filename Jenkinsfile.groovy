import jenkins.model.Jenkins
import hudson.security.Permission

def getAllUsersAndPermissions() {
    def allUsersAndPermissions = [:]

    Jenkins.instance.authorizationStrategy.getAllPermissions().each { permission ->
        allUsersAndPermissions[permission] = []

        Jenkins.instance.getAllItems().each { item ->
            def permissions = item.getACL().getPermissions()
            if (permissions.contains(permission)) {
                permissions[permission].each { principal ->
                    if (principal.type == 'user') {
                        allUsersAndPermissions[permission] << principal.name
                    }
                }
            }
        }
    }

    return allUsersAndPermissions
}

def printUsersAndPermissions() {
    def usersAndPermissions = getAllUsersAndPermissions()

    usersAndPermissions.each { permission, users ->
        println("Permission: ${permission}")
        users.unique().each { user ->
            println("  - ${user}")
        }
    }
}

printUsersAndPermissions()
