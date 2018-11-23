package pars;

import java.awt.Color;
import java.awt.EventQueue;
import java.math.BigDecimal;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class form extends JFrame {

    public JPanel contentPane;
    public static JTextField textEdit1;
    public static String str = "";
    private JTextField textEdit2;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    form frame = new form();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public form() {
        setResizable(false);
        setTitle("\u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440 \u0434\u0440\u043E\u0431\u043D\u043E\u0439 \u0434\u043B\u0438\u043D\u043D\u043E\u0439 \u0430\u0440\u0438\u0444\u043C\u0435\u0442\u0438\u043A\u0438");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 440);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        textEdit1 = new JTextField();
        textEdit1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textEdit1.setEditable(false);
        textEdit1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                boolean error = false;
                switch (arg0.getKeyChar()) {
                    case '1': {
                        str = str + '1';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '2': {
                        str = str + '2';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '3': {
                        str = str + '3';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '4': {
                        str = str + '4';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '5': {
                        str = str + '5';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '6': {
                        str = str + '6';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '7': {
                        str = str + '7';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '8': {
                        str = str + '8';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '9': {
                        str = str + '9';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '0': {
                        str = str + '0';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '-': {
                        str = str + '-';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '+': {
                        str = str + '+';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '*': {
                        str = str + '*';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '/': {
                        str = str + '/';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '^': {
                        str = str + '^';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '(': {
                        str = str + '(';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case ')': {
                        str = str + ')';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '%': {
                        str = str + '%';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    case '.': {
                        str = str + '.';
                        textEdit1.setText(str);
                        textEdit1.requestFocus();
                        break;
                    }
                    default: {
                        break;
                    }
                }
                if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
                    BigDecimal result = new BigDecimal("0");
                    Parser myParser = new Parser();
                    try {
                        result = myParser.onee(str);
                    } catch (ParserException e) {
                        error = true;
                        textEdit2.setText("Некорректное выражение");
                    } catch (Exception e) {
                        error = true;
                        textEdit2.setText("Деление на 0");
                    }
                    if (!error) {
                        textEdit2.setText(result.toString());
                        error = false;
                    }
                    textEdit1.requestFocus();
                }

                if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (str.length() > 0) {
                        str = str.substring(0, str.length() - 1);
                        textEdit1.setText(str);
                    }
                    textEdit1.requestFocus();
                }
            }
        });
        textEdit1.setHorizontalAlignment(SwingConstants.RIGHT);
        textEdit1.setColumns(100);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textEdit1, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textEdit1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        );
        panel.setLayout(gl_panel);

        JButton btnNewButton = new JButton("=");
        btnNewButton.setBackground(new Color(244, 164, 96));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                boolean error = false;
                BigDecimal result = new BigDecimal("0");
                Parser myParser = new Parser();
                try {
                    str = textEdit1.getText();
                    result = myParser.onee(str);
                } catch (ParserException e) {
                    error = true;
                    textEdit2.setText("Некорректное выражение");
                    textEdit1.requestFocus();
                } catch (Exception e) {
                    error = true;
                    textEdit2.setText("Деление на 0 !");
                    textEdit1.requestFocus();
                }
                if (!error) {
                    textEdit2.setText(result.toString());
                    error = false;
                }
                textEdit1.requestFocus();
            }
        });

        JButton knopka_1 = new JButton("1");
        knopka_1.setBackground(new Color(240, 255, 255));
        knopka_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '1';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        knopka_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button2 = new JButton("2");
        button2.setBackground(new Color(240, 255, 255));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '2';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button3 = new JButton("3");
        button3.setBackground(new Color(240, 255, 255));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '3';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button3.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button4 = new JButton("4");
        button4.setBackground(new Color(240, 255, 255));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '4';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button4.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button5 = new JButton("5");
        button5.setBackground(new Color(240, 255, 255));
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '5';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button5.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button6 = new JButton("6");
        button6.setBackground(new Color(240, 255, 255));
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '6';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button6.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button7 = new JButton("7");
        button7.setBackground(new Color(240, 255, 255));
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '7';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button7.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button8 = new JButton("8");
        button8.setBackground(new Color(240, 255, 255));
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '8';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button8.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button9 = new JButton("9");
        button9.setBackground(new Color(240, 255, 255));
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '9';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button9.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button0 = new JButton("0");
        button0.setBackground(new Color(240, 255, 255));
        button0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '0';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button0.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_point = new JButton(".");
        button_point.setBackground(new Color(240, 255, 255));
        button_point.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '.';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_point.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_mul = new JButton("*");
        button_mul.setBackground(new Color(244, 164, 96));
        button_mul.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '*';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_mul.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_add = new JButton("+");
        button_add.setBackground(new Color(244, 164, 96));
        button_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '+';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_add.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_sub = new JButton("-");
        button_sub.setBackground(new Color(244, 164, 96));
        button_sub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '-';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_sub.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_div = new JButton("/");
        button_div.setBackground(new Color(244, 164, 96));
        button_div.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '/';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_div.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_xy = new JButton("x^y");
        button_xy.setBackground(new Color(244, 164, 96));
        button_xy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '^';
                textEdit1.setText(str);
                textEdit1.requestFocus();
                JOptionPane.showMessageDialog(null, "Возведение одного длинного числа в другое может занять много времени, а так же сильно загрузить процессор.");
            }
        });
        button_xy.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_percent = new JButton("%");
        button_percent.setBackground(new Color(244, 164, 96));
        button_percent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '%';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_percent.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_bracket1 = new JButton("(");
        button_bracket1.setBackground(new Color(244, 164, 96));
        button_bracket1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + '(';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_bracket1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton button_bracket2 = new JButton(")");
        button_bracket2.setBackground(new Color(244, 164, 96));
        button_bracket2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                str = str + ')';
                textEdit1.setText(str);
                textEdit1.requestFocus();
            }
        });
        button_bracket2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JButton button_clear_all = new JButton("AC");
        button_clear_all.setBackground(new Color(176, 196, 222));
        button_clear_all.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button_clear_all.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                str = "";
                textEdit1.setText(str);
                textEdit1.requestFocus();
                textEdit2.setText("");
            }
        });

        JButton button_backspace = new JButton("C");
        button_backspace.setBackground(new Color(176, 196, 222));
        button_backspace.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                    textEdit1.setText(str);
                    textEdit1.requestFocus();
                    textEdit2.setText("");
                }
            }
        });
        button_backspace.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textEdit2 = new JTextField();
        textEdit2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0), 2));
        textEdit2.setHorizontalAlignment(SwingConstants.RIGHT);
        textEdit2.setEditable(false);
        textEdit2.setColumns(100);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 726, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(68)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(button7, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button8, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button9, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_mul, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_bracket2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_sub, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_xy, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(knopka_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_div, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_percent, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(button0, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_point, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(button_backspace, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_clear_all, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_add, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(button_bracket1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(textEdit2, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(textEdit2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(button_backspace, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(button_clear_all, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(button_add, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(button_bracket1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))

                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(10)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(button8, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(button7, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(button_mul, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(button_bracket2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(2)))
                                                .addGap(9)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button_sub, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button_xy, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                .addGap(11)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(knopka_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(button_div, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(button_percent, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(button_point, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(button0, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
