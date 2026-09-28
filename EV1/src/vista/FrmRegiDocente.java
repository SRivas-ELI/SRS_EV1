package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Docente;
import model.DocenteModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegiDocente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombres;
	private JTextField txtDni;
	private JTextField txtEstado;
	private JTextField txtApellidos;
	private JTextField txtFNaci;
	private JTextField txtFIngre;
	private JTextField txtDireccion;
	private JButton btnRegis;
	private JButton btnClean;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegiDocente frame = new FrmRegiDocente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegiDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Docente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel.setBounds(10, 11, 414, 40);
		contentPane.add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(110, 62, 150, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(10, 65, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		txtDni = new JTextField();
		txtDni.setBounds(338, 62, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setBounds(282, 65, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(338, 93, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Estado:");
		lblNewLabel_3.setBounds(282, 96, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(110, 93, 150, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblNewLabel_4 = new JLabel("Apellidos:");
		lblNewLabel_4.setBounds(10, 96, 80, 14);
		contentPane.add(lblNewLabel_4);
		
		txtFNaci = new JTextField();
		txtFNaci.setBounds(110, 124, 86, 20);
		contentPane.add(txtFNaci);
		txtFNaci.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha Nacimiento:");
		lblNewLabel_5.setBounds(10, 127, 96, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Fecha Ingreso:");
		lblNewLabel_5_1.setBounds(206, 127, 96, 14);
		contentPane.add(lblNewLabel_5_1);
		
		txtFIngre = new JTextField();
		txtFIngre.setColumns(10);
		txtFIngre.setBounds(314, 124, 110, 20);
		contentPane.add(txtFIngre);
		
		JLabel lblNewLabel_6 = new JLabel("(YY/MM/DD)");
		lblNewLabel_6.setBounds(10, 146, 80, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("(YY/MM/DD)");
		lblNewLabel_6_1.setBounds(206, 146, 80, 14);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7 = new JLabel("Direccion:");
		lblNewLabel_7.setBounds(10, 171, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(110, 168, 150, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		btnRegis = new JButton("Registrar");
		btnRegis.addActionListener(this);
		btnRegis.setBounds(50, 215, 89, 23);
		contentPane.add(btnRegis);
		
		btnClean = new JButton("Limpiar");
		btnClean.addActionListener(this);
		btnClean.setBounds(295, 215, 89, 23);
		contentPane.add(btnClean);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClean) {
			do_btnClean_actionPerformed(e);
		}
		if (e.getSource() == btnRegis) {
			do_btnRegis_actionPerformed(e);
		}
	}
	protected void do_btnRegis_actionPerformed(ActionEvent e) {
		String vNom, vApe, vFI, vFN, vDir, vDni;
		int vEst;
		
		vNom = txtNombres.getText().trim();
		vApe = txtApellidos.getText().trim();
		vFI = txtFIngre.getText().trim();
		vFN = txtFNaci.getText().trim();
		vDir = txtDireccion.getText().trim();
		vDni = txtDni.getText().trim();
		vEst = Integer.parseInt(txtEstado.getText().trim());
		
		Docente objdocente = new Docente();
		objdocente.setNombres(vNom);
		objdocente.setApellidos(vApe);
		objdocente.setDni(vDni);
		objdocente.setEstado(vEst);
		objdocente.setFechaIngreso(vFI);
		objdocente.setFechaIngreso(vFN);
		objdocente.setDireccion(vDir);
		
		DocenteModel objDocModel = new DocenteModel();
		int insertados = objDocModel.insertaDocente(objdocente);
		
		if (insertados > 0) {
			JOptionPane.showMessageDialog(this, "Docente registrado correctamente.");
		}
	}
	protected void do_btnClean_actionPerformed(ActionEvent e) {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText(getName());
		txtFNaci.setText("");
		txtFIngre.setText("");
		txtEstado.setText("");
		txtDireccion.setText("");
	}
}
