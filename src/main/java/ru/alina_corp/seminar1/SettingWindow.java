package ru.alina_corp.seminar1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой следующие компоненты в
заданном порядке: JLabel с заголовком «Выберите режим игры», сгруппированные в ButtonGroup переключаемые JRadioButton
с указанием режимов «Человек против компьютера» и «Человек против человека», JLabel с заголовком «Выберите размеры
поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10, JLabel с заголовком «Выберите
длину для победы», JLabel с заголовком «Установленная длина:», JSlider со значениями 3..10.
 */
public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    JButton btnStart = new JButton("Start new game");
    JLabel labelChangeMode = new JLabel("Выберите режим игры");
    JRadioButton radioButtonMan = new JRadioButton("Человек против человека");
    JRadioButton radioButtonAi = new JRadioButton("Человек против компьютера");
    JLabel labelChangeSize = new JLabel("Выберите размеры поля");
    JLabel labelSelectedSize = new JLabel("Установленный размер поля: ");
    JSlider sliderSize = new JSlider(3, 10, 3);
    JLabel labelMinLength = new JLabel("Выберите длину для победы");
    JLabel labelSetLength = new JLabel("Установленная длина: ");
    JSlider sliderMinLength = new JSlider(3,10, 3);


    SettingWindow(GameWindow gameWindow){

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                int mode = 0;
                if (radioButtonMan.isSelected()) {
                    mode = 1;
                } else if (radioButtonAi.isSelected()) {
                    mode = 2;
                }
                gameWindow.startNewGame(mode, sliderSize.getValue(), sliderSize.getValue(), sliderMinLength.getValue());
            }
        });
        createMainPanel();
    }

    private JComponent createChoiceModePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(labelChangeMode);
        panel.add(radioButtonMan);
        panel.add(radioButtonAi);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonMan);
        buttonGroup.add(radioButtonAi);
        return panel;
    }

    private JComponent createChoiceSizePanel() {
        JPanel panel =  new JPanel(new GridLayout(3, 1));
        panel.add(labelChangeSize);
        panel.add(labelSelectedSize);
        panel.add(sliderSize);
        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelSelectedSize.setText("Установленный размер поля: " + sliderSize.getValue());
                sliderMinLength.setMaximum(sliderSize.getValue());
            }
        });
        return panel;
    }

    private JComponent createChoiceLengthPanel() {
        JPanel panel =  new JPanel(new GridLayout(3, 1));
        panel.add(labelMinLength);
        panel.add(labelSetLength);
        panel.add(sliderMinLength);
        sliderMinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelSetLength.setText("Установленная длина: " + sliderMinLength.getValue());
            }
        });
        return panel;
    }

    private void createMainPanel() {
        JPanel panel =  new JPanel(new GridLayout(3, 1));
        panel.add(createChoiceModePanel());
        panel.add(createChoiceSizePanel());
        panel.add(createChoiceLengthPanel());
        add(panel);
        add(btnStart, BorderLayout.SOUTH);
    }
}
