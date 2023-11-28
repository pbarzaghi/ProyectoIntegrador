package ar.programa.proyectointegrador.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetalleIncidenciaDto {

    private String detalleProblema;

    private String descripcionProblema;

    private Boolean resuelto;

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private static DetalleIncidenciaDto detalleIncidenciaDto;

        private Builder() {
            detalleIncidenciaDto = new DetalleIncidenciaDto();
        }

        public  Builder detalleProblema(String detalleProblema) {
            detalleIncidenciaDto.detalleProblema =detalleProblema;
            return this;
        }

        public  Builder descripcionProblema(String descripcionProblema) {
            detalleIncidenciaDto.descripcionProblema =descripcionProblema;
            return this;
        }
        public  Builder resuelto(Boolean resuelto) {
            detalleIncidenciaDto.resuelto=resuelto;
            return this;
        }
        public DetalleIncidenciaDto build(){
            return detalleIncidenciaDto;
        }

    }
}
