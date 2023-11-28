package ar.programa.proyectointegrador.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor

public class IncidenciaDto {

    private String alias;
    private String descripcion;
    private LocalDateTime fechaEstimada;
    private Boolean resuelto;
    public static Builder builder() {
        return new  Builder();
    }


    public static class Builder {
         private final IncidenciaDto incidenciaDto;

            private Builder() {
                this.incidenciaDto = new IncidenciaDto();
            }

            public Builder alias(String alias) {
                incidenciaDto.alias = alias;
                return this;
            }

            public  Builder descripcion(String descripcion) {
                incidenciaDto.descripcion = descripcion;
                return this;
            }

            public  Builder fechaEstimada(LocalDateTime fechaEstimada) {
                incidenciaDto.fechaEstimada = fechaEstimada;
                return this;
            }
            public  Builder resuelto(Boolean resuelto) {
                incidenciaDto.resuelto = resuelto;
                return this;
            }

            // Otros métodos para establecer valores de otros campos

            public IncidenciaDto build() {
                return incidenciaDto;
            }
}


}