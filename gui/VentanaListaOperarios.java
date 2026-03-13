package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaListaOperarios extends JFrame {

    private JTextArea areaLista;

    public VentanaListaOperarios(String lista) {

        setTitle("Lista de Operarios");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(null);

        areaLista = new JTextArea();
        areaLista.setText(lista);
        areaLista.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaLista);
        scroll.setBounds(20,20,350,220);

        add(scroll);
    }
}