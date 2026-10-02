package com.sedena_encripted.sedena.controller;

import com.sedena_encripted.sedena.dto.ExpedienteRequestDto;
import com.sedena_encripted.sedena.dto.ExpedienteResponseDto;
import com.sedena_encripted.sedena.service.ExpedienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expedientes")
@RequiredArgsConstructor
public class InstitucionSedenaController {

    private final ExpedienteService expedienteService;

    @PostMapping("/sedena")
    public ResponseEntity<ExpedienteResponseDto> obtenerExpediente(
            @RequestHeader("X-Api-Key") String apiKey,
            @RequestHeader("X-Trace-Id") String traceId,
            @RequestHeader("X-Solicitante") String solicitante,
            @Valid @RequestBody ExpedienteRequestDto request)
            throws Exception {

        ExpedienteResponseDto response =
                expedienteService.obtenerExpediente(
                        apiKey,
                        traceId,
                        solicitante,
                        request);

        return ResponseEntity.ok(response);
    }
}
