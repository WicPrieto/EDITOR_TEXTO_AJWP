package EditorTexto;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class EDITOR_TEXTO_AJWP extends JFrame {
    private JTextPane panelTexto;
    private JButton botonNegrita;
    private JButton botonColorFondo;
    private JButton botonTamanioLetra;
    private JButton botonSubrayado;
    private JButton botonCambiarFormato;





    public EDITOR_TEXTO_AJWP() {
        setTitle("Editor de Texto");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelTexto = new JTextPane();
        botonNegrita = new JButton("Negrita");
        botonColorFondo = new JButton("Color de Fondo");
        botonTamanioLetra = new JButton("Tamaño de Letra");
        botonSubrayado = new JButton("Subrayado");
        botonCambiarFormato = new JButton("Cambiar Formato");


        botonNegrita.addActionListener(new BoldButtonListener());
        botonColorFondo.addActionListener(new BackgroundColorButtonListener());
        botonTamanioLetra.addActionListener(new FontSizeButtonListener());
        botonSubrayado.addActionListener(new UnderlineButtonListener());
        botonCambiarFormato.addActionListener(new ChangeFormatButtonListener());


        JScrollPane scrolTexto = new JScrollPane(panelTexto);

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonNegrita);
        panelBoton.add(botonColorFondo);
        panelBoton.add(botonTamanioLetra);
        panelBoton.add(botonSubrayado);
        panelBoton.add(botonCambiarFormato);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrolTexto, BorderLayout.CENTER);
        getContentPane().add(panelBoton, BorderLayout.SOUTH);
    }

    private class BoldButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int start = panelTexto.getSelectionStart();
            int end = panelTexto.getSelectionEnd();


            StyledDocument doc = panelTexto.getStyledDocument();


            Style style = doc.addStyle("Negrita", null);


            AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
            boolean esNegrita = StyleConstants.isBold(atributos);


            if (esNegrita) {

                StyleConstants.setBold(style, false);
            } else {

                StyleConstants.setBold(style, true);
            }


            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
    private class BackgroundColorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int start = panelTexto.getSelectionStart();
            int end = panelTexto.getSelectionEnd();


            StyledDocument doc = panelTexto.getStyledDocument();

            Style style = doc.addStyle("ColorFondo", null);


            Color color = JColorChooser.showDialog(null, "Seleccione un color", Color.WHITE);


            StyleConstants.setBackground(style, color);


            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
    private class FontSizeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int start = panelTexto.getSelectionStart();
            int end = panelTexto.getSelectionEnd();


            StyledDocument doc = panelTexto.getStyledDocument();


            Style style = doc.addStyle("TamanioLetra", null);

            int tamano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de la letra"));

            StyleConstants.setFontSize(style, tamano);

            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
    private class UnderlineButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int start = panelTexto.getSelectionStart();
            int end = panelTexto.getSelectionEnd();


            StyledDocument doc = panelTexto.getStyledDocument();


            Style style = doc.addStyle("Subrayado", null);


            AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
            boolean esSubrayado = StyleConstants.isUnderline(atributos);


            if (esSubrayado) {

                StyleConstants.setUnderline(style, false);
            } else {

                StyleConstants.setUnderline(style, true);
            }


            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
    private class ChangeFormatButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int start = panelTexto.getSelectionStart();
            int end = panelTexto.getSelectionEnd();


            StyledDocument doc = panelTexto.getStyledDocument();


            Style style = doc.addStyle("Formato", null);


            String[] opcionesFormato = {"Normal", "Cursiva", "Cursiva y Negrita"};
            String formatoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el formato", "Cambiar Formato", JOptionPane.PLAIN_MESSAGE, null, opcionesFormato, opcionesFormato[0]);


            if (formatoSeleccionado != null) {
                if (formatoSeleccionado.equals("Cursiva")) {
                    StyleConstants.setItalic(style, true);
                    StyleConstants.setBold(style, false);
                } else if (formatoSeleccionado.equals("Cursiva y Negrita")) {
                    StyleConstants.setItalic(style, true);
                    StyleConstants.setBold(style, true);
                } else {
                    StyleConstants.setItalic(style, false);
                    StyleConstants.setBold(style, false);
                }


                doc.setCharacterAttributes(start, end - start, style, false);
            }
        }
    }



    public static void main(String[] args) {
        EDITOR_TEXTO_AJWP editor = new EDITOR_TEXTO_AJWP();
        editor.setVisible(true);}}