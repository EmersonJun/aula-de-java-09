import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private String nome;
    private List<Materia> materias;
    public Aluno(String nome, List<Materia> materias) {
        this.nome = nome;
        this.materias = materias;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Materia> getMaterias(){
        return materias;
    }
    public void ordenarMaterias(){
        Collections.sort(materias);
    }
    public void addMateria (Materia materia){
        materias.add(materia);
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", materias=" + materias + "]";
    }
    
} 
