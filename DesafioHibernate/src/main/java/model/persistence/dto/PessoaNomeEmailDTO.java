package model.persistence.dto;

public class PessoaNomeEmailDTO {

    private String nome;
    private String email;

    public PessoaNomeEmailDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
