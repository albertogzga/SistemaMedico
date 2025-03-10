package mx.ipn.SistemaMedico.service;

import mx.ipn.SistemaMedico.models.Paciente;
import mx.ipn.SistemaMedico.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     * Registra un nuevo paciente en la base de datos.
     *
     * @param paciente Objeto Paciente a registrar.
     * @return El Paciente registrado.
     */
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    /**
     * Obtiene la lista de todos los pacientes registrados.
     *
     * @return Lista de Pacientes.
     */
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    /**
     * Busca un paciente por su ID.
     *
     * @param id ID del paciente a buscar.
     * @return El Paciente encontrado o lanza una excepción si no existe.
     */
    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con el ID: " + id));
    }

    /**
     * Elimina un paciente por su ID.
     *
     * @param id ID del paciente a eliminar.
     */
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
