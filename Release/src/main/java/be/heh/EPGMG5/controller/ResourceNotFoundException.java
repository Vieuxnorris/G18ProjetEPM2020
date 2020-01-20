package be.heh.EPGMG5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
// permet de mettre une exception spécifique ainsi que la définition de l'exception
@ResponseStatus (value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends Exception {

    /* est un identifiant de version universel pour une Serializable classe, la désérialisation utilise ce numéro pour
    garantir qu'une classe chargée correspond exactement à un objet sérialisé.
    Si aucune correspondance n'est trouvée, un ResourceNotFoundException est lancé.
            */
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}

