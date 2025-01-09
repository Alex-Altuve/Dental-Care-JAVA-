
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author sofiaarasme
 */
public class Historia {
    
    private  String cedula_paciente;
    private  String nombre_contacto;
    private  String telefono_contacto;
    private  String parentesco_contacto;
    private  String RB1;
    private  String ESP1;
    private  String RB2;
    private  String ESP2;
    private  String RB3;
    private  String ESP3;
    private  String RB4;
    private  String ESP4;
    private  String RB5;
    private  String ESP5;
    private  String RB6;
    private  String ESP6;
    private  String RB7;
    private  String RB8;
    private  String RB9;
    private  String RBA;
    private  String RBB;
    private  String text_habito;
    private  String text_motivo;
    private  boolean check_boca;
    private  boolean check_cara;
    private  boolean check_cuello;
    private  boolean check_ortodoncia;
    private  boolean check_cirugia;
    private  boolean check_periodoncia;
    private  boolean check_implantes;
    private  boolean check_endodoncia;
    private  boolean check_restauracion;
    private  String text_otras_obs;
    
    public Historia(String cedula_paciente, String nombre_contacto, String telefono_contacto, String parentesco_contacto, String RB1, String ESP1, String RB2, String ESP2, String RB3, String ESP3, String RB4, String ESP4, String RB5, String ESP5, String RB6, String ESP6, String RB7, String RB8, String RB9, String RBA, String RBB, String text_habito, String text_motivo, boolean check_boca, boolean check_cara, boolean check_cuello, boolean check_ortodoncia, boolean check_cirugia, boolean check_periodoncia, boolean check_implantes, boolean check_endodoncia, boolean check_restauracion, String text_otras_obs) {
        
        this.cedula_paciente = cedula_paciente;
        this.nombre_contacto = nombre_contacto;
        this.telefono_contacto = telefono_contacto;
        this.parentesco_contacto = parentesco_contacto;
        this.RB1 = RB1;
        this.ESP1 = ESP1;
        this.RB2 = RB2;
        this.ESP2 = ESP2;
        this.RB3 = RB3;
        this.ESP3 = ESP3;
        this.RB4 = RB4;
        this.ESP4 = ESP4;
        this.RB5 = RB5;
        this.ESP5 = ESP5;
        this.RB6 = RB6;
        this.ESP6 = ESP6;
        this.RB7 = RB7;
        this.RB8 = RB8;
        this.RB9 = RB9;
        this.RBA = RBA;
        this.RBB = RBB;
        this.text_habito = text_habito;
        this.text_motivo = text_motivo;
        this.check_boca = check_boca;
        this.check_cara = check_cara;
        this.check_cuello = check_cuello;
        this.check_ortodoncia = check_ortodoncia;
        this.check_cirugia = check_cirugia;
        this.check_periodoncia = check_periodoncia;
        this.check_implantes = check_implantes;
        this.check_endodoncia = check_endodoncia;
        this.check_restauracion = check_restauracion;
        this.text_otras_obs = text_otras_obs;
        
    }
   
    
    public Historia() {
        
        this.cedula_paciente = "";
        this.nombre_contacto = "";
        this.telefono_contacto = "";
        this.parentesco_contacto = "";
        this.RB1 = "";
        this.ESP1 = "";
        this.RB2 = "";
        this.ESP2 = "";
        this.RB3 = "";
        this.ESP3 = "";
        this.RB4 = "";
        this.ESP4 = "";
        this.RB5 = "";
        this.ESP5 = "";
        this.RB6 = "";
        this.ESP6 = "";
        this.RB7 = "";
        this.RB8 = "";
        this.RB9 = "";
        this.RBA = "";
        this.RBB = "";
        this.text_habito = "";
        this.text_motivo = "";
        this.check_boca = false;
        this.check_cara = false;
        this.check_cuello = false;
        this.check_ortodoncia = false;
        this.check_cirugia = false;
        this.check_periodoncia = false;
        this.check_implantes = false;
        this.check_endodoncia = false;
        this.check_restauracion = false;
        this.text_otras_obs = "";
        
        
    }
    

    public String getCedula_paciente() {
        return cedula_paciente;
    }

