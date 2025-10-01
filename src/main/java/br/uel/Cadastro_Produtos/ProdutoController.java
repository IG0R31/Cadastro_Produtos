package br.uel.Cadastro_Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController{
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public String listarProduto(Model model){
        List<Produto> produto = produtoService.listarTodos();
        model.addAttribute("produto", produto);
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
        return "redirect:/produto";
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
        return "redirect:/produto";
    }
    @GetMapping("/buscar")
    public String buscarProduto(@RequestParam String nome, Model model){
        List<Produto> produto = produtoService.buscarPorNome(nome);
        model.addAttribute("produto", produto);
        model.addAttribute("termoBusca", nome);
        return "lista";
    }
}


