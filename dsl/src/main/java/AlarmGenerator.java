public class AlarmGenerator {
    // Run everytime there is a change to the file, rerun this observer pattern
    //  - Use executor scheduler to manually poll the file
    //  - use watch service  https://blog.arkey.fr/2019/09/13/watchservice-and-bind-mount/
    // Place config file in github using webhooks
    public void generate() {
        // Grab rules from file, turn to list of user rules split on new lines
        // parse each user rule, and create list of Map.Entries
        // Create alarms for each rule, (store in repository??)
        // for each alarm notify google calendar (include remove all rules first)
    }
}
