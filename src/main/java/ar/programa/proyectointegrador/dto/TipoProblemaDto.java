package ar.programa.proyectointegrador.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TipoProblemaDto {

    private String tipo;
   private Integer tiempoEnDias;
    public static  Builder builder() {
        return new  Builder();
    }
    public static class Builder {
        private static TipoProblemaDto tipoProblemaDto;

        private Builder() {
            tipoProblemaDto = new TipoProblemaDto();
        }

        public  Builder tipo(String tipo) {
            tipoProblemaDto.tipo = tipo;
            return this;
        }
        public  Builder tiempoEnDias(Integer tiempoEnDias) {
            tipoProblemaDto.tiempoEnDias = tiempoEnDias;
            return this;
        }

        public TipoProblemaDto build(){
            return tipoProblemaDto;
        }

    }

}
