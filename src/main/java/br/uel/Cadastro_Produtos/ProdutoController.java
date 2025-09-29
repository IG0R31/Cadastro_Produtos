package br.uel.Cadastro_Produtos; 

import br.uel.Cadastro_Produtos.model.Produto;
import br.uel.Cadastro_Produtos.service.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController{
    @Autowired
    private ProdutoService produtoService;

    @GetMapping 
    public String listarProdutos(Model model){
        List<Produto> produtos = produtoService.listarTodos();
        model.addAtribute("produtos", produtos);
        return "produtos/lista";
    }

    @GetMapping("/novo")
    public class mostrarFormulario(Model model){
        model.addAttribute("produto", new Produto());
        return "produtos/formulario";
    }

    @PostMapping("/salvar")
    public String slavarProduto(@ModelAttribute Produto produto){
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model){
        Produto produto = produtoService.buscarPorId(id) .orElseThrow(()-> new IllegalArgumentException("ID inválido:"+ id));
        model.addAttribute("produto", produto);
        return "produto/formulario";
    }
    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable Long id){
        produtoService.excluir(id);
        return "redirect:/produtos";
    }
    @GetMapping("/buscar")
    public String buscarProdutos(@RequestParam String nome, Model model){
        List<Produto> produtos = produtoService.buscarPorNome(nome);
        model.addAttribute("produtos", produtos);
        model.addAttribute("termoBusca", nome);
        return "produtos/lista";
    }
}


