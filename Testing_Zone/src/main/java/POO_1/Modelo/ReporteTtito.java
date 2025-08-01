/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Modelo;

public class ReporteTtito {
    private int AÑO;
    private int PERIODO;
    private int AÑO_NACIMIENTO;

    private String DOMICILIO_DEPA;
    private String DOMICILIO_PROV;
    private String DOMICILIO_DIST;

    private String NACIMIENTO_PAIS;
    private String NACIMIENTO_DEPA;
    private String NACIMIENTO_PROV;
    private String NACIMIENTO_DIST;

    private String SEXO;
    private String MODALIDAD;
    private String METODOLOGIA;
    private String FACULTAD;
    private String ESPECIALIDAD;
    private int CICLO_RELATIVO;
    // Constructor que inicializa todos los atributos
    public ReporteTtito(int AÑO, int PERIODO, int AÑO_NACIMIENTO,
                        String DOMICILIO_DEPA, String DOMICILIO_PROV, String DOMICILIO_DIST,
                        String NACIMIENTO_PAIS, String NACIMIENTO_DEPA, String NACIMIENTO_PROV,
                        String NACIMIENTO_DIST, String SEXO, String MODALIDAD, String METODOLOGIA,
                        String FACULTAD, String ESPECIALIDAD, int CICLO_RELATIVO) {
        this.AÑO = AÑO;
        this.PERIODO = PERIODO;
        this.AÑO_NACIMIENTO = AÑO_NACIMIENTO;
        this.DOMICILIO_DEPA = DOMICILIO_DEPA;
        this.DOMICILIO_PROV = DOMICILIO_PROV;
        this.DOMICILIO_DIST = DOMICILIO_DIST;
        this.NACIMIENTO_PAIS = NACIMIENTO_PAIS;
        this.NACIMIENTO_DEPA = NACIMIENTO_DEPA;
        this.NACIMIENTO_PROV = NACIMIENTO_PROV;
        this.NACIMIENTO_DIST = NACIMIENTO_DIST;
        this.SEXO = SEXO;
        this.MODALIDAD = MODALIDAD;
        this.METODOLOGIA = METODOLOGIA;
        this.FACULTAD = FACULTAD;
        this.ESPECIALIDAD = ESPECIALIDAD;
        this.CICLO_RELATIVO = CICLO_RELATIVO;
    }
    // Sobreescritura del toString() en formato alineado vertical profesional
    @Override
    public String toString() {
        return String.format("%-5S || "
                        + "%-8S || "
                        + "%-17S || "
                        + "%-35S || "
                        + "%-30S || "
                        + "%-33S || "
                        + "%-16S || "
                        + "%-25S || "
                        + "%-30S || "
                        + "%-40S || "
                        + "%-20S || "
                        + "%-50S || "
                        + "%-20S || "
                        + "%-60S || "
                        + "%-50S || "
                        + "%-15S || ",AÑO,PERIODO,AÑO_NACIMIENTO,DOMICILIO_DEPA,DOMICILIO_PROV,
                DOMICILIO_DIST,NACIMIENTO_PAIS,NACIMIENTO_DEPA,NACIMIENTO_PROV,NACIMIENTO_DIST,SEXO,
                MODALIDAD,METODOLOGIA,FACULTAD,ESPECIALIDAD,CICLO_RELATIVO);
    }
}