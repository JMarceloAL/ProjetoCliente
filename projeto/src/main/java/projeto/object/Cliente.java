package projeto.object;

public class Cliente {

    public int codigo;
    public String nome;
    public String email;
    public String cpf;
    public String numeroTelefone;

    public Cliente() {

    }

    public Cliente(int codigo, String nome, String email, String cpf, String numeroTelefone) {

        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.numeroTelefone = numeroTelefone;

    }

    public int getId() {

        return codigo;
    }

    public void setId(int codigo) {

        this.codigo = codigo;
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

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getNumero() {

        return numeroTelefone;
    }

    public void setNumero(String numeroTelefone) {

        this.numeroTelefone = numeroTelefone;
    }

    public void mostrarDados() {

        System.out.println("---------------------------");
        System.out.println("ID :" + getId());
        System.out.println("Nome :" + getNome());
        System.out.println("CPF :" + getCpf());
        System.out.println("EMAIL :" + getEmail());
        System.out.println("TELEFONE :" + getNumero());

    }
}
