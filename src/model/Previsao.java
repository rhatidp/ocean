/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 *
 * @author Grupo Gambiarra
 */
abstract class Previsao {

    protected int codCidade;
    protected String dia;
    
    /**
     * @return the codCidade
     */
    public int getCodCidade() {
        return codCidade;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCodCidade(int cidade) {
        this.codCidade = cidade;
    }


    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }   
       
}