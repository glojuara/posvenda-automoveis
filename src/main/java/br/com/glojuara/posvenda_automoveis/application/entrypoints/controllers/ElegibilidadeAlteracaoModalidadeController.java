package br.com.glojuara.posvenda_automoveis.application.entrypoints.controllers;


import br.com.glojuara.posvenda_automoveis.domain.usecases.ValidarEligibilidadeContratoAlteracaoModalidadeUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elegibilidades-contratos")
public class ElegibilidadeAlteracaoModalidadeController {


    private final ValidarEligibilidadeContratoAlteracaoModalidadeUseCase validarEligibilidadeContratoAlteracaoModalidadeUseCase;

    public ElegibilidadeAlteracaoModalidadeController(ValidarEligibilidadeContratoAlteracaoModalidadeUseCase validarEligibilidadeContratoAlteracaoModalidadeUseCase) {
        this.validarEligibilidadeContratoAlteracaoModalidadeUseCase = validarEligibilidadeContratoAlteracaoModalidadeUseCase;
    }

    @GetMapping("/{contratoId}")
    public ResponseEntity<String> elegibilidade(@PathVariable("contratoId") String numeroContrato) {
        validarEligibilidadeContratoAlteracaoModalidadeUseCase.execute(numeroContrato);
        return ResponseEntity.ok("Contrato elegivel");
    }


}
