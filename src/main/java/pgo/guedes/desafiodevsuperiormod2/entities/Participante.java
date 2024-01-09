package pgo.guedes.desafiodevsuperiormod2.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "participante_atividade",
            joinColumns = @JoinColumn(name = "participante_id", foreignKey = @ForeignKey(name = "fk_participante_atividade_participante")),
            inverseJoinColumns = @JoinColumn(name = "atividade_id", foreignKey = @ForeignKey(name = "k_participante_atividade_atividade"))
    )
    private Set<Atividade> atividades = new HashSet<>();

    public Participante() {
    }

    public Participante(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
