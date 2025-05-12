package br.com.germanott.cursos_api.modules.curso.entities;

public enum CursoActive {
    ACTIVE("0"),
    INACTIVE("1");

    private String status;

    CursoActive(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
