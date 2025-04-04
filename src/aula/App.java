package aula;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        

        Aluno aluno = new Aluno("pedro", new ArrayList<>());

        String[] nomesMaterias = {"php", "java", "c", "c#"};

        for(String mat : nomesMaterias){
            aluno.addMateria(new Materia(mat));

            aluno.ordenarMaterias();
            System.out.println(aluno);

            aluno.ordenarMaterias();
            System.out.println(aluno);
        }




            System.out.println("################ Stream em java ##############");


            Materia html = aluno.getMaterias()
            .stream()
            .filter(m -> m.getNome().equals("HTML5"))
            .findFirst().orElse(null);
        System.out.println(html);

        aluno.addMateria(new Materia("php"));
        List<Materia> listaNova = aluno.getMaterias()
        .stream()
        .map(m -> new Materia(m.getNome() + "!")).collect(Collectors.toList());
        System.out.println(listaNova);

        listaNova = aluno.getMaterias()
        .stream().filter(m-> m.getNome().equals("Php")).collect(Collectors.toList());

        System.out.println("lista nova: "+listaNova);

        System.out.println(aluno.getMaterias()
        .stream()
        .map(Materia::getNome)
        .reduce("\n Matrias: ", (novaString, stringInteradora) -> stringInteradora + "")
        );


        System.out.println("\n############# Set em java ##############\n");
        //hashset nao mantem ordem nenhuma
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("php");
        set.add("php");
        set.add("c++");
        set.add("HTML5");
        set.add("HTML5");
        set.add("css");

        System.out.println(set);

        
        //linkedhashset mantem ordem
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("java");
        linkedSet.add("php");
        linkedSet.add("php");
        linkedSet.add("c++");
        linkedSet.add("HTML5");
        linkedSet.add("HTML5");
        linkedSet.add("css");

        System.out.println(linkedSet);


        //ordem alfabetica
        Set<String> treedSet = new TreeSet<>();
        treedSet.add("java");
        treedSet.add("php");
        treedSet.add("php");
        treedSet.add("c++");
        treedSet.add("HTML5");
        treedSet.add("HTML5");
        treedSet.add("css");

        System.out.println(treedSet);

    }
}
