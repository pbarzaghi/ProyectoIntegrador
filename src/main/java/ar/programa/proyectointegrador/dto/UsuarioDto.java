package ar.programa.proyectointegrador.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UsuarioDto {

    private String nombreUsuario;
    private String pass;
    private Integer tipousuario;

    public static Builder builder() {
        return new  Builder();
    }

    public static class Builder {
        private static UsuarioDto usuarioDto;

        private Builder() {
            usuarioDto = new UsuarioDto();
        }

        public  Builder nombreUsuario(String nombreUsuario) {
            usuarioDto.nombreUsuario = nombreUsuario;
            return this;
        }
        public Builder pass(String pass) {
            usuarioDto.pass = pass;
            return this;
        }
        public Builder tipousuario(Integer tipousuario) {
            usuarioDto.tipousuario = tipousuario;
            return this;
        }

        public UsuarioDto build(){
            return usuarioDto;
        }

    }

}
