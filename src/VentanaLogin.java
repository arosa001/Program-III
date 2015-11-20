import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.sql.*;

public class VentanaLogin extends JFrame {
	private BufferedImage image;
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)

	private JButton loginButton;
	private JButton registerButton;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JCTextField userField;
	private JCPasswordField passwordField;

	Connection con = null;
	JLabel u, p1, p2;
	JTextField uf;
	JPasswordField pf1, pf2;

	public VentanaLogin() {

		// LiberaciÃ³n de la ventana por defecto al cerrar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(900, 600);
		pPrincipal = new JPanel();
		JPanel pBotones = new JPanel();
		pPrincipal.setLayout(null);

		userLabel = new JLabel("Usuario");
		userLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		userLabel.setBounds(250, 155, 180, 25);
		getContentPane().add(userLabel);

		userField = new JCTextField();
		userField.setPlaceholder("Introduce el usuario");
		userField.setFont(new Font("Serif", Font.PLAIN, 18));
		userField.setBounds(380, 150, 260, 35);
		getContentPane().add(userField);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		passwordLabel.setBounds(250, 225, 180, 25);
		getContentPane().add(passwordLabel);

		passwordField = new JCPasswordField();
		passwordField.setPlaceholder("Introduce la contraseña");
		passwordField.setFont(new Font("Serif", Font.PLAIN, 18));
		passwordField.setBounds(380, 220, 260, 35);
		getContentPane().add(passwordField);

		loginButton = new JButton("Longin");
		loginButton.setBounds(555, 280, 85, 40);
		loginButton.setFont(new Font("Serif", Font.BOLD, 13));
		getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaMenu();
			}

		});

		registerButton = new JButton("Registrar");
		registerButton.setBounds(400, 280, 100, 40);
		getContentPane().add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaRegistro();
			}

		});

		pPrincipal.setBackground(Color.lightGray);

		getContentPane().add(pPrincipal);
		this.setTitle("Juegos de baloncesto - Prog3");

		try {

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// Cierre de conexión fallido
				System.err.println(e);
			}
		}
	}

	public void ventanaMenu() {
		JFrame ventanaMenu = new JFrame();		
		JLabel l = new JLabel("Has loggeado correctamente");
		JScrollPane misJugadores = new JScrollPane();
		ventanaMenu.add(l);
		misJugadores.setPreferredSize(new Dimension(100,0));
		ventanaMenu.add(misJugadores, BorderLayout.EAST);
		ventanaMenu.setTitle("Menu de Juego");
		ventanaMenu.setSize(900, 600);
		String user = userField.getText();
		char[] p = passwordField.getPassword();
		String pass = new String(p);
		try {
			// Carga el sqlite-JDBC driver usando el cargador de clases
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:baloncesto.db");
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // pone timeout 30 msg

			PreparedStatement ps = con.prepareStatement("select * from usuario where user=? and pass1=? ");
			PreparedStatement ps1 = con.prepareStatement("select * from usuario where user=? ");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps1.setString(1, user);
			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();
			if (user.isEmpty() == true)
				System.out.println("Introduce el usuario");
			else if (pass.isEmpty() == true)
				System.out.println("Introduce la contraseña");
			else {
				if (rs.next()) 
					ventanaMenu.setVisible(true);
				else if (rs1.next())
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta! Intentalo de nuevo");
				else
					JOptionPane.showMessageDialog(null, "No existe el usuario");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// Cierre de conexiÃ³n fallido
				System.err.println(e);
			}
		}

	}

	public void ventanaRegistro() {
		JFrame f1 = new JFrame();

		JButton bRegistrar;

		f1.setVisible(true);
		f1.setSize(900, 600);
		f1.setLayout(null);
		u = new JLabel();
		uf = new JTextField();
		pf1 = new JPasswordField();
		pf2 = new JPasswordField();
		bRegistrar = new JButton("Registrar");
		u = new JLabel("Usuario");
		u.setFont(new Font("Serif", Font.BOLD, 16));

		p1 = new JLabel("Contraseña");
		p1.setFont(new Font("Serif", Font.BOLD, 16));
		p2 = new JLabel("Confirma Contraseña");
		p2.setFont(new Font("Serif", Font.BOLD, 16));
		u.setBounds(200, 150, 210, 30);
		uf.setBounds(450, 150, 200, 30);
		p1.setBounds(200, 200, 210, 30);
		pf1.setBounds(450, 200, 200, 30);
		p2.setBounds(200, 250, 210, 30);
		pf2.setBounds(450, 250, 200, 30);
		bRegistrar.setBounds(550, 300, 100, 30);

		bRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertarDatos();
			}

		});
		f1.add(u);
		f1.add(p1);
		f1.add(uf);
		f1.add(pf1);
		f1.add(p2);
		f1.add(pf2);
		f1.add(bRegistrar);

	}

	public void InsertarDatos() {
		String user = uf.getText();
		char[] pw1 = pf1.getPassword();
		char[] pw2 = pf2.getPassword();
		String pass1 = new String(pw1);
		String pass2 = new String(pw2);

		if (user.isEmpty())
			JOptionPane.showMessageDialog(null, "Introduce el usuario");
		else if (pass1.isEmpty() || pass2.isEmpty())
			JOptionPane.showMessageDialog(null, "Introduce la contraseña");
		else {
			if (!pass1.equals(pass2))
				JOptionPane.showMessageDialog(null, "Los claves introducidos son diferentes! Intentalo de nuevo");
			else {

				try {
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:baloncesto.db");
					Statement statement = con.createStatement();
					statement.setQueryTimeout(30); // pone timeout 30 msg
					statement.executeUpdate("drop table if exists usuario");
					statement.executeUpdate("create table usuario (user string, pass1 string, pass2 string)");
					statement.executeUpdate("insert into usuario values('" + user + "', '" + pass1 + "', '" + pass2 + "')");
					ResultSet rs = statement.executeQuery("select * from usuario");
					while (rs.next()) {
						JOptionPane.showMessageDialog(null, "Registrado exitosamente!");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				} finally {
					try {
						if (con != null)
							con.close();
					} catch (SQLException ex) {
						// Cierre de conexión fallido
						System.err.println(ex);
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		// Crea y visibiliza la ventana con el coche
		VentanaLogin miVentana = new VentanaLogin();
		miVentana.setVisible(true);

	}

}