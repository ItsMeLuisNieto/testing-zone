/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Modelo;

public class ReporteWong {
    private String colegioDepa;
    private String colegioProv;
    private String colegioDist;
    private int anio;
    private int periodo;
    private String tipoMatricula;
    private String domicilioDepa;
    private String domicilioProv;
    private String domicilioDist;
    private int anioNacimiento;
    private String nacimientoPais;
    private String nacimientoDepa;
    private String nacimientoProv;
    private String nacimientoDist;
    private String sexo;
    private String modalidad;
    private String metodologia;
    private String facultad;
    private String especialidad;
    private int cicloRelativo;
    // Constructor que inicializa todos los atributos
    public ReporteWong(String colegioDepa, String colegioProv, String colegioDist, int anio, int periodo,
                       String tipoMatricula, String domicilioDepa, String domicilioProv, String domicilioDist,
                       int anioNacimiento, String nacimientoPais, String nacimientoDepa, String nacimientoProv,
                       String nacimientoDist, String sexo, String modalidad, String metodologia,
                       String facultad, String especialidad, int cicloRelativo) {
        this.colegioDepa = colegioDepa;
        this.colegioProv = colegioProv;
        this.colegioDist = colegioDist;
        this.anio = anio;
        this.periodo = periodo;
        this.tipoMatricula = tipoMatricula;
        this.domicilioDepa = domicilioDepa;
        this.domicilioProv = domicilioProv;
        this.domicilioDist = domicilioDist;
        this.anioNacimiento = anioNacimiento;
        this.nacimientoPais = nacimientoPais;
        this.nacimientoDepa = nacimientoDepa;
        this.nacimientoProv = nacimientoProv;
        this.nacimientoDist = nacimientoDist;
        this.sexo = sexo;
        this.modalidad = modalidad;
        this.metodologia = metodologia;
        this.facultad = facultad;
        this.especialidad = especialidad;
        this.cicloRelativo = cicloRelativo;
    }
    // Sobreescritura del toString() en formato alineado vertical profesional
    @Override
    public String toString() {
        return String.format("%-20S || "
                            + "%-30S || "
                            + "%-40S || "
                            + "%-5S || "
                            + "%-8S || "
                            + "%-30S || "
                            + "%-25S || "
                            + "%-30S || "
                            + "%-33S || "
                            + "%-17S || "
                            + "%-16S || "
                            + "%-25S || "
                            + "%-30S || "
                            + "%-40S || "
                            + "%-20S || "
                            + "%-50S || "
                            + "%-20S || "
                            + "%-60S || "
                            + "%-50S || "
                            + "%-15S || ",
                colegioDepa, colegioProv, colegioDist,
                anio, periodo, tipoMatricula, domicilioDepa,
                domicilioProv, domicilioDist, anioNacimiento,
                nacimientoPais, nacimientoDepa, nacimientoProv,
                nacimientoDist, sexo, modalidad, metodologia,
                facultad, especialidad, cicloRelativo);
    }
}
