package edu.javaproject.net.greet;

import edu.javaproject.net.Greetable;

public class MorningGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good morning, " + userName;
    }
}
