Important:- It's required to have postgres SQL and add the external libraries provided in lib folder (activation,javax.mail and postgresql). Queries to create the tables are provided in tableQueries.txt.
app.java is the main class



Use of OOP principles

Single Responsibility Principle:-Each class of this program only deals with one set of tasks.
For example, the serviceProviders.consoleServices class has all the methods that deal with the console (getting string inputs, choosing between personal and official, and getting int/string inputs). Likewise, Database serviceProviders have all methods related to accessing databases and serviceProviders.emailServices have all the methods regarding sending emails.serviceProviders.ReminderServices has all the methods(edit, update, and delete). This improves the maintainability.

Open Close Principle:- Most of the methods were implemented in a way to use generally. This will help to extend the functionality of the program without modifying it.

Liskov Substitution Principle:- In the program serviceProviders.manageReminderPersonalServices and serviceProviders.manageReminderOfficialServices has extended the abstract class serviceProviders.ReminderServices, and it's a perfect substitution. For now above classes only have the methods of the Reminder Services class, but I made them, so it will be easier to add unique methods for each class if needed in the future.

Other OOP concepts like Inheritance, Abstraction, Encapsulation, and Polymorphism have been implemented.