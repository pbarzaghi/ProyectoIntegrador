package ar.programa.proyectointegrador.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class TecnicoDto {

    private String nombre;
    private String mail;
    private String nroTel;
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final TecnicoDto tecnicoDto;

        private Builder() {
            this.tecnicoDto = new TecnicoDto();
        }

        public Builder nroTel(String nroTel) {
            tecnicoDto.nroTel = nroTel;
            return this;
        }

        public Builder mail(String mail) {
            tecnicoDto.mail = mail;
            return this;
        }

        public Builder nombre(String nombre) {
            tecnicoDto.nombre = nombre;
            return this;
        }

        // Otros métodos para establecer valores de otros campos

        public TecnicoDto build() {
            return tecnicoDto;
        }
    }


}