    public void setCedula_paciente(String cedula_paciente) {
        this.cedula_paciente = cedula_paciente;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getParentesco_contacto() {
        return parentesco_contacto;
    }

    public void setParentesco_contacto(String parentesco_contacto) {
        this.parentesco_contacto = parentesco_contacto;
    }

    public String getRB1() {
        return RB1;
    }

    public void setRB1(String RB1) {
        this.RB1 = RB1;
    }

    public String getESP1() {
        return ESP1;
    }

    public void setESP1(String ESP1) {
        this.ESP1 = ESP1;
    }

    public String getRB2() {
        return RB2;
    }

    public void setRB2(String RB2) {
        this.RB2 = RB2;
    }

    public String getESP2() {
        return ESP2;
    }

    public void setESP2(String ESP2) {
        this.ESP2 = ESP2;
    }

    public String getRB3() {
        return RB3;
    }

    public void setRB3(String RB3) {
        this.RB3 = RB3;
    }

    public String getESP3() {
        return ESP3;
    }

    public void setESP3(String ESP3) {
        this.ESP3 = ESP3;
    }

    public String getRB4() {
        return RB4;
    }

    public void setRB4(String RB4) {
        this.RB4 = RB4;
    }

    public String getESP4() {
        return ESP4;
    }

    public void setESP4(String ESP4) {
        this.ESP4 = ESP4;
    }

    public String getRB5() {
        return RB5;
    }

    public void setRB5(String RB5) {
        this.RB5 = RB5;
    }

    public String getESP5() {
        return ESP5;
    }

    public void setESP5(String ESP5) {
        this.ESP5 = ESP5;
    }

    public String getRB6() {
        return RB6;
    }

    public void setRB6(String RB6) {
        this.RB6 = RB6;
    }

    public String getESP6() {
        return ESP6;
    }

    public void setESP6(String ESP6) {
        this.ESP6 = ESP6;
    }

    public String getRB7() {
        return RB7;
    }

    public void setRB7(String RB7) {
        this.RB7 = RB7;
    }

    public String getRB8() {
        return RB8;
    }

    public void setRB8(String RB8) {
        this.RB8 = RB8;
    }

    public String getRB9() {
        return RB9;
    }

    public void setRB9(String RB9) {
        this.RB9 = RB9;
    }

    public String getRBA() {
        return RBA;
    }

    public void setRBA(String RBA) {
        this.RBA = RBA;
    }

    public String getRBB() {
        return RBB;
    }

    public void setRBB(String RBB) {
        this.RBB = RBB;
    }

    public String getText_habito() {
        return text_habito;
    }

    public void setText_habito(String text_habito) {
        this.text_habito = text_habito;
    }

    public String getText_motivo() {
        return text_motivo;
    }

    public void setText_motivo(String text_motivo) {
        this.text_motivo = text_motivo;
    }

    public boolean isCheck_boca() {
        return check_boca;
    }

    public void setCheck_boca(boolean check_boca) {
        this.check_boca = check_boca;
    }

    public boolean isCheck_cara() {
        return check_cara;
    }

    public void setCheck_cara(boolean check_cara) {
        this.check_cara = check_cara;
    }

    public boolean isCheck_cuello() {
        return check_cuello;
    }

    public void setCheck_cuello(boolean check_cuello) {
        this.check_cuello = check_cuello;
    }

    public boolean isCheck_ortodoncia() {
        return check_ortodoncia;
    }

    public void setCheck_ortodoncia(boolean check_ortodoncia) {
        this.check_ortodoncia = check_ortodoncia;
    }

    public boolean isCheck_cirugia() {
        return check_cirugia;
    }

    public void setCheck_cirugia(boolean check_cirugia) {
        this.check_cirugia = check_cirugia;
    }

    public boolean isCheck_periodoncia() {
        return check_periodoncia;
    }

    public void setCheck_periodoncia(boolean check_periodoncia) {
        this.check_periodoncia = check_periodoncia;
    }

    public boolean isCheck_implantes() {
        return check_implantes;
    }

    public void setCheck_implantes(boolean check_implantes) {
        this.check_implantes = check_implantes;
    }

    public boolean isCheck_endodoncia() {
        return check_endodoncia;
    }

    public void setCheck_endodoncia(boolean check_endodoncia) {
        this.check_endodoncia = check_endodoncia;
    }

    public boolean isCheck_restauracion() {
        return check_restauracion;
    }

    public void setCheck_restauracion(boolean check_restauracion) {
        this.check_restauracion = check_restauracion;
    }

    

    public String getText_otras_obs() {
        return text_otras_obs;
    }

    public void setText_otras_obs(String text_otras_obs) {
        this.text_otras_obs = text_otras_obs;
    }
    
    ////Método para crear la historia del paciente por primera vez al dar click al botón de Historia////
    public void CrearHistoria(String cedula_paciente, String nombre_contacto, String telefono_contacto, String parentesco_contacto, String RB1, String ESP1, String RB2, String ESP2, String RB3, String ESP3, String RB4, String ESP4, String RB5, String ESP5, String RB6, String ESP6, String RB7, String RB8, String RB9, String RBA, String RBB, String text_habito, String text_motivo, boolean check_boca, boolean check_cara, boolean check_cuello, boolean check_ortodoncia, boolean check_cirugia, boolean check_periodoncia, boolean check_implantes, boolean check_endodoncia, boolean check_restauracion, String text_otras_obs){
        
        this.cedula_paciente = cedula_paciente;
        this.nombre_contacto = nombre_contacto;
        this.telefono_contacto = telefono_contacto;
        this.parentesco_contacto = parentesco_contacto;
        this.RB1 = RB1;
        this.ESP1 = ESP1;
        this.RB2 = RB2;
        this.ESP2 = ESP2;
        this.RB3 = RB3;
        this.ESP3 = ESP3;
        this.RB4 = RB4;
        this.ESP4 = ESP4;
        this.RB5 = RB5;
        this.ESP5 = ESP5;
        this.RB6 = RB6;
        this.ESP6 = ESP6;
        this.RB7 = RB7;
        this.RB8 = RB8;
        this.RB9 = RB9;
        this.RBA = RBA;
        this.RBB = RBB;
        this.text_habito = text_habito;
        this.text_motivo = text_motivo;
        this.check_boca = check_boca;
        this.check_cara = check_cara;
        this.check_cuello = check_cuello;
        this.check_ortodoncia = check_ortodoncia;
        this.check_cirugia = check_cirugia;
        this.check_periodoncia = check_periodoncia;
        this.check_implantes = check_implantes;
        this.check_endodoncia = check_endodoncia;
        this.check_restauracion = check_restauracion;
        this.text_otras_obs = text_otras_obs;
        
    }
    
    
    ////Método para validar si la historia del paciente ya se encuentra creada o no ////
    public boolean ValidarHistoriaCreada(ArrayList <Historia> Historias, String Cedula){
        if(Historias.isEmpty() == false){

            for(int i=0; i< Historias.size(); i++){
                if(Historias.get(i).getCedula_paciente().trim().equals(Cedula.trim())){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
}
