public class Reinas 
{
   boolean[] horizontal=new boolean [8];
   boolean[] vertical =new boolean [8];
   boolean[] diagonalInferior = new boolean[15];
   boolean[] diagonalSuperior = new boolean[15];

   int[] solucion=new int [8];//solo se guarda el numero de columna y el indice es el numero de fila
   private boolean salir=false;
   
   public Reinas()
    {// se inicializan todas las variables     
    for (int i=0;i<8;i++)
    {
    horizontal[i]=true;
    vertical[i]=true;
    solucion[i]=-1;
    }  
    for (int i = 0; i<diagonalInferior.length;i++)
    {
     diagonalInferior[i] = true;
     diagonalSuperior[i] = true;
    }    
    }

    private void buscarSolucion(int fila){
        int columna = 0;
        while (columna < 8 && !salir){
            if (horizontal[fila] && vertical[columna] && diagonalInferior[columna-fila+7] && diagonalSuperior[columna+fila])
           //son las coordenadas que no puede tocar alguna reina. las disponibles 
            {
                solucion[fila] = columna;
                horizontal[fila] = false;
                vertical[columna] = false;
                diagonalSuperior[columna+fila] = false;
                diagonalInferior[columna-fila+7] = false;
 
                if (fila ==7 )
                {
                    salir = true;// se han recorrido las 8 filas del tablero
                }else{
                    if (fila < 7 ){
                        buscarSolucion(fila+1);
                    }
                    if (!salir){                 
                        solucion[fila] = -1;
                        horizontal[fila] = true;
                        vertical[columna] = true;
                        diagonalInferior[columna-fila+7] = true;
                        diagonalSuperior[columna+fila] = true;
 
                    }
                }
            }
            columna++; //aumentamos la columna
        }
    }
 

    public void buscar(){
  buscarSolucion(0);//comienza desde la fila 0
  coordenadas();
    }
    

    public  void coordenadas(){
  System.out.println("Solucion \n Fila,Columna");
      for(int i=0;i<solucion.length;i++)
      {System.out.println("( "+(i+1)+" , "+(solucion[i]+1)+")");}
        
    }
    
    
    public static void main(String[] args) {
       Reinas r=new Reinas();
     r.buscar();
    }   
}   
