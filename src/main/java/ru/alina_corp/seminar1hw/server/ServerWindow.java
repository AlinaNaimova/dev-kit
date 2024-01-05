package ru.alina_corp.seminar1hw.server;

import ru.alina_corp.seminar1hw.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ServerWindow extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    public static final String LOG_PATH = "src/main/java/ru/alina_corp/seminar2hw/server/log.txt";

    List<ClientGUI> clientGUIList;
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private JTextArea log = new JTextArea();
    private boolean isServerWorking;


    public ServerWindow() {
        clientGUIList = new ArrayList<>();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        // Создание панели
        createPanel();
        // Отображение окна
        setVisible(true);
        setResizable(false);
    }

    public boolean userConnectionOn(ClientGUI clientGUI) {
        if (!isServerWorking) {
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    public void message(String text){
        if (!isServerWorking){
            return;
        }
        text += "";
        addLog(text);
        answer(text);
        saveInLog(text);
    }
    private void addLog(String text){
        log.append(text + "\n");
    }
    private void answer(String text){
        for (ClientGUI clientGUI: clientGUIList){
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_PATH, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLogs() {
        try {
            return new String(Files.readAllBytes(Paths.get(LOG_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getLog() {
        return readLogs();
    }

    public void userConnectionOff(ClientGUI clientGUI) {
        clientGUI.remove(clientGUI);
        if (clientGUI != null) {
            clientGUI.disconnectFromServer();
        }
    }

    private void createPanel() { // Метод для создания панели с кнопками и полем для сообщений

        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() { // Метод для создания панели с кнопками

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(btnStart);
        panel.add(btnStop);

        btnStart.addActionListener(e -> {
            if (isServerWorking) {
                addLog("Server has already been started!!!");
            } else {
                isServerWorking = true;
                addLog("Server is started!");
            }
        });

        btnStop.addActionListener(e -> {
            if (!isServerWorking) {
                addLog("Server has already been stopped");
            } else {
                isServerWorking = false;
                addLog("Server is stopped!");
            }
        });
        return panel;

    }
}