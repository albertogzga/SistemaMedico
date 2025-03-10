package mx.ipn.SistemaMedico.controllers;

import mx.ipn.SistemaMedico.models.Paciente;
import mx.ipn.SistemaMedico.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    /**
     * Endpoint para registrar un nuevo paciente.
     *
     * @param paciente Objeto Paciente recibido en el cuerpo de la solicitud.
     * @return El paciente registrado.
     */
    @PostMapping("/registrar")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.registrarPaciente(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    /**
     * Endpoint para obtener la lista de todos los pacientes.
     *
     * @return Lista de pacientes.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes();
        return ResponseEntity.ok(pacientes);
    }

    /**
     * Endpoint para obtener un paciente por su ID.
     *
     * @param id ID del paciente.
     * @return El paciente encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        return ResponseEntity.ok(paciente);
    }

    /**
     * Endpoint para eliminar un paciente por su ID.
     *
     * @param id ID del paciente a eliminar.
     * @return Respuesta sin contenido (204).
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
