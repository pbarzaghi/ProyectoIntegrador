package ar.programa.proyectointegrador.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class ClienteDto {

    private String razonSocial;
    private String cuit;
    private String mail;
    public static  Builder builder() {
        return new  Builder();
    }

    public static class Builder {
       private static ClienteDto clienteDto;

        private Builder() {
            this.clienteDto = new ClienteDto();
        }

        public Builder razonSocial(String razonSocial) {
            clienteDto.razonSocial = razonSocial;
            return this;
        }
        public Builder cuit(String cuit) {
            clienteDto.cuit = cuit;
            return this;
        }

        public Builder mail(String mail) {
            clienteDto.mail = mail;
            return this;
        }
        public ClienteDto build(){
            return clienteDto;
        }

    }
}
