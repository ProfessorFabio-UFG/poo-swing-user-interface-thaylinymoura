import javax.swing.*;
import java.awt.*;

public class LayoutInterface extends JFrame {
    public LayoutInterface() {
        setTitle("Ficha de Avaliação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 750);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());


        JMenuBar menuBar = new JMenuBar();
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenu editarMenu = new JMenu("Editar");

        JMenuItem enviarMenuItem = new JMenuItem("Enviar");
        JMenu enviarSubMenu = new JMenu("Enviar");
        JMenuItem emailMenuItem = new JMenuItem("email");
        JMenuItem impressoraMenuItem = new JMenuItem("impressora");
        enviarSubMenu.add(emailMenuItem);
        enviarSubMenu.add(impressoraMenuItem);

        JMenuItem salvarMenuItem = new JMenuItem("Salvar");
        JMenuItem sairMenuItem = new JMenuItem("Sair");

        arquivoMenu.add(enviarSubMenu);
        arquivoMenu.add(salvarMenuItem);
        arquivoMenu.add(sairMenuItem);

        menuBar.add(arquivoMenu);
        menuBar.add(editarMenu);
        setJMenuBar(menuBar);


        JPanel superiorPanel = new JPanel(new GridBagLayout());
        superiorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        JLabel tituloLabel = new JLabel("Ficha de Avaliação");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setForeground(Color.RED);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        superiorPanel.add(tituloLabel, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        superiorPanel.add(new JLabel("Código:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField codigoField = new JTextField(20);
        superiorPanel.add(codigoField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        superiorPanel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField nomeField = new JTextField(20);
        superiorPanel.add(nomeField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        superiorPanel.add(new JLabel("Sexo:"), gbc);

        JPanel sexoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        JRadioButton femininoRadio = new JRadioButton("Feminino");
        JRadioButton masculinoRadio = new JRadioButton("Masculino");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(femininoRadio);
        sexoGroup.add(masculinoRadio);
        sexoPanel.add(femininoRadio);
        sexoPanel.add(masculinoRadio);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        superiorPanel.add(sexoPanel, gbc);


        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel cvPanel = new JPanel(new BorderLayout());
        cvPanel.setBorder(BorderFactory.createTitledBorder("Curriculum Vitae"));
        JTextArea cvTextArea = new JTextArea(10, 50);
        cvTextArea.setLineWrap(true);
        cvTextArea.setWrapStyleWord(true);
        JScrollPane cvScrollPane = new JScrollPane(cvTextArea);
        cvPanel.add(cvScrollPane, BorderLayout.CENTER);
        centralPanel.add(cvPanel);
        centralPanel.add(Box.createVerticalStrut(15));

        JPanel areasPanel = new JPanel(new GridBagLayout());
        areasPanel.setBorder(BorderFactory.createTitledBorder("Áreas"));
        GridBagConstraints areasGbc = new GridBagConstraints();
        areasGbc.insets = new Insets(5, 5, 5, 5);


        areasGbc.gridx = 0;
        areasGbc.gridy = 0;
        areasGbc.anchor = GridBagConstraints.WEST;
        areasPanel.add(new JLabel("Interesse:"), areasGbc);

        areasGbc.gridx = 1;
        areasGbc.gridy = 0;
        areasGbc.fill = GridBagConstraints.HORIZONTAL;
        areasGbc.weightx = 1.0;
        String[] interesses = {"Desenvolvedor", "Designer", "Tester", "Gerente de Projetos"};
        JComboBox<String> interesseComboBox = new JComboBox<>(interesses);
        areasPanel.add(interesseComboBox, areasGbc);


        areasGbc.gridx = 2;
        areasGbc.gridy = 0;
        areasGbc.fill = GridBagConstraints.NONE;
        areasGbc.weightx = 0;
        areasGbc.anchor = GridBagConstraints.WEST;
        areasPanel.add(new JLabel("Atuação:"), areasGbc);

        areasGbc.gridx = 3;
        areasGbc.gridy = 0;
        areasGbc.fill = GridBagConstraints.HORIZONTAL;
        areasGbc.weightx = 1.0;
        String[] atuacoes = {"Programação", "Banco de Dados", "Redes", "Infraestrutura"};
        JComboBox<String> atuacaoComboBox = new JComboBox<>(atuacoes);
        areasPanel.add(atuacaoComboBox, areasGbc);

        centralPanel.add(areasPanel);


        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        botoesPanel.setBackground(Color.GREEN.darker());
        botoesPanel.add(new JButton("Salvar"));
        botoesPanel.add(new JButton("Anterior"));
        botoesPanel.add(new JButton("Próximo"));
        botoesPanel.add(new JButton("Novo"));
        botoesPanel.add(new JButton("Cancelar"));


        add(superiorPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LayoutInterface app = new LayoutInterface();
            app.setVisible(true);
        });
    }
}


