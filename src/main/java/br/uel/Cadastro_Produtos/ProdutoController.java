package br.uel.Cadastro_Produtos;

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
        model.addAttribute("produtos", produtos);
        return "lista";
    }

    @GetMapping("/novo")
    public String mostrarFormulario(Model model){
        model.addAttribute("produto", new Produto());
        return "form";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto){
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model){
        Produto produto = produtoService.buscarPorId(id).orElseThrow(()-> new IllegalArgumentException("ID inválido:"+ id));
        model.addAttribute("produto", produto);
        return "form";
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
        return "lista";
    }
}


