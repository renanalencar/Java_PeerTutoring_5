import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplicacaoTesouroDireto extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField campo_juros, campo_anos, campo_deposito;
    private JLabel lb_juros, lb_anos, lb_deposito, lb_total, lb_resultado;
    private JButton ok;

    public AplicacaoTesouroDireto() {
        super("Meu Tesouro Direto");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2));
        this.getContentPane().add(painel);
        lb_juros = new JLabel("Juros ao mês %:");
        campo_juros = new JTextField(15);
        painel.add(lb_juros);
        painel.add(campo_juros);
        lb_anos = new JLabel("Num. de anos:");
        campo_anos = new JTextField(15);
        painel.add(lb_anos);
        painel.add(campo_anos);
        lb_deposito = new JLabel("Depósito mensal R$:");
        campo_deposito = new JTextField(15);
        painel.add(lb_deposito);
        painel.add(campo_deposito);
        lb_total = new JLabel("Total investido R$:");
        painel.add(lb_total);
        lb_resultado = new JLabel("");
        painel.add(lb_resultado);
        painel.add(new JLabel());
        ok = new JButton("OK");

        ok.addActionListener(this);
        painel.add(ok);
    }

    /**
     * Método que implementa as ações do botão
     * 
     * @param evt
     * @return
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == ok) {
            double juros = Double.parseDouble(campo_juros.getText());
            int anos = Integer.parseInt(campo_anos.getText());
            double deposito = Double.parseDouble(campo_deposito.getText());
            TesouroDireto tesouro = new TesouroDireto(anos, juros, deposito);
            double resultado = tesouro.calculaTotal();
            lb_resultado.setText(String.valueOf(resultado));
        }
    }

    public static void main(String args[]) {
        AplicacaoTesouroDireto janela = new AplicacaoTesouroDireto();
        janela.pack();
        janela.setVisible(true);
    }
}