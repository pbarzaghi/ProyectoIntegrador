package ar.programa.proyectointegrador.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EspecialidadDto {
    private String nombre;

    public static  Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private static EspecialidadDto especialidadDto;
        private Builder() {
            this.especialidadDto= new EspecialidadDto();
        }
        public  Builder nombre(String nombre) {
            especialidadDto.nombre = nombre;
            return this;
        }
        public EspecialidadDto build() {
            return especialidadDto;
        }
    }
}
