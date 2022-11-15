import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Minhajanela extends JFrame {
private JButton botao;
private JTextField campo;

    public Minhajanela() {
        super();
        // criacao dos componentes
        botao = new JButton();
        campo = new JTextField(30);
        // criar layout
        FlowLayout layout= new FlowLayout();

        // container intermediario

        JPanel painel = new JPanel();

        painel.setLayout(layout);
        
        // adicionar componentes no container

        painel.add(campo);
        painel.add(botao);
        add(painel);

        // eventos

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campo.getText();
                setTitle(texto);
            }
        });
    
        setSize(800,600);
        setTitle("Turma 30");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }

    
}
