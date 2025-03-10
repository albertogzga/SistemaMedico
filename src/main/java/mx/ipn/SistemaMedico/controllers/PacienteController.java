package mx.ipn.SistemaMedico.controllers;

import mx.ipn.SistemaMedico.models.Paciente;
import mx.ipn.SistemaMedico.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Maneja el registro de un nuevo paciente.
     * 
     * @param paciente Datos del paciente recibidos desde el formulario.
     * @return Redirección al login después del registro.
     */
    @PostMapping("/registrar")
    public String registrarPaciente(@ModelAttribute Paciente paciente) {
        // Codificar la contraseña antes de guardar
        paciente.setContraseña(passwordEncoder.encode(paciente.getContraseña()));
        
        // Asignar el rol de "Usuario" al nuevo paciente (asumiendo que el rol ID 1 es "Usuario")
        paciente.setRolId(1); 
        
        // Guardar el paciente en la base de datos
        pacienteRepository.save(paciente);
        
        return "redirect:/registro";
    }
}
