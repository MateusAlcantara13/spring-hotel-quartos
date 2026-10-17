package org.example.hotel.controller;

import jakarta.validation.Valid;
import org.example.hotel.model.Quarto;
import org.example.hotel.model.TipoQuarto;
import org.example.hotel.repository.QuartoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoRepository repository;

    public QuartoController(QuartoRepository repository){
        this.repository = repository;
    }

    // 1 - Listar tudo
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("quartos", repository.getTodos());
        return "quartos";
    }

    // 2 - Mostrar formulário
    @GetMapping("/novo")
    public String exibirForm(Model model) {
        model.addAttribute("postForm", new Quarto());
        model.addAttribute("categorias", TipoQuarto.values());
        return "form";
    }

    // 3 - Adicionar na lista
    @PostMapping
    public String postar(@Valid @ModelAttribute("postForm") Quarto quarto, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("categorias", TipoQuarto.values());
            return "form";
        }
        repository.adicionar(quarto);
        return "redirect:/quartos";
    }

    // buscar por id
    @GetMapping("/{id}")
    public String buscarId(@PathVariable Long id, Model model) {
        model.addAttribute("detalhes", repository.buscarPorId(id));
        return "detalhes";
    }

    // ocupar
    @PostMapping("/{id}/ocupar")
    public String ocupar(@PathVariable Long id){
        repository.buscarPorId(id).ocupar();
        return "redirect:/quartos";
    }

    // liberar
    @PostMapping("/{id}/liberar")
    public String liberar(@PathVariable Long id){
        repository.buscarPorId(id).liberar();
        return "redirect:/quartos";
    }

    // enviar para manuntenção
    @PostMapping("/{id}/enviarManutencao")
    public String enviarManutencao(@PathVariable Long id) {
        repository.buscarPorId(id).enviarManutencao();
        return "redirect:/quartos";
    }

    // retorna lista de quartos livres e o seu respectivo número
    @GetMapping("/livres")
    public String diponiveis(Model model){
        model.addAttribute("disponiveis", repository.listarlivres());
        model.addAttribute("numeroDisponíveis", repository.contarLivres());
        return "livres";
    }

}
