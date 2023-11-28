package ar.programa.proyectointegrador.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServicioDto {
    private String nombre;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private static ServicioDto servicioDto;

        private Builder() {
            this.servicioDto = new ServicioDto();
        }

        public Builder nombre(String nombre) {
            servicioDto.nombre = nombre;
            return this;
        }

        public ServicioDto build() {
            return servicioDto;
        }
    }
}