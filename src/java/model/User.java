package model;

import java.time.OffsetDateTime;

public class User {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private OffsetDateTime Data_Nascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public OffsetDateTime getData_Nascimento_codigo() {
        return Data_Nascimento;
    }
    public OffsetDateTime getData_Nascimento(OffsetDateTime date){
        return date;
    }
    public void setData_Nascimento(OffsetDateTime data_Nascimento) {
        Data_Nascimento = data_Nascimento;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", Data_Nascimento=" + Data_Nascimento +
                '}';
    }
}