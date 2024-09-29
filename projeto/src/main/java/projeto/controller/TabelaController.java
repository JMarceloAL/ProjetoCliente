package projeto.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import projeto.dao.ClienteDao;
import projeto.object.Cliente;
import projeto.object.PessoaTabela;
import projeto.view.Cadastrar;
import projeto.view.Principal;
import projeto.view.Tabela;

public class TabelaController implements Initializable {
    @FXML
    private Button Vcadastrar;

    @FXML
    private Button Vinicio;

    @FXML
    private Button Bsair;

    @FXML
    private TableView<PessoaTabela> tabela;
    @FXML
    private TableColumn<PessoaTabela, String> ccpf;

    @FXML
    private TableColumn<PessoaTabela, String> cemail;

    @FXML
    private TableColumn<PessoaTabela, Integer> cid;

    @FXML
    private TableColumn<PessoaTabela, String> cnome;

    @FXML
    private TableColumn<PessoaTabela, String> ctelefone;

    private ClienteDao dao = new ClienteDao();

    private ObservableList<PessoaTabela> listaTabela = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        atualizarTabela();

        Bsair.setOnMouseClicked((MouseEvent e) -> {
            closeView();
        });

        Vinicio.setOnMouseClicked((MouseEvent e) -> {
            Principal p = new Principal();
            closeView();
            try {
                p.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        Vcadastrar.setOnMouseClicked((MouseEvent e) -> {
            Cadastrar p = new Cadastrar();
            closeView();
            try {
                p.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

    }

    public void atualizarTabela() {

        List<Cliente> clientelista = dao.ObterTodos();

        if (clientelista == null || clientelista.isEmpty()) {

            System.out.println("Nenhum Dado Encontrado");
            return;

        }
        if (!listaTabela.isEmpty()) {
            listaTabela.clear();
            System.out.println("Tabela limpa");

        }
        for (Cliente cliente : clientelista) {

            PessoaTabela p = new PessoaTabela(cliente.getId(), cliente.getNome(), cliente.getEmail(),
                    cliente.getCpf(), cliente.getNumero());

            listaTabela.add(p);

        }
        try {
            cid.setCellValueFactory(new PropertyValueFactory<PessoaTabela, Integer>("codigo"));
            cnome.setCellValueFactory(new PropertyValueFactory<PessoaTabela, String>("nome"));
            cemail.setCellValueFactory(new PropertyValueFactory<PessoaTabela, String>("email"));
            ccpf.setCellValueFactory(new PropertyValueFactory<PessoaTabela, String>("cpf"));
            ctelefone.setCellValueFactory(new PropertyValueFactory<PessoaTabela, String>("numeroTelefone"));
            tabela.setItems(listaTabela);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeView() {

        Tabela.getStage().close();

    }
}
