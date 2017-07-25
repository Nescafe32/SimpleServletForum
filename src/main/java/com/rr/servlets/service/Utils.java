package com.rr.servlets.service;

import com.rr.servlets.model.ForumMessage;
import com.rr.servlets.model.ForumUser;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static Utils instance;

    private static List<ForumUser> users;
    private static List<ForumMessage> messages;

    private Utils() {}

    private static void initlists() {
        if (users == null)
            users = new ArrayList<>();
        if (messages == null)
            messages = new ArrayList<>();
    }


    public static synchronized Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
            initlists();
        }
        return instance;
    }

    public static boolean isUserExists(ForumUser user) {
        for (ForumUser forumUser: users)
            if (forumUser.equals(user))
                return true;

        return false;
    }


    public static void addUser(ForumUser user) {
        users.add(user);
    }

    public static void addMessage(ForumMessage message) {
        messages.add(message);
    }

    public static List<ForumMessage> getMessages() {
        return messages;
    }
}
