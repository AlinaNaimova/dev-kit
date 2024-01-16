package ru.alina_corp.seminar2;

import ru.alina_corp.seminar2.client.ui.ClientGUI;
import ru.alina_corp.seminar2.server.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}