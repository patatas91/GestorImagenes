package examenes;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * 
 * AUTOR: CRISTIAN SIMON MORENO
 * 
 */
public class GestorImagenes {
	
	private static Vector<ImageIcon> v;

	/**
	 * Muestra por pantalla el menu del programa
	 */
	private static void mostrarMenu() {
		System.out.println("AVAILABLE ORDERS");
		System.out.println("================");
		System.out
				.println("HELP          - shows information on " +
						"available orders");
		System.out
				.println("DIR           - displays the content " +
						"of current directory");
		System.out
		        .println("DIRGALL       - displays the content" +
				        " of current directory");
        System.out
		        .println("                and all its internal" +
				        " subdirectories");        		
		System.out
				.println("CD dir        - changes the current " +
						"directory to its subdirectory [dir]");
		System.out
				.println("CD ..         - changes the current " +
						"directory to its father directory");
		System.out
				.println("WHERE         - shows the path and name " +
						"of current directory");
		System.out
				.println("FIND text     - shows all the images " +
						"whose name includes [text]");
		System.out
				.println("DEL text      - information and delete " +
						"a picture named [text] of current " +
						"directory");
		System.out
				.println("MOVE text     - move an image named " +
						"[text] to another directory");
		System.out
				.println("IMG time      - displays a carousel " +
						"with the images in current directory;");
		System.out
				.println("                each image is displayed" +
						" [time] seconds");
		System.out
				.println("IMGALL time   - displays a carousel with" +
						" the images in current directory;");
		System.out
				.println("                and in all its internal" +
						" subdirectories; each image is");
		System.out.println("                displayed [time] " +
				"seconds");
		System.out.println("BIGIMG        - displays the bigest image int the current" +
				"directory");
		System.out.println("END           - ends of program " +
				"execution");
	}// Fin mostrarMenu
	

	/**
	 * Devuelve [cierto] si [ruta] es un directorio
	 * 
	 * @param ruta
	 * @return boolean
	 */
	private static boolean esDirectorio(String ruta) {
		boolean b = false;
		File f = new File(ruta);
		if (f.isDirectory()) {
			b = true;
		}
		return b;
	}// Fin esDirectorio
	

	/**
	 * Muestra por pantalla el contenido del directorio [directorio]
	 * 
	 * @param directorio
	 */
	private static void listarDirectorio(String directorio) {
		File f = new File(directorio);
		File[] ficheros = f.listFiles();
		System.out.printf("CURRENT DIRECTORY: %s%n", directorio);
		for (int i = 0; i < ficheros.length; i++) {
			// es fichero
			if (ficheros[i].isFile()) {
				System.out.printf("-- FILE %s%n", 
						ficheros[i].getName());
			}
		}
		for (int i = 0; i < ficheros.length; i++) {
			// es directorio
			if (ficheros[i].isDirectory()) {
				System.out.printf("-- DIR %s%n", 
						ficheros[i].getName());
			}
		}
	}// Fin listarDirectorio
	
	private static boolean hayGrafico (File[] ficheros) {
		boolean hay = false;
	
		for(int indice=0;indice<ficheros.length-1;indice++){
			if(practica6.Prueba1.
					esFicheroGrafico(ficheros[indice])){
				hay = true;
			}
			else{ hay = false;}
		}
		return hay;
	}
	
