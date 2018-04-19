import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    List<Persona> listado=Stream.generate(Persona::new)
        .limit(50)
        .peek((p)->p.setNombre("pepe"))
        .collect(Collectors.toList());

    // Peek nos permite "debuggear" los distintos pasos de transformación
    listado.stream().peek(
        (cadena)-> {
          System.out.println("***inicio***");
          System.out.println(cadena);
          System.out.println("***fin***");
        }
    )
        .forEach((x)-> System.out.println("otra "+x.getNombre()));

    List<Integer> lista2= Arrays.asList(1,3,4,5,6,7,1,2);
    lista2.stream().filter((x)->x>5).forEach(System.out::println);


    List<String> lista3=Arrays.asList("hola","que","tal");
    Optional<String> resultado=lista3.stream().reduce(String::concat);
    if(resultado.isPresent()) {

      System.out.println(resultado.get());
    }

    // Map Reduce 1
    Optional<String> resultado2 = listado.stream()
        .map((x)->x.getNombre().toUpperCase())
        .reduce( String::concat );

    if(resultado2.isPresent()) {
      System.out.println("Map Reduce forma 1");
      System.out.println(resultado2.get());
    }


    Optional<String> resultado3 = listado.stream()
       .map((x)->x.getNombreUpper())
       .reduce( (x,y)-> x.concat( y.toUpperCase()).toUpperCase() );


    if(resultado3.isPresent()) {
      System.out.println("Map Reduce forma 2");
      System.out.println(resultado3.get());
    }


//    for (Persona p: lista) {
//
//      System.out.println(p.getNombre());
//    }

  }
}

