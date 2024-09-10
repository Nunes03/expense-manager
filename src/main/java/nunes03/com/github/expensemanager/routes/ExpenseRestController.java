package nunes03.com.github.expensemanager.routes;

import nunes03.com.github.expensemanager.database.entities.LucasEntity;
import nunes03.com.github.expensemanager.database.repositories.LucasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/expense")
public class ExpenseRestController {

    final LucasRepository lucasRepository;

    public ExpenseRestController(LucasRepository lucasRepository) {
        this.lucasRepository = lucasRepository;
    }

    @GetMapping(value = "/id")
    @ResponseStatus(value = HttpStatus.OK)
    public String test(@RequestParam("id") String id) {
        System.err.println("Teste " + id);

        final var a = new LucasEntity();
        a.setName("Teste");

        final var b = new LucasEntity();
        b.setName("olja");

        lucasRepository.saveAll(List.of(a, b));

        System.err.println(lucasRepository.findAll());
        lucasRepository.deleteAll();

        return "teste";
    }
}