	private static void sacarGrande(File[] ficheros, String ruta, long tamaño) {
		if (hayGrafico(ficheros)){
		for(int indice=0;indice<ficheros.length-1;indice++){
			if (practica6.Prueba1.
					esFicheroGrafico(ficheros[indice])) {
				
				if (ficheros[indice].length()>tamaño) {
					tamaño = ficheros[indice].length();
					ruta = ficheros[indice].getPath();
				}
			}
		}
		System.out.printf("Imagen: %s [%d]%n", ruta, tamaño);
		JFrame ventana = new JFrame ();
           /*
            * Ubica la ventana en la pantalla, situando su extremo superior izquierdo
            * a 40 pixeles de los límites superior y lateral izquierdo de la pantalla
            */
           ventana.setLocation(40,40);
           /*
            * Habilita que al producirse el cierre de la ventana, ésta  se oculte y 
            * se libere el objeto que la gestiona
            */
           ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           ImageIcon img = new ImageIcon(ruta);
		practica6.Prueba1.mostrarImagen(ventana, img);
		
		}
		else{
			System.out.printf("No hay imagenes en el directorio %s%n", ruta);
		}
		
		/*
		if (indice <= ficheros.length - 1) {
			if (practica6.Prueba1.
					esFicheroGrafico(ficheros[indice])) {				
				if (ficheros[indice].length()>tamaño) {
					tamaño = ficheros[indice].length();
					ruta = ficheros[indice].getPath();
					System.out.printf("Imagen: %s [%d]%n", ruta, tamaño);
					JFrame ventana = new JFrame ();
			           /*
			            * Ubica la ventana en la pantalla, situando su extremo superior izquierdo
			            * a 40 pixeles de los límites superior y lateral izquierdo de la pantalla
			            *
			           ventana.setLocation(40,40);
			           /*
			            * Habilita que al producirse el cierre de la ventana, ésta  se oculte y 
			            * se libere el objeto que la gestiona
			            *
			           ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			           ImageIcon img = new ImageIcon(ficheros[indice].
								getPath().toLowerCase());
					practica6.Prueba1.mostrarImagen(ventana, img);
					cuenta ++;
				}
				indice++;
				sacarGrande(ficheros, indice, ruta, tamaño, cuenta);
			} else {
				indice++;
				sacarGrande(ficheros, indice, ruta, tamaño, cuenta);
			}
		}
		//System.out.printf("Imagen: %s [%d]%n", ruta, tamaño);
		//mostrar(ruta);
		return cuenta;
		*/
	}// Fin recorrerFicheros
	
	/**
	 * Muestra por pantalla el contenido del directorio [directorio],
	 * y del contenido de los directorios que hay en el.
	 * 
	 * @param directorio
	 */
	private static void listarDirectorio2(String directorio) {
		File f = new File(directorio);
		File[] ficheros = f.listFiles();
		System.out.printf("DIRECTORY: %s%n", directorio);
		for (int i = 0; i < ficheros.length; i++) {
			// es fichero
			if (ficheros[i].isFile()) {
				System.out.printf("-- FILE %s%n", 
						ficheros[i].getName());
			}
		}
		for (int i = 0; i < ficheros.length; i++) {
			// es directorio
			if (ficheros[i].isDirectory()) {
				System.out.printf("-- DIR %s%n", 
						ficheros[i].getName());
				//System.out.println("");
				//listarDirectorio2(ficheros[i].getPath());
			}
		}
		for (int i = 0; i < ficheros.length; i++) {
			// explora nuevos directorios
			if (ficheros[i].isDirectory()) {				
				System.out.println("");
				listarDirectorio2(ficheros[i].getPath());
			}
		}
	}// Fin listarDirectorio
	
	

	/**
	 * Dada una lista de ficheros [ficheros] y un String [texto], si 
	 * hay algun fichero cuyo nombre tenga alguna coincidencia con 
	 * [texto] lo agrega a un vector
	 * 
	 * @param ficheros
	 * @param indice
	 * @param texto
	 */
	private static void recorrerFicheros(File[] ficheros, int indice,
			String texto) {
		if (indice <= ficheros.length - 1) {
			if (practica6.Prueba1.
					esFicheroGrafico(ficheros[indice])) {
				ImageIcon img = new ImageIcon(ficheros[indice].
						getPath().toLowerCase());
				// comprueba si tiene alguna coincidencia
				if (ficheros[indice].getName().
						indexOf(texto) != -1) {
					System.out.printf("%s%n", ficheros[indice].
							getPath());
					// lo agrega al vector
					v.add(img);
				}
				indice++;
				recorrerFicheros(ficheros, indice, texto);
			} else {
				indice++;
				recorrerFicheros(ficheros, indice, texto);
			}
		}
	}// Fin recorrerFicheros
	

