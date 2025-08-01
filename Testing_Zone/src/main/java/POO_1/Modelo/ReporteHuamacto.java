/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Modelo;

// Clase que representa el reporte Huamacto con datos académicos y personales del estudiante
public class ReporteHuamacto {
    private String COLEGIO_DEPA, COLEGIO_PROV, COLEGIO_DIST;
    private int AÑO;
    private int PERIODO;
    private String TIPO_MATRICULA;
    private String DOMICILIO_DEPA, DOMICILIO_PROV, DOMICILIO_DIST;
    private int AÑO_NACIMIENTO;
    private String NACIMIENTO_PAIS, NACIMIENTO_DEPA, NACIMIENTO_PROV, NACIMIENTO_DIST;
    private String SEXO;
    private String MODALIDAD, METODOLOGIA;
    private String FACULTAD, ESPECIALIDAD;
    private int CICLO_RELATIVO;
    
     // Constructor que inicializa todos los atributos de la clase con los datos proporcionados
    public ReporteHuamacto( String COLEGIO_DEPA, String COLEGIO_PROV, String COLEGIO_DIST,
                           int AÑO, int PERIODO, String TIPO_MATRICULA,
                           String DOMICILIO_DEPA, String DOMICILIO_PROV, String DOMICILIO_DIST,
                           int AÑO_NACIMIENTO, String NACIMIENTO_PAIS, String NACIMIENTO_DEPA,
                           String NACIMIENTO_PROV, String NACIMIENTO_DIST,
                           String SEXO, String MODALIDAD, String METODOLOGIA,
                           String FACULTAD, String ESPECIALIDAD, int CICLO_RELATIVO) {
        this.COLEGIO_DEPA = COLEGIO_DEPA;
        this.COLEGIO_PROV = COLEGIO_PROV;
        this.COLEGIO_DIST = COLEGIO_DIST;
        this.AÑO = AÑO;
        this.PERIODO = PERIODO;
        this.TIPO_MATRICULA = TIPO_MATRICULA;
        this.DOMICILIO_DEPA = DOMICILIO_DEPA;
        this.DOMICILIO_PROV = DOMICILIO_PROV;
        this.DOMICILIO_DIST = DOMICILIO_DIST;
        this.AÑO_NACIMIENTO = AÑO_NACIMIENTO;
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
    
    // Método que devuelve una representación de todos los datos del estudiante
    // en una sola línea de texto, alineada con formato profesional para mostrar como reporte.
    @Override
    public String toString() {
        return String.format("%-19S || "
                            + "%-25S || "
                            + "%-35S || "
                            + "%-5S || "
                            + "%-8S || "
                            + "%-30S || "
                            + "%-20S || "
                            + "%-25S || "
                            + "%-28S || "
                            + "%-17S || "
                            + "%-16S || "
                            + "%-25S || "
                            + "%-30S || "
                            + "%-35S || "
                            + "%-25S || "
                            + "%-50S || "
                            + "%-20S || "
                            + "%-60S || "
                            + "%-50S || "
                            + "%-15S || ",COLEGIO_DEPA, COLEGIO_PROV, COLEGIO_DIST,
                AÑO, PERIODO, TIPO_MATRICULA, DOMICILIO_DEPA, DOMICILIO_PROV, DOMICILIO_DIST,
                AÑO_NACIMIENTO, NACIMIENTO_PAIS, NACIMIENTO_DEPA, NACIMIENTO_PROV, NACIMIENTO_DIST,
                SEXO, MODALIDAD, METODOLOGIA, FACULTAD, ESPECIALIDAD, CICLO_RELATIVO);
    }
}