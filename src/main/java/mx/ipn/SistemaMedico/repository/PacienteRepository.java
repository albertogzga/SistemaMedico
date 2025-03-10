package mx.ipn.SistemaMedico.repository;

import mx.ipn.SistemaMedico.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas, por ejemplo:
    // Optional<Paciente> findByCorreo(String correo);
}
