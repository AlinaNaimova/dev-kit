package ru.alina_corp.seminar1hw.client;

import ru.alina_corp.seminar1hw.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private JTextArea log = new JTextArea();

    private JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.8.8.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("anon");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");
    private JTextField tfMessage = new JTextField();
    private JButton btnSend = new JButton("Send");

    private ServerWindow server;
    private boolean connected;
    private String name;
    public ClientGUI(ServerWindow server) {
        this.server = server;

        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        setResizable(false);

        createPanel();
        setVisible(true);
    }

    public void answer(String text) {
        appendLog(text);
    }

    private void connectToServer() {
        if (server.userConnectionOn(this)){
            appendLog("Вы успешно подключились!\n");
            panelTop.setVisible(false);
            connected = true;
            name = tfLogin.getText();
            String log = server.getLog();
            if (log != null){
                appendLog(log);
            }
        } else {
            appendLog("Подключение не удалось");
        }
    }

    public void disconnectFromServer() {
        if (connected) {
            panelTop.setVisible(true);
            connected = false;
            server.userConnectionOff(this);
            appendLog("Вы были отключены от сервера!");
        }
    }

    public void message(){
        if (connected){
            String text = tfMessage.getText();
            if (!text.equals("")){
                server.message(name + ": " + text);
                tfMessage.setText("");
            }
        } else {
            appendLog("Нет подключения к серверу");
        }

    }

    private void appendLog(String text){
        log.append(text + "\n");
    }

    private void createPanel() {
        add(panelTop(), BorderLayout.NORTH);
        add(createLog());
        add(panelBottom(), BorderLayout.SOUTH);
    }

    private Component panelTop(){
        panelTop = new JPanel(new GridLayout());
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(new JPanel());
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);
        return panelTop;
    }

    private Component createLog(){
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component panelBottom() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    message();
                }
            }
        });
        btnSend = new JButton("send");
        btnSend.addActionListener(e -> message());
        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectFromServer();
        }
        super.processWindowEvent(e);
    }
}



