import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicacionTerminal
{
    private Agenda agenda;
    public AplicacionTerminal()
    {
        agenda = new Agenda();
    }

    public void demo()
    {
        Contacto c1 = new Contacto("Braulio", "UASLP", 4442222707L);
        Contacto c2 = new Contacto("Roberto", "UASLP", 4445552707L);
        Contacto c3 = new Contacto("Fernando", "UASLP", 4446662707L);
//        Agenda agenda = new Agenda();
        this.agenda.agregaContacto(c1);
        this.agenda.agregaContacto(c2);
        this.agenda.agregaContacto(c3);
        this.agenda.imprimeTodo();
    }
    public void entradaUsuario()
    {
        Scanner entrada = new Scanner(System.in);
        String opcion = "";
        do
        {
            try{
                System.out.println("Opciones:");
                System.out.println("agregar - cargar - eliminar - imprimir - guardar - terminar - contar");
                opcion = entrada.nextLine();
                switch(opcion)
                {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "cargar":
                        cargar(entrada);
                        break;
                    case "eliminar":
                        eliminar(entrada);
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                    case "guardar":
                        guardar(entrada);
                        break;
                    case "contar":
                        contar();
                        break;
                    case "terminar":
                        System.out.println("Nos vemos");
                        break;
                }
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println(ex.getMessage());
                opcion = "";
            }
            catch (InputMismatchException ex2)
            {
                System.out.println("El numero de telefono debe tener unicamente digitos");
            }
            catch (FileNotFoundException e)
            {
                System.out.println("El archivo no existe");
                opcion = "";
            }
            catch(StringIndexOutOfBoundsException ex1)
            {
                System.out.println(ex1.getMessage());
                opcion ="";
            } catch (IOException e) {
                System.out.print("El nombre del archivo no es valido");
                opcion = "";
            }
            catch(NullContactException ex2)
            {
                ex2.getMessage();
            }
        }while(opcion!="terminar");
    }

    private void contar()
    {
        System.out.println("Tienes un total de: " + agenda.dimeContactos() + " Contactos");
    }

    private void eliminar(Scanner entrada)
    {
        System.out.println("Telefono del contacto a eliminar: ");
        long telEliminar = entrada.nextLong();
        agenda.elimina(telEliminar);
    }

    private void cargar(Scanner entrada) throws FileNotFoundException
    {
        System.out.print("Nombre del archivo: ");
        String nomArchivo = entrada.nextLine();
        agenda.cargar(nomArchivo);
    }

    private void guardar(Scanner entrada)throws IOException
    {
        System.out.print("Nombre del archivo: ");
        String nomArchivo = entrada.nextLine();
        agenda.guardar(nomArchivo);
    }

    private void agregar(Scanner entrada)
    {
        System.out.println("Agregar un nuevo contacto");
        System.out.println("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Direccion: ");
        String direccion = entrada.nextLine();
        System.out.println("Telefono: ");
        long telefono = entrada.nextLong();
        Contacto nuevo = new  Contacto(nombre,direccion,telefono);
        agenda.agregaContacto(nuevo);
    }
    public static void main(String[] args)
    {
        AplicacionTerminal aplicacion = new AplicacionTerminal();
        aplicacion.demo();
        aplicacion.entradaUsuario();
    }
}