	/**
	 * Dada una lista de ficheros [ficheros] y un String [texto], 
	 * si hay algun directorio lo recorre recursivamente
	 * 
	 * @param ficheros
	 * @param indice
	 * @param texto
	 */
	private static void recorrerDirectorios(File[] ficheros, 
			int indice, String texto) {
		if (indice <= ficheros.length - 1) {
			if (ficheros[indice].isDirectory()) {
				// si es directorio
				File nuevo = new File(ficheros[indice].getPath());
				File[] tabla = nuevo.listFiles();
				recorrerFicheros(tabla, 0, texto);
				recorrerDirectorios(tabla, 0, texto);
				indice++;
				recorrerDirectorios(ficheros, indice, texto);
			} else {
				indice++;
				recorrerDirectorios(ficheros, indice, texto);
			}
		}
	}// Fin recorrerDirectorios
	
	
	/**
	 * Dada una lista de ficheros [ficheros] y un String [texto], 
	 * si hay algun fichero cuyo nombre es igual a [texto] devuelve 
	 * la ruta completa de este fichero
	 * 
	 * @param ficheros
	 * @param indice
	 * @param texto
	 * @return String nombre del fichero
	 */
	private static String sacarRuta(File[] ficheros, int indice, 
			String texto) {
		String nombre = null;
		if (indice <= ficheros.length - 1) {
			if (practica6.Prueba1.
					esFicheroGrafico(ficheros[indice])) {
				if (ficheros[indice].getName().
						equalsIgnoreCase(texto)) {
					return ficheros[indice].getPath();
				} else {
					indice++;
					return sacarRuta(ficheros, indice, texto);
				}
			}
		}
		return nombre;
	}// Fin sacarRuta
	

	/**
	 * Muestra en una serie de ventanas el contenido del vector [v]
	 * 
	 * @param v
	 */
	private static void mostrarVector(Vector<ImageIcon> v) {
		// crea el conjunto de ventanas
		JFrame[] tablaWindows = new JFrame[v.size()];
		for (int i = 0; i < v.size(); ++i) {
			tablaWindows[i] = new JFrame();
			tablaWindows[i].setLocation(30, 30);
			tablaWindows[i].setDefaultCloseOperation(JFrame.
					DISPOSE_ON_CLOSE);
			practica6.Prueba1.mostrarImagen(tablaWindows[i], 
					v.get(i));
		}
	}// Fin mostrarVector
	
	
	/**
	 * Dado una imagen [imagen] devuelve un String con la fecha y
	 * hora de la ultima modificacion de dicha imagen
	 */
	private static String fechaMod(File imagen) {
		long tiempo = imagen.lastModified();
		Date d = new Date(tiempo);
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String anyo = Integer.toString(c.get(Calendar.YEAR));
		String hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
		String minuto = Integer.toString(c.get(Calendar.MINUTE));
		String segundo = Integer.toString(c.get(Calendar.SECOND));
		return  hora+":"+minuto+":"+segundo+" - "+ dia+"/"+mes+"/"+
		anyo;
	}// Fin fechaMod
	

	/**
	 * Muestra por pantalla la informacion relativa a la ruta, nombre 
	 * y tamaño en bytes de una imagen [imagen]
	 * 
	 * @param imagen
	 */
	private static void informacionImagen(File imagen) {		
		System.out.println("Information of the selected image:");
		System.out.printf("- Directory Name: %s%n", 
				imagen.getParent());
		System.out.printf("- Name: %s%n", imagen.getName());
		System.out.printf("- Last modified: %s%n", fechaMod(imagen));
		System.out.printf("- Size: %s bytes%n", imagen.length());
		System.out.println("");
	}// Fin informacionImagen
	

