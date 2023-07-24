/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package ec.edu.ups.practica_05_ssuquilanda_jabad.main;

import ec.edu.ups.practica_05_ssuquilanda_jabad.controlador.ControladorCantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.controlador.ControladorCompositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.dao.CantanteDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.dao.CompositorDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICantanteDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.idao.ICompositorDAO;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cancion.VentanaActualizarCancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cancion.VentanaBuscarCancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cancion.VentanaEliminarCancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cancion.VentanaIngresarCancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cancion.VentanaListarCancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cantante.VentanaActualizarCantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cantante.VentanaBuscarCantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cantante.VentanaBuscarCantantePorDisco;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cantante.VentanaCrearCantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cantante.VentanaEliminarCantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cantante.VentanaListarCantante;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cliente.VentanaAsignarCliente;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cliente.VentanaDesAsignarCliente;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.cliente.VentanaListarCliente;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.compositor.VentanaActualizarCompositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.compositor.VentanaBuscarCompositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.compositor.VentanaBuscarCompositorPorCancion;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.compositor.VentanaCrearCompositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.compositor.VentanaEliminarCompositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.compositor.VentanaListarCompositor;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.disco.VentanaActualizarDisco;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.disco.VentanaBuscarDisco;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.disco.VentanaEliminarDisco;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.disco.VentanaIngresarDisco;
import ec.edu.ups.practica_05_ssuquilanda_jabad.vista.disco.VentanaListarDisco;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samanthasuquilandaquilli
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Ventanas Cantante
    private VentanaCrearCantante ventanaCrearCantante;
    private VentanaBuscarCantante ventanaBuscarCantante;
    private VentanaActualizarCantante ventanaActualizarCantante;
    private VentanaBuscarCantantePorDisco ventanaBuscarCantantePorDisco;
    private VentanaListarCantante ventanaListarCantante;
    private VentanaEliminarCantante ventanaEliminarCantante;
    private VentanaIngresarDisco ventanaIngresarDisco;
    private VentanaBuscarDisco ventanaBuscarDisco;
    private VentanaEliminarDisco ventanaEliminarDisco;
    private VentanaActualizarDisco ventanaActualizarDisco;
    private VentanaListarDisco ventanaListarDisco;
    private VentanaCrearCompositor ventanaCrearCompositor ;
    private VentanaBuscarCompositor  ventanaBuscarCompositor ;
    private VentanaBuscarCompositorPorCancion ventanaBuscarCompositorPorCancion;
    private VentanaActualizarCompositor ventanaActualizarCompositor;
    private VentanaListarCompositor ventanaListarCompositor ;
    private VentanaEliminarCompositor ventanaEliminarCompositor ;
    private VentanaIngresarCancion ventanaIngresarCancion ;
    private VentanaBuscarCancion  ventanaBuscarCancion ;
    private VentanaEliminarCancion ventanaEliminarCancion ;
    private VentanaActualizarCancion ventanaActualizarCancion;
    private VentanaListarCancion ventanaListarCancion;
    private VentanaAsignarCliente  ventanaAsignarCliente ;
    private VentanaDesAsignarCliente ventanaDesAsignarCliente ;
    private VentanaListarCliente ventanaListarCliente;    
    //Internacionalización
    private Locale localizacion;
    private ResourceBundle mensajes;

    //Controladores
    private ControladorCantante controladorCantante;
    private ControladorCompositor controladorCompositor;
    
    //DAO´s
    private ICompositorDAO compositorDAO;
    private ICantanteDAO cantanteDAO;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() throws IOException {
        initComponents();
        compositorDAO = new CompositorDAO();
        cantanteDAO = new CantanteDAO();
        controladorCantante = new ControladorCantante(cantanteDAO);
        controladorCompositor = new ControladorCompositor(compositorDAO);
        //localizacion = Locale.getDefault();                
        localizacion = new Locale("es", "EC");
        cambiarIdioma();
    }
    private void cambiarIdioma(){
        //Menú Generales
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        menuCantante.setText(mensajes.getString("menu.cantante"));
        CompositorMenu.setText(mensajes.getString("menu.compositor"));
        menuOpciones.setText(mensajes.getString("menu.opciones"));
        //Menú Item Cantante
        menuItemCrearCantante.setText(mensajes.getString("menu.itemCrear"));
        menuItemBuscarCantante.setText((mensajes.getString("menu.itemBuscar")));
        menuItemBuscarCantantePorDisco.setText((mensajes.getString("menu.itemBuscarXDisco")));
        menuItemActualizarCantante.setText(mensajes.getString("menu.itemActualizar"));
        menuItemEliminarCantante.setText(mensajes.getString("menu.itemEliminar"));
        menuItemListarCantante.setText(mensajes.getString("menu.itemListar"));
        menuItemIngresarDisco.setText(mensajes.getString("menu.itemIngresarDisco"));
        menuItemBuscarDisco.setText(mensajes.getString("menu.itemBuscarDisco"));
        menuItemActualizarDisco.setText(mensajes.getString("menu.itemActualizarDisco"));
        menuItemEliminarDisco.setText(mensajes.getString("menu.itemEliminarDisco"));
        menuItemListarDisco.setText(mensajes.getString("menu.itemListarDisco"));
        //Menú Item Compositor
        menuItemCrearCompositor.setText(mensajes.getString("menu.itemCrear"));
        menuItemBuscarCompositor.setText(mensajes.getString("menu.itemBuscar"));
        MenuItemBuscarCompositorPorCancion.setText(mensajes.getString("menu.itemBuscarCompositorPorCanción"));
        menuItemActualizarCompositor.setText(mensajes.getString("menu.itemActualizar"));
        menuItemEliminarCompositor.setText(mensajes.getString("menu.itemEliminar"));
        menuItemListarCompositor.setText(mensajes.getString("menu.itemListar"));
        menuItemIngresarCancion.setText(mensajes.getString("menu.itemIngresarCanción"));
        menuItemBuscarCancion.setText(mensajes.getString("menu.itemBuscarCanción"));
        menuItemActualizarCancion.setText(mensajes.getString("menu.itemActualizarCanción"));
        menuItemEliminarCancion.setText(mensajes.getString("menu.itemEliminarCanción"));
        menuItemListarCancion.setText(mensajes.getString("menu.itemListarCanciones"));
        menuItemAsignarCliente.setText(mensajes.getString("menu.itemIngresarCliente"));
        menuItemDesAsignarCliente.setText(mensajes.getString("menu.itemEliminarCliente"));
        menuItemListarCliente.setText(mensajes.getString("menu.itemListarClientes"));
        menuItemSalir.setText(mensajes.getString("menu.itemSalir"));
        if(ventanaCrearCantante != null){
            ventanaCrearCantante.cambiarIdioma(localizacion);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuCantante = new javax.swing.JMenu();
        menuItemCrearCantante = new javax.swing.JMenuItem();
        menuItemBuscarCantante = new javax.swing.JMenuItem();
        menuItemBuscarCantantePorDisco = new javax.swing.JMenuItem();
        menuItemActualizarCantante = new javax.swing.JMenuItem();
        menuItemEliminarCantante = new javax.swing.JMenuItem();
        menuItemListarCantante = new javax.swing.JMenuItem();
        menuItemIngresarDisco = new javax.swing.JMenuItem();
        menuItemBuscarDisco = new javax.swing.JMenuItem();
        menuItemActualizarDisco = new javax.swing.JMenuItem();
        menuItemEliminarDisco = new javax.swing.JMenuItem();
        menuItemListarDisco = new javax.swing.JMenuItem();
        CompositorMenu = new javax.swing.JMenu();
        menuItemCrearCompositor = new javax.swing.JMenuItem();
        menuItemBuscarCompositor = new javax.swing.JMenuItem();
        MenuItemBuscarCompositorPorCancion = new javax.swing.JMenuItem();
        menuItemActualizarCompositor = new javax.swing.JMenuItem();
        menuItemEliminarCompositor = new javax.swing.JMenuItem();
        menuItemListarCompositor = new javax.swing.JMenuItem();
        menuItemIngresarCancion = new javax.swing.JMenuItem();
        menuItemBuscarCancion = new javax.swing.JMenuItem();
        menuItemActualizarCancion = new javax.swing.JMenuItem();
        menuItemEliminarCancion = new javax.swing.JMenuItem();
        menuItemListarCancion = new javax.swing.JMenuItem();
        menuItemAsignarCliente = new javax.swing.JMenuItem();
        menuItemDesAsignarCliente = new javax.swing.JMenuItem();
        menuItemListarCliente = new javax.swing.JMenuItem();
        menuOpciones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuItemEspañol = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCantante.setMnemonic('f');
        menuCantante.setText("Cantante");
        menuCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCantanteActionPerformed(evt);
            }
        });

        menuItemCrearCantante.setMnemonic('o');
        menuItemCrearCantante.setText("Crear");
        menuItemCrearCantante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuItemCrearCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemCrearCantante);

        menuItemBuscarCantante.setMnemonic('a');
        menuItemBuscarCantante.setText("Buscar");
        menuItemBuscarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemBuscarCantante);

        menuItemBuscarCantantePorDisco.setText("Buscar cantante por disco");
        menuItemBuscarCantantePorDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCantantePorDiscoActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemBuscarCantantePorDisco);

        menuItemActualizarCantante.setMnemonic('s');
        menuItemActualizarCantante.setText("Actualizar");
        menuItemActualizarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemActualizarCantante);

        menuItemEliminarCantante.setMnemonic('x');
        menuItemEliminarCantante.setText("Eliminar");
        menuItemEliminarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemEliminarCantante);

        menuItemListarCantante.setText("Listar");
        menuItemListarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemListarCantante);

        menuItemIngresarDisco.setText("Ingresar Disco");
        menuItemIngresarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIngresarDiscoActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemIngresarDisco);

        menuItemBuscarDisco.setText("Buscar Disco");
        menuItemBuscarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarDiscoActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemBuscarDisco);

        menuItemActualizarDisco.setText("Actualizar Disco");
        menuItemActualizarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarDiscoActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemActualizarDisco);

        menuItemEliminarDisco.setText("Eliminar Disco");
        menuItemEliminarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarDiscoActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemEliminarDisco);

        menuItemListarDisco.setText("Listar Disco");
        menuItemListarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarDiscoActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemListarDisco);

        menuBar.add(menuCantante);

        CompositorMenu.setMnemonic('e');
        CompositorMenu.setText("Compositor");
        CompositorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompositorMenuActionPerformed(evt);
            }
        });

        menuItemCrearCompositor.setMnemonic('t');
        menuItemCrearCompositor.setText("Crear");
        menuItemCrearCompositor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuItemCrearCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCompositorActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemCrearCompositor);

        menuItemBuscarCompositor.setMnemonic('p');
        menuItemBuscarCompositor.setText("Buscar");
        menuItemBuscarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCompositorActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemBuscarCompositor);

        MenuItemBuscarCompositorPorCancion.setText("Buscar Compositor Por Cancion");
        MenuItemBuscarCompositorPorCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemBuscarCompositorPorCancionActionPerformed(evt);
            }
        });
        CompositorMenu.add(MenuItemBuscarCompositorPorCancion);

        menuItemActualizarCompositor.setMnemonic('y');
        menuItemActualizarCompositor.setText("Actualizar");
        menuItemActualizarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarCompositorActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemActualizarCompositor);

        menuItemEliminarCompositor.setMnemonic('d');
        menuItemEliminarCompositor.setText("Eliminar");
        menuItemEliminarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarCompositorActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemEliminarCompositor);

        menuItemListarCompositor.setText("Listar");
        menuItemListarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarCompositorActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemListarCompositor);

        menuItemIngresarCancion.setText("Ingresar Cancion");
        menuItemIngresarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIngresarCancionActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemIngresarCancion);

        menuItemBuscarCancion.setText("Buscar Cancion");
        menuItemBuscarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCancionActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemBuscarCancion);

        menuItemActualizarCancion.setText("Actualizar Cancion");
        menuItemActualizarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarCancionActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemActualizarCancion);

        menuItemEliminarCancion.setText("Eliminar Cancion");
        menuItemEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarCancionActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemEliminarCancion);

        menuItemListarCancion.setText("Listar Canciones");
        menuItemListarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarCancionActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemListarCancion);

        menuItemAsignarCliente.setText("Asignar Cliente");
        menuItemAsignarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAsignarClienteActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemAsignarCliente);

        menuItemDesAsignarCliente.setText("Desasignar Cliente");
        menuItemDesAsignarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDesAsignarClienteActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemDesAsignarCliente);

        menuItemListarCliente.setText("Listar Cliente");
        menuItemListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarClienteActionPerformed(evt);
            }
        });
        CompositorMenu.add(menuItemListarCliente);

        menuBar.add(CompositorMenu);

        menuOpciones.setText("Opciones");
        menuOpciones.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuOpcionesMenuSelected(evt);
            }
        });

        jMenuItem2.setText("English ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuOpciones.add(jMenuItem2);

        menuItemEspañol.setText("Español");
        menuItemEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEspañolActionPerformed(evt);
            }
        });
        menuOpciones.add(menuItemEspañol);

        jMenuItem3.setText("Français");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuOpciones.add(jMenuItem3);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuOpciones.add(menuItemSalir);

        menuBar.add(menuOpciones);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemBuscarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCantanteActionPerformed
        if (ventanaBuscarCantante == null) {
            ventanaBuscarCantante = new VentanaBuscarCantante(controladorCantante);
            desktopPane.add(ventanaBuscarCantante);
        }
        ventanaBuscarCantante.cambiarIdioma(localizacion);
        ventanaBuscarCantante.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCantanteActionPerformed

    private void menuItemCrearCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCompositorActionPerformed
        if (ventanaCrearCompositor == null) {
            ventanaCrearCompositor = new VentanaCrearCompositor(controladorCompositor);
            desktopPane.add(ventanaCrearCompositor);
        }
        ventanaCrearCompositor.cambiarIdioma(localizacion);
        ventanaCrearCompositor.setVisible(true);

    }//GEN-LAST:event_menuItemCrearCompositorActionPerformed

    private void menuItemListarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarCompositorActionPerformed
        if (ventanaListarCompositor == null) {
            ventanaListarCompositor = new VentanaListarCompositor(controladorCompositor);
            desktopPane.add(ventanaListarCompositor);
        }
        ventanaListarCompositor.cambiarIdioma(localizacion);
        ventanaListarCompositor.setVisible(true);
    }//GEN-LAST:event_menuItemListarCompositorActionPerformed

    private void menuItemEliminarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarCompositorActionPerformed
        if (ventanaEliminarCompositor == null) {
            ventanaEliminarCompositor = new VentanaEliminarCompositor(controladorCompositor);
            desktopPane.add(ventanaEliminarCompositor);
        }
        ventanaEliminarCompositor.cambiarIdioma(localizacion);
        ventanaEliminarCompositor.setVisible(true);
    }//GEN-LAST:event_menuItemEliminarCompositorActionPerformed

    private void menuOpcionesMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuOpcionesMenuSelected
        // TODO add your handling code here:

    }//GEN-LAST:event_menuOpcionesMenuSelected

    private void menuItemActualizarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarCompositorActionPerformed
        if (ventanaActualizarCompositor == null) {
            ventanaActualizarCompositor = new VentanaActualizarCompositor(controladorCompositor);
            desktopPane.add(ventanaActualizarCompositor);
        }
        ventanaActualizarCompositor.cambiarIdioma(localizacion);
        ventanaActualizarCompositor.setVisible(true);
    }//GEN-LAST:event_menuItemActualizarCompositorActionPerformed

    private void menuItemBuscarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCompositorActionPerformed
        if (ventanaBuscarCompositor == null) {
            ventanaBuscarCompositor = new VentanaBuscarCompositor(controladorCompositor);
            desktopPane.add(ventanaBuscarCompositor);
        }
        ventanaBuscarCompositor.cambiarIdioma(localizacion);
        ventanaBuscarCompositor.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCompositorActionPerformed

    private void menuItemListarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarCantanteActionPerformed
        if (ventanaListarCantante == null) {
            ventanaListarCantante = new VentanaListarCantante(controladorCantante);
            desktopPane.add(ventanaListarCantante);
        }
         ventanaListarCantante.cambiarIdioma(localizacion);
        ventanaListarCantante.setVisible(true);

    }//GEN-LAST:event_menuItemListarCantanteActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemCrearCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCantanteActionPerformed
        if (ventanaCrearCantante == null) {
            ventanaCrearCantante = new VentanaCrearCantante(controladorCantante);
            desktopPane.add(ventanaCrearCantante);
        }
        ventanaCrearCantante.cambiarIdioma(localizacion);
        ventanaCrearCantante.setVisible(true);

    }//GEN-LAST:event_menuItemCrearCantanteActionPerformed

    private void menuItemActualizarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarCantanteActionPerformed
        if (ventanaActualizarCantante == null) {
            ventanaActualizarCantante = new VentanaActualizarCantante(controladorCantante);
            desktopPane.add(ventanaActualizarCantante);
        }
        ventanaActualizarCantante.cambiarIdioma(localizacion);
        ventanaActualizarCantante.setVisible(true);
    }//GEN-LAST:event_menuItemActualizarCantanteActionPerformed

    private void menuItemEliminarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarCantanteActionPerformed
        if (ventanaEliminarCantante == null) {
            ventanaEliminarCantante = new VentanaEliminarCantante(controladorCantante);
            desktopPane.add(ventanaEliminarCantante);
        }
        ventanaEliminarCantante.cambiarIdioma(localizacion);
        ventanaEliminarCantante.setVisible(true);
    }//GEN-LAST:event_menuItemEliminarCantanteActionPerformed

    private void menuCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCantanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCantanteActionPerformed

    private void CompositorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompositorMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompositorMenuActionPerformed

    private void menuItemBuscarCantantePorDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCantantePorDiscoActionPerformed
        if (ventanaBuscarCantantePorDisco == null) {
            ventanaBuscarCantantePorDisco = new VentanaBuscarCantantePorDisco(controladorCantante);
            desktopPane.add(ventanaBuscarCantantePorDisco);
        }
        ventanaBuscarCantantePorDisco.cambiarIdioma(localizacion);
        ventanaBuscarCantantePorDisco.setVisible(true);
        
    }//GEN-LAST:event_menuItemBuscarCantantePorDiscoActionPerformed

    private void menuItemIngresarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIngresarDiscoActionPerformed
        if (ventanaIngresarDisco == null) {
            ventanaIngresarDisco = new VentanaIngresarDisco(controladorCantante);
            desktopPane.add(ventanaIngresarDisco);
        }
        ventanaIngresarDisco.cambiarIdioma(localizacion);
        ventanaIngresarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemIngresarDiscoActionPerformed

    private void menuItemBuscarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarDiscoActionPerformed
        // TODO add your handling code here:
        if (ventanaBuscarDisco == null) {
            ventanaBuscarDisco = new VentanaBuscarDisco(controladorCantante);
            desktopPane.add(ventanaBuscarDisco);
        }
        ventanaBuscarDisco.cambiarIdioma(localizacion);
        ventanaBuscarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarDiscoActionPerformed

    private void menuItemEliminarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarDiscoActionPerformed
        // TODO add your handling code here:
        if (ventanaEliminarDisco == null) {
            ventanaEliminarDisco = new VentanaEliminarDisco(controladorCantante);
            desktopPane.add(ventanaEliminarDisco);
        }
        ventanaEliminarDisco.cambiarIdioma(localizacion);
        ventanaEliminarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemEliminarDiscoActionPerformed

    private void menuItemIngresarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIngresarCancionActionPerformed
        // TODO add your handling code here:
        if (ventanaIngresarCancion == null) {
            ventanaIngresarCancion = new VentanaIngresarCancion(controladorCompositor);
            desktopPane.add(ventanaIngresarCancion);
        }
        ventanaIngresarCancion.cambiarIdioma(localizacion);
        ventanaIngresarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemIngresarCancionActionPerformed

    private void menuItemBuscarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCancionActionPerformed
        // TODO add your handling code here:
        if (ventanaBuscarCancion == null) {
            ventanaBuscarCancion = new VentanaBuscarCancion(controladorCompositor);
            desktopPane.add(ventanaBuscarCancion);
        }
        ventanaBuscarCancion.cambiarIdioma(localizacion);
        ventanaBuscarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCancionActionPerformed

    private void menuItemListarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarCancionActionPerformed
        // TODO add your handling code here:
        if (ventanaListarCancion == null) {
            ventanaListarCancion = new VentanaListarCancion(controladorCompositor);
            desktopPane.add(ventanaListarCancion);
        }
        ventanaListarCancion.cambiarIdioma(localizacion);
        ventanaListarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemListarCancionActionPerformed

    private void menuItemAsignarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAsignarClienteActionPerformed
        // TODO add your handling code here:
        if (ventanaAsignarCliente == null) {
            ventanaAsignarCliente = new VentanaAsignarCliente(controladorCompositor);
            desktopPane.add(ventanaAsignarCliente);
        }
        ventanaAsignarCliente.cambiarIdioma(localizacion);
        ventanaAsignarCliente.setVisible(true);
    }//GEN-LAST:event_menuItemAsignarClienteActionPerformed

    private void menuItemListarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarDiscoActionPerformed
        // TODO add your handling code here:
        if (ventanaListarDisco == null) {
            ventanaListarDisco = new VentanaListarDisco(controladorCantante);
            desktopPane.add(ventanaListarDisco);
        }
        ventanaListarDisco.cambiarIdioma(localizacion);
        ventanaListarDisco.setVisible(true);
        
    }//GEN-LAST:event_menuItemListarDiscoActionPerformed

    private void menuItemListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarClienteActionPerformed
        // TODO add your handling code here:
        if (ventanaListarCliente == null) {
            ventanaListarCliente = new VentanaListarCliente(controladorCompositor);
            desktopPane.add(ventanaListarCliente);
        }
        ventanaListarCliente.cambiarIdioma(localizacion);
        ventanaListarCliente.setVisible(true);
    }//GEN-LAST:event_menuItemListarClienteActionPerformed

    private void menuItemActualizarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarCancionActionPerformed
        // TODO add your handling code here:
        if (ventanaActualizarCancion == null) {
            ventanaActualizarCancion = new VentanaActualizarCancion(controladorCompositor);
            desktopPane.add(ventanaActualizarCancion);
        }
        ventanaActualizarCancion.cambiarIdioma(localizacion);
        ventanaActualizarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemActualizarCancionActionPerformed

    private void menuItemEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarCancionActionPerformed
        // TODO add your handling code here:
        if (ventanaEliminarCancion == null) {
            ventanaEliminarCancion = new VentanaEliminarCancion(controladorCompositor);
            desktopPane.add(ventanaEliminarCancion);
        }
        ventanaEliminarCancion.cambiarIdioma(localizacion);
        ventanaEliminarCancion.setVisible(true);
        
    }//GEN-LAST:event_menuItemEliminarCancionActionPerformed

    private void menuItemDesAsignarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDesAsignarClienteActionPerformed
        // TODO add your handling code here:
        if (ventanaDesAsignarCliente == null) {
            ventanaDesAsignarCliente = new VentanaDesAsignarCliente(controladorCompositor);
            desktopPane.add(ventanaDesAsignarCliente);
        }
        ventanaDesAsignarCliente.cambiarIdioma(localizacion);
        ventanaDesAsignarCliente.setVisible(true);
    }//GEN-LAST:event_menuItemDesAsignarClienteActionPerformed

    private void menuItemActualizarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarDiscoActionPerformed
        // TODO add your handling code here:
        if (ventanaActualizarDisco == null) {
            ventanaActualizarDisco = new VentanaActualizarDisco(controladorCantante);
            desktopPane.add(ventanaActualizarDisco);
        }
        ventanaActualizarDisco.cambiarIdioma(localizacion);
        ventanaActualizarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemActualizarDiscoActionPerformed

    private void MenuItemBuscarCompositorPorCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemBuscarCompositorPorCancionActionPerformed
        // TODO add your handling code here:
        if (ventanaBuscarCompositorPorCancion == null) {
            ventanaBuscarCompositorPorCancion = new VentanaBuscarCompositorPorCancion(controladorCompositor);
            desktopPane.add(ventanaBuscarCompositorPorCancion);
        }
        ventanaBuscarCompositorPorCancion.cambiarIdioma(localizacion);
        ventanaBuscarCompositorPorCancion.setVisible(true);
    }//GEN-LAST:event_MenuItemBuscarCompositorPorCancionActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        localizacion = new Locale("en", "US");
        cambiarIdioma();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEspañolActionPerformed
        localizacion = new Locale("es", "EC");
        cambiarIdioma();
    }//GEN-LAST:event_menuItemEspañolActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        localizacion = new Locale("fr", "FR");
        cambiarIdioma();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaPrincipal().setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu CompositorMenu;
    private javax.swing.JMenuItem MenuItemBuscarCompositorPorCancion;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCantante;
    private javax.swing.JMenuItem menuItemActualizarCancion;
    private javax.swing.JMenuItem menuItemActualizarCantante;
    private javax.swing.JMenuItem menuItemActualizarCompositor;
    private javax.swing.JMenuItem menuItemActualizarDisco;
    private javax.swing.JMenuItem menuItemAsignarCliente;
    private javax.swing.JMenuItem menuItemBuscarCancion;
    private javax.swing.JMenuItem menuItemBuscarCantante;
    private javax.swing.JMenuItem menuItemBuscarCantantePorDisco;
    private javax.swing.JMenuItem menuItemBuscarCompositor;
    private javax.swing.JMenuItem menuItemBuscarDisco;
    private javax.swing.JMenuItem menuItemCrearCantante;
    private javax.swing.JMenuItem menuItemCrearCompositor;
    private javax.swing.JMenuItem menuItemDesAsignarCliente;
    private javax.swing.JMenuItem menuItemEliminarCancion;
    private javax.swing.JMenuItem menuItemEliminarCantante;
    private javax.swing.JMenuItem menuItemEliminarCompositor;
    private javax.swing.JMenuItem menuItemEliminarDisco;
    private javax.swing.JMenuItem menuItemEspañol;
    private javax.swing.JMenuItem menuItemIngresarCancion;
    private javax.swing.JMenuItem menuItemIngresarDisco;
    private javax.swing.JMenuItem menuItemListarCancion;
    private javax.swing.JMenuItem menuItemListarCantante;
    private javax.swing.JMenuItem menuItemListarCliente;
    private javax.swing.JMenuItem menuItemListarCompositor;
    private javax.swing.JMenuItem menuItemListarDisco;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenu menuOpciones;
    // End of variables declaration//GEN-END:variables

}
