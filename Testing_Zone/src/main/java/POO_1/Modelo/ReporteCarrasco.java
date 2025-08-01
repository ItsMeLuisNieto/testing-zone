/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Modelo;

public class ReporteCarrasco {
    private int AÑO;
    private int PERIODO;
    private int AÑO_NACIMIENTO;
    private String TIPO_MATRICULA;
    private String NACIMIENTO_PAIS, NACIMIENTO_DEPA, NACIMIENTO_PROV, NACIMIENTO_DIST;
    private String SEXO;
    private String FACULTAD, ESPECIALIDAD;
    private int CICLO_RELATIVO;

    // Constructor que inicializa todos los atributos
    public ReporteCarrasco( int AÑO, int PERIODO, int AÑO_NACIMIENTO, String TIPO_MATRICULA,
                  String NACIMIENTO_PAIS, String NACIMIENTO_DEPA, String NACIMIENTO_PROV,
                  String NACIMIENTO_DIST, String SEXO, String FACULTAD, 
                  String ESPECIALIDAD, int CICLO_RELATIVO) {
        this.AÑO = AÑO;
        this.PERIODO = PERIODO;
        this.AÑO_NACIMIENTO = AÑO_NACIMIENTO;
        this.TIPO_MATRICULA = TIPO_MATRICULA;
        this.NACIMIENTO_PAIS = NACIMIENTO_PAIS;
        this.NACIMIENTO_DEPA = NACIMIENTO_DEPA;
        this.NACIMIENTO_PROV = NACIMIENTO_PROV;
        this.NACIMIENTO_DIST = NACIMIENTO_DIST;
        this.SEXO = SEXO;
        this.FACULTAD = FACULTAD;
        this.ESPECIALIDAD = ESPECIALIDAD;
        this.CICLO_RELATIVO = CICLO_RELATIVO;
    }

    // Sobreescritura del toString() en formato alineado vertical profesional
    @Override
    public String toString() {
        return String.format("%-5d || "
                        + "%-8d || "
                        + "%-30S || "
                        + "%-17d || "
                        + "%-16S || "
                        + "%-25S || "
                        + "%-30S || "
                        + "%-35S || "
                        + "%-20S || "
                        + "%-60S || "
                        + "%-50S || "
                        + "%-15S ||",
                AÑO, PERIODO, TIPO_MATRICULA, AÑO_NACIMIENTO,
                NACIMIENTO_PAIS, NACIMIENTO_DEPA, NACIMIENTO_PROV, NACIMIENTO_DIST,
                SEXO, FACULTAD, ESPECIALIDAD, CICLO_RELATIVO);
    }
}