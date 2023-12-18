public class customerServices {
    static void addCustomer(){
        int pk= DatabaseServices.getNumberOfEntries("customers");
        DatabaseServices.addDataCustomer(pk+1, consoleServices.readStringFromConsole("Customer name: "), consoleServices.readBooleanFromConsole("Enter subscription(true/false): "), consoleServices.readStringFromConsole("Enter email:"));
    }
}
