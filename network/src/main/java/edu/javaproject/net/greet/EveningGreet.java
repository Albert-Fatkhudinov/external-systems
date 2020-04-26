package edu.javaproject.net.greet;

import edu.javaproject.net.Greetable;

public class EveningGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good evening, " + userName;
    }
}
