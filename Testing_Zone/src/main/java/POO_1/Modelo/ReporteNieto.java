/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO_1.Modelo;

public class ReporteNieto {
    private int AÑO;
    private int PERIODO;
    private int AÑO_NACIMIENTO;
    private String NACIMIENTO_PAIS, NACIMIENTO_DEPA, NACIMIENTO_PROV, NACIMIENTO_DIST;
    private String SEXO;
    private String FACULTAD, ESPECIALIDAD;
    private int CICLO_RELATIVO;

    // Aquí se usa el constructor completo para que utilice ciertos datos del CSV
    public ReporteNieto(int AÑO, int PERIODO, int AÑO_NACIMIENTO,
                  String NACIMIENTO_PAIS, String NACIMIENTO_DEPA, String NACIMIENTO_PROV,
                  String NACIMIENTO_DIST, String SEXO, String FACULTAD, 
                  String ESPECIALIDAD, int CICLO_RELATIVO) {
        this.AÑO = AÑO;
        this.PERIODO = PERIODO;
        this.AÑO_NACIMIENTO = AÑO_NACIMIENTO;
        this.NACIMIENTO_PAIS = NACIMIENTO_PAIS;
        this.NACIMIENTO_DEPA = NACIMIENTO_DEPA;
        this.NACIMIENTO_PROV = NACIMIENTO_PROV;
        this.NACIMIENTO_DIST = NACIMIENTO_DIST;
        this.SEXO = SEXO;
        this.FACULTAD = FACULTAD;
        this.ESPECIALIDAD = ESPECIALIDAD;
        this.CICLO_RELATIVO = CICLO_RELATIVO;
    }
    
    // Sobreescritura del toString()
    @Override
    public String toString() {
        return String.format("%-5S || "
                            + "%-8S || "
                            + "%-17S || "
                            + "%-16S || "
                            + "%-25S || "
                            + "%-30S || "
                            + "%-40S || "
                            + "%-20S || "
                            + "%-60S || "
                            + "%-50S || "
                            + "%-15S || ", AÑO, PERIODO, AÑO_NACIMIENTO,
                NACIMIENTO_PAIS, NACIMIENTO_DEPA, NACIMIENTO_PROV,
                NACIMIENTO_DIST, SEXO, FACULTAD, ESPECIALIDAD, 
                CICLO_RELATIVO);
    }
}