	/**
	 * Dado un String [nombre] y un String [directorio], mueve 
	 * [nombre] al directorio [directorio]
	 * 
	 * @param nombre
	 * @param directorio
	 */
	private static void mover(String nombre, String directorio) {
		File archivo = new File(nombre);
		File dir = new File(directorio);
		boolean correcto = archivo.renameTo(new File(dir, 
				archivo.getName()));
		if (!correcto) {
			System.out.println("--> El fichero no se ha podido " +
					"mover");
		}
	}// Fin mover
	

	/**
	 * Dada una ruta [ruta], define el directorio base sobre el cual 
	 * se va a trabajar y muestra el menu
	 * 
	 * @param ruta
	 */
	private static void gestorMenu(String ruta) {		
		File f = new File (ruta);
		// establece el directorio padre
		String base = f.getPath();
		ruta = f.getPath();
		// Presenta por pantalla el menu del programa
		mostrarMenu();
		// Inicia el tiempo
		long tiempoInicial = System.currentTimeMillis();
		Menu(ruta, base, tiempoInicial, 0);
	}// Fin gestorMenu
	

	/**
	 * Pre: Muestra en pantalla un menu que permite trabajar con unos 
	 *     ficheros
	 * Post: El operador puede elegir entre varias opciones. En caso 
	 *      de que la respuesta sea incorrecta, el programa informa 
	 *      del error y vuelve a mostrar el menu.
	 *      
	 * @param ruta
	 * @param base
	 * @param tiempoInicial
	 * @param tiempoActual
	 */
	@SuppressWarnings("deprecation")
	private static void Menu(String ruta, String base, 
			long tiempoInicial, long tiempoActual) {
		Locale.setDefault(Locale.UK);
		DecimalFormat df = new DecimalFormat("00");		
		try {
			if (esDirectorio(ruta)) {
				// Lee la orden introducida por el operador
				System.out.println("");
				tiempoActual = System.currentTimeMillis();
				Date t = new Date(tiempoActual - tiempoInicial);
				String PROMPT = df.format(t.getMinutes()) + ":"
						+ df.format(t.getSeconds()) + "> ";
				System.out.printf("%s", PROMPT);
				Scanner entrada = new Scanner(System.in);
				Scanner orden = new Scanner(entrada.nextLine());
				String codigo = orden.next();				
				
				// Procesa ordenes hasta que el operador escribe la 
				//orden END
				while (!codigo.equalsIgnoreCase("END")) {
					// Identifica la orden y la ejecuta
					
					if (codigo.equalsIgnoreCase("HELP")) {
						/*
						 * Muestra por pantalla el menu
						 */
						if (!orden.hasNext()) {
							System.out.println("");
							mostrarMenu();
						}
						else {
							System.out
									.println("--> Incorrect " +
											"order. You can write" +
											" HELP");
						}
					}// Fin Help

					else if (codigo.equalsIgnoreCase("DIR")) {
						/*
						 * Lista por pantalla el contenido del 
						 * directorio actual
						 */
						if (!orden.hasNext()) {							
							listarDirectorio(ruta);
						}
						else {
							System.out
									.println("--> Incorrect " +
											"order. You can write " +
											"HELP");
						}						
					}// Fin DIR
					
					else if (codigo.equalsIgnoreCase("DIRALL")) {
						/*
						 * Lista por pantalla el contenido del 
						 * directorio actual con todos los subdirectorios
						 */
						if (!orden.hasNext()) {							
							listarDirectorio2(ruta);
						}
						else {
							System.out
									.println("--> Incorrect " +
											"order. You can write " +
											"HELP");
						}						
					}// Fin DIR

					else if (codigo.equalsIgnoreCase("CD")) {
						/*
						 * Cambia de directorio
						 */
						if (orden.hasNext()) {
							String texto = orden.next();
							if (texto.equalsIgnoreCase("..")) {
								// comprueba que no es el directorio 
								// base
								if (!ruta.equalsIgnoreCase(base)) {									
									File f = new File(ruta);
									Menu(f.getParent(), base, 
											tiempoInicial, 
											tiempoActual);
								} else {
									System.out
											.println("--> Name of " +
													"directory " +
													"unknown");
								}
							} else {
								// cambio de directorio
								if (esDirectorio(texto)) {
									if(!texto.
											equalsIgnoreCase(ruta)) {
										Menu(texto, base, 
												tiempoInicial, 
												tiempoActual);
									}
									else {
										// el usuario ya esta en ese 
										// directorio
										System.out.println("--> " +
												"You are already " +
												"in that directory");
									}
								} else {
									System.out
											.println("--> Name of " +
													"directory " +
													"unknown");
								}
							}
						} else {
							System.out
									.println("--> Incorrect order." +
											" You can write HELP");							
						}
					}// Fin CD

					else if (codigo.equalsIgnoreCase("WHERE")) {
						/*
						 * Muestra por pantalla la ruta del 
						 * directorio actual
						 */
						if (!orden.hasNext()) {							
							System.out.printf("%s%n", ruta);
						}
						else {
							System.out
									.println("--> Incorrect order." +
											" You can write HELP");
						}											
					}// Fin WHERE

					else if (codigo.equalsIgnoreCase("FIND")) {
						/*
						 * Muestra por pantalla las imagenes cuyo 
						 * nombre coincida con una cadena de 
						 * caracteres determinada
						 */
						if (orden.hasNext()) {
							String texto = 
								(String) orden.next().toLowerCase();
							// crea el vector
							v = new Vector<ImageIcon>();
							File f = new File(ruta);
							File[] ficheros = f.listFiles();
							recorrerFicheros(ficheros, 0, texto);
							recorrerDirectorios(ficheros, 0, texto);
							mostrarVector(v);
							// si no ha encontrado imagenes
							if (v.size() == 0) {
								System.out.println("0 images found");
								
							} else {
								System.out
										.printf("%d images found%n", 
												v.size());
							}
							// vacia el vector
							v.clear();
						} else {
							System.out
									.println("--> Incorrect order." +
											" You can write HELP");							
						}
					}// Fin FIND

					else if (codigo.equalsIgnoreCase("DEL")) {
						/*
						 * Muestra la informacion de una imagen 
						 * determinada del directorio actual y ofrece 
						 * la posibilidad de eliminarla
						 */
						if (orden.hasNext()) {
							String texto = (String) orden.next();
							File f = new File(ruta);
							File[] ficheros = f.listFiles();
							String nombre = sacarRuta(ficheros, 0, 
									texto);
							if (nombre == null) {
								System.out.println("0 images found");
								
							} else {
								File fich = new File(nombre);
								// muestra la informacion de la 
								// imagen
								informacionImagen(fich);
								Scanner s = new Scanner(System.in);
								System.out
										.printf("Do you want to " +
												"delete the " +
												"selected image? " +
												"(Y/N): ");
								String respuesta = s.next();								
								if (respuesta.
										equalsIgnoreCase("y")) {
									fich.delete();
									System.out.println("Image " +
											"deleted");
								} else if (respuesta.
										equalsIgnoreCase("n")) {
								} else {
									System.out.println("--> " +
											"Incorrect order, " +
											"please Y/N");
								}
							}
						} else {
							System.out.println("--> Incorrect " +
									"order. You can write HELP");							
						}
					}// Fin DEL

					else if (codigo.equalsIgnoreCase("MOVE")) {
						/*
						 * Mueve una imagen determinada a otro 
						 * directorio
						 */
						if (orden.hasNext()) {							
							String texto = (String) orden.next();
							File f = new File(ruta);
							File[] ficheros = f.listFiles();
							String nombre = sacarRuta(ficheros, 0, 
									texto);
							//no se ha encontrado la imagen
							if (nombre == null) {
								System.out.println("0 images found");
								
							} else {
								Scanner s = new Scanner(System.in);
								System.out
										.printf("Where do you want" +
												" to move the " +
												"file?: ");
								String directorio = s.next();								
								File fil = new File(directorio);
								if (fil.isDirectory()) {
									mover(nombre, directorio);
									System.out
									.println("Image moved");
								} else {
									System.out
											.println("--> Name of " +
													"directory " +
													"unknown");
								}
							}
						}
					}// Fin MOVE

					else if (codigo.equalsIgnoreCase("IMG")) {
						/*
						 * Muestra por pantalla todas todas las 
						 * imagenes del directorio actual sin entrar
						 * en subdirectorios
						 */						
						if (orden.hasNext()) {							
							if (orden.hasNextDouble()) {
								Double tiempo = orden.nextDouble();
								File f = new File(ruta);
								practica6.Trabajo1.carrusel(f, 
										tiempo);
							} else {
								System.out
										.println("--> Incorrect " +
												"order. You can " +
												"write HELP");								
							}
						} else {
							File f = new File(ruta);
							practica6.Trabajo1.carrusel(f, 2);
						}
					}// Fin IMG

					else if (codigo.equalsIgnoreCase("IMGALL")) {
						/*
						 * Muestra por pantalla todas todas las 
						 * imagenes del directorio actual entrando 
						 * en subdirectorios
						 */						
						if (orden.hasNext()) {
							if (orden.hasNextDouble()) {
								Double tiempo = orden.nextDouble();
								File f = new File(ruta);
								practica6.Trabajo2.carruselTodas(f, 
										tiempo);
							} else {
								System.out
										.println("--> Incorrect " +
												"order. You can " +
												"write HELP");								
							}
						} else {
							File f = new File(ruta);
							practica6.Trabajo2.carruselTodas(f, 1);
						}
					}// Fin IMGALL
					
					else if (codigo.equalsIgnoreCase("BIGIMG")) {
						if (!orden.hasNext()) {		
							
							File f = new File(ruta);
							File[] ficheros = f.listFiles();							
							sacarGrande(ficheros,"",0);						
								
						} else {
							System.out.println("--> Incorrect order."
									+ " You can write HELP");
						}
					}// Fin BIGIMG

					else {
						// Orden desconocida
						System.out
								.println("--> Incorrect order. You" +
										" can write HELP");						
					}
					
					// Pide al operador una nueva orden y la lee					
					tiempoActual = System.currentTimeMillis();
					t = new Date(tiempoActual - tiempoInicial);
					PROMPT = df.format(t.getMinutes()) + ":"
							+ df.format(t.getSeconds()) + "> ";
					System.out.printf("%n%s", PROMPT);
					entrada = new Scanner(System.in);
					orden = new Scanner(entrada.nextLine());
					codigo = orden.next();				
				}// Fin while
				
                // la orden del operador ha sido END
				System.out.println("");
				tiempoActual = System.currentTimeMillis();
				t = new Date(tiempoActual - tiempoInicial);
				String ff = "End of the program execution. " +
						"Running rime "
						+ df.format(t.getMinutes()) + " min and "
						+ df.format(t.getSeconds()) + "sec.";
				System.out.println(ff);
				System.exit(0);
			}
		} catch (Exception e) {
			System.err.println("*** Error.");
		}
	}// Fin Menu

	
	public static void main(String[] args) {
		if (args.length > 0) {
			// comprueba que el directorio es correcto
			if (esDirectorio(args[0])) {
				gestorMenu(args[0]);
			} else {
				System.out.printf("*** Error. El nombre [%s] no "
						+ "corresponde a un directorio", args[0]);
			}
		} else {
			// no se ha especificado directorio
			System.out.println("*** Error. Se ha omitido el nombre" +
					" del directorio de trabajo");
		}
	}// Fin main
	

}// Fin GestorImagenes
