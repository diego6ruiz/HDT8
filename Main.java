import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        
        String nombre=" ";
        String sintoma=" ";
        String prioridad=" ";
        int x=0;
        String pacientes= null;
        
        //Variables para sacar informacion del txt
        String sint=" ";
        int nombreIndex=0;
        String a="";
        String b="";
        
        PriorityQueue<Paciente> prioqueue = new PriorityQueue<Paciente> ();
        VectorHeap<Paciente> heap= new VectorHeap<Paciente>();
        
        FileReader fileReader = new FileReader("pacientes.txt");
        BufferedReader pacientesTxt = new BufferedReader(fileReader);  
      
        while((pacientes = pacientesTxt.readLine()) != null) {
        	
        	//Obtenemos el nombre
        	nombre= pacientes.substring(0, nombreIndex=pacientes.indexOf(","));
        	a=pacientes.replaceFirst(nombre, " ");
        	b=a.replaceFirst(",", " ");
        	
        	//Obtenemos el sintoma
        	sintoma=a.substring(a.indexOf(" ")+3, b.indexOf(",") );
        	sint=pacientes.replaceFirst(",", "");
        	
        	//Obtenemos la prioridad
        	prioridad=pacientes.substring(sint.indexOf(",")+2,pacientes.length());
        	
        	//Creamos el paciente con los datos anteriores y lo agregamos al heap y al queue
        	Paciente pacient= new Paciente();
        	pacient.setNombre(nombre);
        	pacient.setSintoma(sintoma);
        	pacient.setPrioridad(prioridad);
        	heap.add(pacient);
        	prioqueue.add(pacient);
        }
        
        String menu = """
        		Ingrese que desea hacer
        		1. Ordenar con My Priority Queue
        		2. Ordenar con Priority Queue implementada de Java Collection Framework 
        		3. Atender al paciente con mayor prioridad
        		4. Salir""";
     
       System.out.println ("-----------------------------------------------------------------");
       System.out.println ("Seccion de Emergencias de Hospital");
       System.out.println (menu);
       
       x=scanner.nextInt();
       scanner.nextLine();
       while(x!=4){
       if (x==1){
           System.out.println (heap.toString());
       }
       else if (x==2){
           System.out.println (prioqueue.toString());
       }
       else if(x==3){
    	   Paciente atendido = heap.remove();
           System.out.println ("Se atendio a: "+atendido.toString());
           System.out.println ("La lista de espera es ahora: \n"+heap.toString());
       }
       System.out.println (menu);
       x=scanner.nextInt();
       scanner.nextLine();
       }
      
    
      
    }
    
    
    
}
