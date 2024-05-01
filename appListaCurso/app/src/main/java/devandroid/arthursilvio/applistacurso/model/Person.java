package devandroid.arthursilvio.applistacurso.model;

//Classe
public class Person {
    //metodos - getts and setts
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    //atributs
    private String firstName;
    private String surname;
    private String curse;
    private String tell;

    //construtor
    public Person() {

    }

    //to string - Para Textos (OBJETO PAI)
    // herança - polimorfismo (varias formas)
//    @Override
//    public String toString() {
//        return "Seus dados:" +
//                " Primeiro Nome: '" + firstName + '\'' +
//                ", Sobrenome: '" + surname + '\'' +
//                ", Curso: '" + curse + '\'' +
//                ", Telefone: '" + tell + '\'' +
//                '}';
}