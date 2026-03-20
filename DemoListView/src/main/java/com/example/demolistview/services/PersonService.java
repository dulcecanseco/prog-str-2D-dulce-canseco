package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines(); //recupera als lineas del archivo
        List<String> result = new ArrayList<>(); //el listado de resultado con eel formato deseado
        for(String line : lines){
            if(line==null || line.isBlank()) continue; //ignora las lineas nulas

            String[] parts = line.split("," , -1);
            String name = parts[0].trim(); //obtiene el nombre del arreglo
            String correo = parts[1].trim(); //obtiene el correo del arreglo
            String edad = parts[2].trim();

            result.add(name+"-"+correo+"-"+edad); //Se agrega a la lista de resultados con el formato deseado
        }
        return result;

    }

    public void addPerson(String name, String email, String edad) throws IOException {
        validatePerson(name,email,edad);
        String nameNoComa= name.replace(",","");
        String emailNoComa= email.replace(",","");
        String edadNoComa= edad.replace("","");
        repo.appendNewLine(nameNoComa+","+ emailNoComa+","+ edadNoComa);
    }

public void updatePerson(int index, String name, String email, String edad) throws IOException {
    List<String> lines = getAllCleanLines();
    if (index == -1) {
        throw new IllegalArgumentException("El indice recibido es invalido");
    }
    lines.set(index, name + "," + email + "," + edad );
    repo.appendAllLines(lines);
}

public void deletePerson(int index) throws IOException {
        List<String> lines = getAllCleanLines();
        lines.remove(index);
        repo.appendAllLines(lines);
}

    private List<String> getAllCleanLines() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : lines){
            if(line!= null && !line.isBlank()){
        cleanLines.add(line);
            }
        }
        return cleanLines;
    }


    private void validatePerson(String name, String email, String edad){

        if(name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El correo es incorrecto");
        }
        try {
            int valorEdad = Integer.parseInt(edad.trim());

            if (valorEdad < 18) {
                throw new IllegalArgumentException("La persona debe ser mayor o igual a 18 años");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser un dato numérico");
        }
    }


}
