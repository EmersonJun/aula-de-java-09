import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

        List<Materia> listaNova = aluno.getMaterias()
        .stream()
        .map(m -> new Materia(m.getNome() + "!")).collect(Collectors.toList());
        System.out.println(listaNova);
    }
}
