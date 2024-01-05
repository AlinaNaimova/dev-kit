package ru.alina_corp.seminar1hw;

import ru.alina_corp.seminar1hw.client.ClientGUI;
import ru.alina_corp.seminar1hw.server.ServerWindow;

public class Main {
    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}